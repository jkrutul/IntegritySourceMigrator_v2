package com.ptc.sourcemigrator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.ptc.sourcemigrator.models.Member;
import com.ptc.sourcemigrator.models.Project;

public class ConsoleClient {
	SourceMigrator sm = new SourceMigrator();
	String menu = "\n----DATABASE----\n"
			+ "1. List all projects \n"
			+ "2. List Members from project\n"
			+ "3. Export project to database\n"
			+ "----SERVER-----\n"
			+ "4. List all projects\n"
			+ "5. List Members from project\n"
			+ "6. Get project revisions\n"
			+ "----APPLICATION----\n"
			+ "7. Migrate project to destination server\n"
			+ "8. Display servers info\n"
			+ "9. Close application.\n"
			+ "Your choice:";
	
	public ConsoleClient() {
		while(true) {
			int selection;
			try {
				selection = Integer.parseInt(readFromCmd(menu));
			} catch (NumberFormatException e) {
				System.out.println("Not a number");
				continue;
			}
			switch (selection) {
			
			case 1: 
				for (Project p : sm.db.selectProject(readFromCmd("Enter project name:"))) {
						System.out.println(p);
					}
				break;
				
			case 2:
				List<Project> projects = sm.db.selectProject(readFromCmd("Enter project name:"));
				Project project = null;
				if (!projects.isEmpty()) {
					project = projects.get(0);
				}
				for (Member m : sm.db.selectMembers(project)) {
					System.out.println(m);
				}
				break;
				
			case 3: 
				sm.exportProjectFromServerToDatabase(readFromCmd("Enter project name:"));
				break;
				
			case 4:
				for(Project p : sm.src.getProjects(true,readFromCmd("Enter project name:") , readFromCmd("Enter project revision:"))){
					System.out.println(p);
				}
				break;
				
			case 5:
				for(Member m : sm.src.getMembers(readFromCmd("Enter project name:"), readFromCmd("Enter project revision:"), sm.src.getHostname())) {
					System.out.println(m);
				}
				break;
			
			case 6:
					System.out.println(sm.src.getProjectRevisions(readFromCmd("Enter project name:")));
				break;
				
			case 7: {//Migrate project 
					String projectName = readFromCmd("Enter project name:");
					String projectRevision = readFromCmd("Enter project revision");
					String rootDir = readFromCmd("Enter path to directory for migrated project");
					sm.migrateProject(projectName, projectRevision, null);
				break;
			}
				
			case 8:
					System.out.println("SOURCE SERVER: ["+sm.src + "]");
					System.out.println("DESTINATION SERVER: ["+sm.dest + "]");
					break;
					
			case 9:
				sm.endEndSessionAndCloseDb();
				return;
				
			default:
				System.out.println("Option: "+selection+ " doesn't exist, please try again");
				break;
			}
		}
	}
		
	private String readFromCmd(String message) {
		System.out.print(message);
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try { 
			String output = br.readLine();
			if (output.isEmpty()) {
				return null;
			} else {
				return output;	
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
