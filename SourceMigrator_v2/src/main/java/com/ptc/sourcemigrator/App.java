package com.ptc.sourcemigrator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.util.HibernateUtil;

import com.ptc.sourcemigrator.models.Project;


public class App {

	public static void main(String[] args) {
		ConsoleClient cc = new ConsoleClient();
		
		//String projectName = "/IntegrityA/B/B2/subProjectFilesiii/project.pj";
		//SourceMigrator sm = new SourceMigrator();
		//sm.exportProjectFromServerToDatabase("/Calculator/project.pj");
		//sm.exportProjectFromServerToDatabase(projectName);
		//sm.exportDataToFile(projectName);
		//sm.exportProjectFromServerToDatabase(projectName);
		
		/*
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		createProject(session);
		queryProject(session);
		
		session.getTransaction().commit();
		
		*/
		
	}
	
	public static void queryProject(Session session) {
		Query query = session.createQuery("from Project");
		List<Project> projects = query.list();
		for (Project p : projects) {
			System.out.println(p);
		}
	}
	
	public static void createProject(Session session) {
		Project p = new Project();
		p.setName("Projekt");
		p.setIsBuild("true");
		session.save(p);
	}

}
