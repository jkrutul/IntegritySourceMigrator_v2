package com.ptc.sourcemigrator.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.util.HibernateUtil;

import com.ptc.sourcemigrator.database.contracts.MemberContract;
import com.ptc.sourcemigrator.database.contracts.ProjectContract;
import com.ptc.sourcemigrator.models.Member;
import com.ptc.sourcemigrator.models.Project;

public class Database {
	private Session session;
	
	
	public Database(){
		this.session = HibernateUtil.getSessionFactory().getCurrentSession();
		this.session.beginTransaction();
	}
	
	public Session getSession(){
		return this.session;
	}

	public void save(Object o){
		session.save(o);
	}
	
	public Object get(Class c, Long id) {
		return session.get(c, id);
	}
	
	public List<Project> selectProject(String projectName) {
		Query query = session.createQuery("from "+ProjectContract.TABLE_NAME+" where "+ProjectContract.NAME+" = :name");
		query.setParameter("name", projectName);
		return query.list();
	}
	
	public List<String> selectProjectRevisions(String projectName) {
		Query query = session.createQuery("select project.revision from "+ProjectContract.TABLE_NAME+" project where "+ProjectContract.NAME+" = :name");
		query.setParameter("name", projectName);
		return query.list();
	}
	
	public Member selectMember(String memberName) {
		Query query = session.createQuery("from "+MemberContract.TABLE_NAME+" where "+MemberContract.NAME+" = :name");
		query.setParameter("name", memberName);
		List<?> list = query.list();
		if (!list.isEmpty()) {
			return (Member) list.get(0);
		} else {
			return null;
		}		
	}
	
	public  List<Project> selectProjects() {
		Query query = session.createQuery("from "+ProjectContract.TABLE_NAME);
		return query.list();
	}
	
	public List<Project> selectProject( String projectName , String projectRevision ){
		Query query = session.createQuery("from " +ProjectContract.TABLE_NAME + " where " + ProjectContract.NAME + " LIKE :projectName AND " +ProjectContract.REVISION + " LIKE :projectRevision" );
		query.setParameter("projectName", projectName);
		query.setParameter("projectRevision", projectRevision );
		return query.list();
		
	}
	
	public List<Member> selectMembers() {
		Query query = session.createQuery("from "+MemberContract.TABLE_NAME);
		return query.list();
	}
	
	public List<Member> selectMembers(Project project) {
		Query query = session.createQuery("from "+MemberContract.TABLE_NAME+" where "+MemberContract.PROJECT+" = :project");
		query.setParameter("project", project);
		
		return query.list();
	}
	
	public void close(){
		session.getTransaction().commit();
	}
	
}
