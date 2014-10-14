package com.ptc.sourcemigrator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.mks.api.response.APIException;
import com.ptc.sourcemigrator.database.Database;
import com.ptc.sourcemigrator.models.Member;
import com.ptc.sourcemigrator.models.Project;
import com.ptc.sourcemigrator.models.Sandbox;
import com.ptc.sourcemigrator.utils.APIUtils;
import com.ptc.sourcemigrator.utils.Utils;

public class SourceMigrator {
	public static final String PROPERTIES_FILE = "sm.properties";
	public static String sourceServer, destinationServer, appDir, srcHostname, destHostname, srcPort, destPort, srcUser, destUser, srcPassword, destPassword, rootForMigratedProjects;
	public static CompositeConfiguration config;
	private Logger log = LogManager.getLogger(App.class.getName());

	public static APIUtils src, dest;
	public static  Database db;
	
	
	public SourceMigrator() {
		System.out.println("********** Integrity Source Migratoin Tool **********");
		config = new CompositeConfiguration();
		config.addConfiguration(new SystemConfiguration());
		File f = null;
		appDir = System.getProperty("user.dir");
		if (appDir != null) {
			f = new File(appDir+File.separator+PROPERTIES_FILE);
			if (f.canRead()) {
				try {
					config.addConfiguration(new PropertiesConfiguration(f.getAbsoluteFile()));
				} catch (org.apache.commons.configuration.ConfigurationException e) {
					e.printStackTrace();
				}
				log.debug("Added configuration from: " + f.getAbsoluteFile());
			} else {
				log.error("Configuration file: "+ f.getAbsoluteFile()+ " doesn't exist");
			}
		}
				
		srcHostname = config.getString("SOURCE_SERVER");
		destHostname = config.getString("DESTINATION_SERVER");
		srcPort = config.getString("SOURCE_PORT","7001");
		destPort = config.getString("DESTINATION_PORT","7001");
		srcUser = config.getString("SOURCE_USER");
		destUser = config.getString("DESTINATION_USER");
		srcPassword = config.getString("SOURCE_PASSWORD");
		destPassword = config.getString("DESTINATION_PASSWORD");
		rootForMigratedProjects = config.getString("ROOT_FOR_MIGRATED_PROJECTS");
		
		src = new APIUtils();
		dest = new APIUtils();
		try {
			src.connectToIntegrity(	srcUser,srcPassword,srcHostname, srcPort);
		} catch (APIException e) {
			log.error(e);
		}
			
	    try {
	    	dest.connectToIntegrity(destUser,destPassword, destHostname, destPort);	
		} catch (APIException e) {
			log.error(e);
		}
	   db = new Database();
	}
	

	
	/***
	 * Export project from src server to database
	 * @param projectName - if project name not specified, exports all projects
	 */
    public void exportProjectFromServerToDatabase(String projectName){   
        //connect to Integrtity servers
    	List<Project> projects = src.getProjects(true, projectName, null);

        
		for (Project project : projects) {
			db.getSession().save(project);
			List<Member> mem = src.getMembers(project.getName(), null, project.getServer());
			for (Member m : mem) {
				m.setProject(project);
				db.getSession().save(m);
			}

			for (String projectRev : src.getProjectRevisions(project.getName())) {

				Project projRev = src.getProjects(true, project.getName(), projectRev).get(0);
				db.getSession().save(projRev);
				List<Member> members = src.getMembers(project.getName(),projectRev, project.getServer());
				for (Member member : members) {
					member.setProject(projRev);
					db.getSession().save(member);
				}
			}
		}
    }
	   
    /**
     * Ends Integrity API sessions and close database
     */
    public void endEndSessionAndCloseDb() {
    	db.close();    	
    	src.endSession();
    	dest.endSession();
    }
    
