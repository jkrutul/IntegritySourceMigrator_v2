package com.ptc.sourcemigrator.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.util.HibernateUtil;

import com.ptc.sourcemigrator.database.contracts.MemberContract;
import com.ptc.sourcemigrator.database.contracts.ProjectContract;
import com.ptc.sourcemigrator.models.Author;
import com.ptc.sourcemigrator.models.Book;
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
	
	public void insertProject(Project project) {
		session.save(project);
	}
	
	public void insertMember(Member member){
		session.save(member);
	}
	
	public Project selectProject(String projectName) {
		Query query = session.createQuery("from "+ProjectContract.TABLE_NAME+" where "+ProjectContract.NAME+" = :name");
		query.setParameter("name", projectName);
		List<?> list = query.list();
		if (!list.isEmpty()) {
			return (Project) list.get(0);
		} else {
			return null;
		}		
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
	
	public List<Project> selectProjects() {
		Query query = session.createQuery("from "+ProjectContract.TABLE_NAME);
		return query.list();
	}
	
	public List<Member> selectMembers() {
		Query query = session.createQuery("from "+MemberContract.TABLE_NAME);
		return query.list();
	}
	
	
	
	public void close(){
		session.getTransaction().commit();
	}
	
}
