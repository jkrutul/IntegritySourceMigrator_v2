package com.ptc.sourcemigrator.models;

public class MigratedProject {
	private Project project;
	private String date, newProjectRevision;
	public MigratedProject(Project project, String date,
			String newProjectRevision) {
		super();
		this.project = project;
		this.date = date;
		this.newProjectRevision = newProjectRevision;
	}
	
	public String getDate() {
		return date;
	}
	public String getNewProjectRevision() {
		return newProjectRevision;
	}
	public Project getProject() {
		return project;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setNewProjectRevision(String newProjectRevision) {
		this.newProjectRevision = newProjectRevision;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "MigratedProject [project=" + project + ", date=" + date
				+ ", newProjectRevision=" + newProjectRevision + "]";
	}
}