    /**
     * Export Source data to file
     * @param projectFilter -- if not specified, all project from src server will be exported
     * @param filePath -- path to file
     */
    public void exportDataToFile(String projectFilter, String filePath) {
        PrintWriter writer;
        
		try {
			writer = new PrintWriter(filePath, "UTF-8");
	        List<Project> projects = src.getProjects(true, projectFilter, null);
	  
	        for (Project project : projects) {
	        	List<Member> mem  = src.getMembers(project.getName(), null, null);

	        	writer.println(project);
	        	for (Member member : mem ) {
        			writer.println("\t\t"+member);
        			writer.println("\t\t\tMEMBER REVISIONS: "+src.viewhistory(member.getName(), null, null, null, project.getName()));	        		
        		}
	        	for (String projectRev : src.getProjectRevisions(project.getName())) {
	        		writer.println("\n\tPROJECT REVISION: "+projectRev);
	        		List<Member> members  = src.getMembers(project.getName(), projectRev, null);
	        		for (Member member : members ) {
	        			writer.println("\t\t"+member);
	        			writer.println("\t\t\tMEMBER REVISIONS: "+src.viewhistory(member.getName(), null, null, projectRev, project.getName()));	        		
	        		}
	        	}
	        }
	        writer.close();
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    }
    
    /***
     * Function migrate project from source server to destination server.
     * @param projectName -- project name to be migrated
     * @param migratedProjectLocation -- location on destination server, where project will be save, by default is read from config file
     */
    public void migrateProject(String projectName, String projectRevision,String migratedProjectLocation) {
 
   
    	if (migratedProjectLocation == null) {
    		migratedProjectLocation = rootForMigratedProjects;
    	}
    	Project projectFromSource, projectMigrated;
    	Sandbox sandboxImported, sandboxMigrated;
    	
    	// find project on source server, if not exist return
    	projectFromSource= src.getProject(projectName, null);
    	
    	if ( projectFromSource != null ) {
    		log.info("Found "+projectName+" on " + src.getHostname());
    		log.info(projectFromSource);
    		
    	} else {
    		log.error("Project "+ projectName+ " not exists on " +src.getHostname());
    		return;
    	}
    	
    	// create sandbox to project on source server
    	String tmpSandboxPath = "c:\\sandboxes\\TMP\\imported\\"+new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()); 	 //unique temp dir for migrated project
    	String sandboxname = new File(projectName).getParent();
    	sandboxImported = src.createSandbox(projectName, src.getHostname(), projectRevision, null, tmpSandboxPath+sandboxname );
    	log.info(sandboxImported);

    	// Create project on destination server witch name of migrated project
    	String migratedProjectName = projectName;
    	String prParentDir = "/";
    	
    	String tmpS[] = projectName.split("/");
    	for(int i = 0 ; i<(tmpS.length -1) ; i++) {
    		if(!tmpS[i].isEmpty()) {
    			prParentDir+=tmpS[i]+"/";
    		}
    	}
    	

    	int i= 0;
    	if (dest.getProject(migratedProjectName, null) != null){ // Check whether the project of the same name already exists
	    	for ( ; true; i++) {
	    		log.info("Already found project named "+migratedProjectName+" on "+dest.getHostname()+" server");
	    		if (dest.getProject(prParentDir+"_"+Integer.toString(i)+"/project.pj",null) == null) {
	    			break;
	    		}
	    	}
	    	migratedProjectName = prParentDir+"_"+Integer.toString(i)+"/project.pj";
    	
    	} 
    	projectMigrated = dest.createProject(migratedProjectName);
    	
    	if (projectMigrated != null) {
    		log.info("Created project" + projectMigrated);
    	} else {
    		log.error("Can't create project "+migratedProjectName + " on destination server");
    		return;
    	}

    	// Create sandbox to migrated project on destination server
    	migratedProjectLocation += new File(migratedProjectName).getParent();
    	sandboxMigrated = dest.createSandbox(migratedProjectName, dest.getHostname(), null, null, migratedProjectLocation);
    	
    	if (sandboxMigrated != null ) {
	    	log.info("Sandbox to " +migratedProjectName + " has been created");
	    	log.info(sandboxMigrated);     		
    	} else {
    		log.error("falied to create sandbox");
    		return;
    	}
   	
    	// Copy members to new project dir    	
        String importedDir = new File(sandboxImported.getName()).getParent();
        String migratedDir = new File(sandboxMigrated.getName()).getParent();
        System.out.println("Coping files...");
        try {
			Utils.copyFolder(new File(importedDir), new File(migratedDir));
			File f = new File(sandboxMigrated.getName());
			f.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	// Add members to migrated sandbox
        log.info("Getting memers...");
        List<Member> members = src.getMembers(sandboxImported.getName(), sandboxImported.getHostname());
        
        for (Member member : members) {
        	File oldPath = new File(member.getName());
        	String newPath = oldPath.getAbsolutePath().replace(importedDir, migratedDir);
        	member.setName(newPath);
        	dest.addMember("migrated", sandboxMigrated.getName(), sandboxMigrated.getHostname(), member.getName(), null);
        	
        }

        // Drop importedSandbox, delete importedProject
        log.info("Droping/removing sandbox and project");
    	src.dropSandbox(sandboxImported.getName(), APIUtils.DELETION_POLICY_ALL);
    	//dest.dropProject(projectMigrated.getName());
    	//dest.deleteProject(projectMigrated.getName());

    }

    
    
    
    	/*
        List<String> projectReviosions  = src.getProjectRevisions(projectName);
        
        
        // getProjects 
        for (String rev : projectReviosions) {
        	Project project = src.getProject(projectName, rev);
        	System.out.println(project);
        }
        
        Project project = src.getProject(projectName,null);

    	Sandbox sandbox = src.getSandboxes(project.getName(), project.getServer()).get(0);
    	List<Member> members = src.getMembers(sandbox.getName(), destHostname);
    	
    	for (String prRev : projectReviosions){
    		System.out.println(prRev);
			for (Member member : members) {
			    src.viewhistory(member.getName(), null ,null, prRev, null);
			 }    		
    	}
    	
    	
    	db.save(project);
        for (Member member : members) {
        	member.setProject(project);
        	db.save(member);
        }
        */
        
		
		/*
        for(Project p : db.selectProjects()) {
        	System.out.println(p);
        }
        
        for(Member m : db.selectMembers()) {
        	System.out.println(m);
        }
        
        
        Project project = projects.get(0);
        List<Project> projects2 = db.selectProject(project.getName());
        
        List<String> revisions = db.selectProjectRevisions(project.getName());
        List<Member> members  = db.selectMembers(project);
        for (Member m : members) {
        	System.out.println(m);
        	src.projectCo(m.getName(), project.getName(), project.getRevision(), m.getMemberRevision(), "C:\\PTC\\IntegrityServer10\\data\\tmp\\"+m.getMemberName());
        	
        }
        
        */
        
        
        /*
        
        db.close();
        
        
        
        // getProjectRevisions
        
        // getMembersOfProject
        Sandbox calcSandbox= src.getSandboxes("/Calculator/project.pj", destHostname).get(0);
        List<Member> membersOfProject = dest.getMembers(calcSandbox.getName(), destHostname);
        //Project project = db.selectProject(calcSandbox.getProject());
        
      
        List<Member> membersFromDb = db.selectMembers();
        
        for (Member member : membersFromDb) {
        	System.out.println(member);
        }
        
        */
        
        // getMemberRevision
        

        
        /*
        List<Member> members = dest.getMembers(calcSandbox.getName(), SERVER_DEST);
        long projectId = db.getProjectId("/Calculator/project.pj");
        List<Member> members2 = db.getMembersFromProject(projectId);
        
        for (Member member : members2) {
        	System.out.println(member);
        }
        
        //members = db.getMembersData();
        members = db.getMembersData();
        for(Member member : members) {
            System.out.println(member);
        }
        
        projects = db.getProjectsData();
        
        for (Project project : projects) {
        	System.out.println(project);
        	System.out.println(db.getProjectId(project.getName()));
        }

        */
        
        /*

        String projectToBeMigrated = "/16_09/GenericSourceMigrator/project.pj";
        String dirToFiles = "C:\\projects\\testing\\16_09\\SOURCE";
        
        List<Sandbox> sandboxes = src.getSandboxes("/TEMP/Migrated_11/project.pj", null);
        Sandbox sandbox = null;
        if (!sandboxes.isEmpty()){
        	sandbox = sandboxes.get(0);
        }
        
        List<Member> members = src.getMembers(sandbox.getName(), dest.getHostname());
        Member member = members.get(0);
        //member.get
        //src.addLabel("prototype2", members, null, null, null, null);
        
        src.viewhistory(member.getName(), sandbox.getName(), null, null);
        
        //dest.viewRevision("c:\\sandboxes\\migrated\\2014_09_16_16_32_05\\Utils.java", null, "c:\\sandboxes\\migrated\\2014_09_16_16_32_05\\project.pj",null);
        dest.memberInfo("c:\\sandboxes\\migrated\\2014_09_16_16_32_05\\Utils.java", "/TEMP/Migrated_11/project.pj");
        
         */
        /*            
        src.dropAllSandboxes(src.DELETION_POLICY_ALL);
        src.dropProject(projectToBeMigrated);
        src.deleteProject(projectToBeMigrated);
  

        src.dropProject(projectToBeMigrated);
        src.deleteProject(projectToBeMigrated);
        src.dropSandbox(dirToFiles, src.DELETION_POLICY_NONE);
        
        dest.dropAndDeleteAllProjects();
   
        src.createNewProjectAndSandbox(projectToBeMigrated, null, null, dirToFiles, true);
   */    
        //DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        //Calendar cal = Calendar.getInstance();
        //migrateProject(projectToBeMigrated, src.getHostname(), "C:\\sandboxes\\migrated\\" + dateFormat.format(cal.getTime()));
        
        
     
  
    	
    	//exitAppSuccessfull();

}
