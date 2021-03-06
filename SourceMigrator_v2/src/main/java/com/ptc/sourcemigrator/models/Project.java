package com.ptc.sourcemigrator.models;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Project {
	private Long projectId;
	private String  name,
			path, isSubproject, isShared, parent,
			isVariant, isBuild, buildRevision, revision, server,
			fullConfigSyntax, projectType, numSubprojects,
			sharedFrom, serverPort, lastCheckpoint, projectAnnotation,
			lastMigrated;

	private String developmentPaths;


	public Project() {
		
	}


	public Project(Map<String,String> projectProps) {
		for (String field : projectProps.keySet()) {
			String value = projectProps.get(field);
			if (field.equals("projectName")) {
				setName(value);
			} else if (field.equals("canonicalPath")) {
				setPath(value);
			} else if (field.equals("isSubproject")) {
				setIsSubproject(value);
			} else if (field.equals("isShared")) {
				setIsShared(value);
			} else if (field.equals("parentProject")) {
				setParent(value);
			} else if (field.equals("isVariant")) {
				setIsVariant(value);
			} else if (field.equals("developmentPath") || field.equals("developmentPaths")) {
				setDevelopmentPath(value);
			}else if (field.equals("isBuild")) {
				setIsBuild(value);
			}else if (field.equals("buildRevision")) { 
				setBuildRevision(value);
			} else if (field.equals("lastCheckpoint")) {
				setLastCheckpoint(value);
			}else if (field.equals("projectAnnotation")) {
				setProjectAnnotation(value);
			}else if (field.equals("sharedFrom")) {
				setSharedFrom(value);
			}else if (field.equals("fullConfigSyntax")) {
				setFullConfigSyntax(value);
			}else if (field.equals("projectType")) {
				setProjectType(value);
			}else if (field.equals("numSubprojects")) {
				setNumSubprojects(value);
			}else if (field.equals("serverPort")) {
				setServerPort(value);
			} else if (field.equals("revision") ) {
				setRevision(value);
			}
		}
	}


	public Project(String name, String path, String isSubproject,
			String isShared, String parent, String isVariant,
			String developmentPath, String isBuild, String buildRevision) {
		super();
		this.name = name;
		this.path = path;
		this.isSubproject = isSubproject;
		this.isShared = isShared;
		this.parent = parent;
		this.isVariant = isVariant;
		this.developmentPaths = developmentPath;
		/*
		String[] devPaths = developmentPath.split(",");
		for(String devPath : devPaths) {
			developmentPaths.add(devPath);
		}
		*/
		this.isBuild = isBuild;
		this.buildRevision = buildRevision;
	}


	public void addProjectProps(Map<String,String> projectProps) {
		for (String field : projectProps.keySet()) {
			String value = projectProps.get(field);
			
			if (field.equals("projectName")) {
				setName(value);
			} else if (field.equals("canonicalPath")) {
				setPath(value);
			} else if (field.equals("isSubproject")) {
				setIsSubproject(value);
			} else if (field.equals("isShared")) {
				setIsShared(value);
			} else if (field.equals("parentProject")) {
				setParent(value);
			} else if (field.equals("isVariant")) {
				setIsVariant(value);
			} else if (field.equals("developmentPaths")) {
				setDevelopmentPath(value);
			}else if (field.equals("isBuild")) {
				setIsBuild(value);
			}else if (field.equals("buildRevision")) {
				setBuildRevision(value);
			}else if (field.equals("server")) {
				setServer(value);
			} else if (field.equals("lastCheckpoint")) {
				setLastCheckpoint(value);
			}else if (field.equals("projectAnnotation")) {
				setProjectAnnotation(value);
			}else if (field.equals("sharedFrom")) {
				setSharedFrom(value);
			}else if (field.equals("fullConfigSyntax")) {
				setFullConfigSyntax(value);
			}else if (field.equals("projectType")) {
				setProjectType(value);
			}else if (field.equals("numSubprojects")) {
				setNumSubprojects(value);
			}else if (field.equals("serverPort")) {
				setServerPort(value);
			} else if (field.equals("revision") ) {
				setRevision(value);
			}
		}
	}


	public String getBuildRevision() {
		return buildRevision;
	}

	public String getDevelopmentPaths() {
		return developmentPaths;
	}


	public String getFullConfigSyntax() {
		return fullConfigSyntax;
	}


	public String getIsBuild() {
		return isBuild;
	}


	public String getIsShared() {
		return isShared;
	}


	public String getIsSubproject() {
		return isSubproject;
	}


	public String getIsVariant() {
		return isVariant;
	}


	public String getLastCheckpoint() {
		return lastCheckpoint;
	}


	public String getName() {
		return name;
	}


	public String getNumSubprojects() {
		return numSubprojects;
	}


	public String getParent() {
		return parent;
	}
	public String getPath() {
		return path;
	}
	

	public String getProjectAnnotation() {
		return projectAnnotation;
	}


	public Long getProjectId() {
		return projectId;
	}
	
	public String getProjectType() {
		return projectType;
	}

	public String getServer() {
		return server;
	}

	public String getServerPort() {
		return serverPort;
	}

	public String getSharedFrom() {
		return sharedFrom;
	}

	public void setBuildRevision(String buildRevision) {
		this.buildRevision = buildRevision;
	}

	public void setDevelopmentPath(String developmentPath) {
		this.developmentPaths = developmentPath;
		/*
		if (developmentPath != null)
		this.developmentPaths.add(developmentPath);
		*/
	}

	public void setDevelopmentPaths(String developmentPaths) {
		this.developmentPaths = developmentPaths;
	}

	public void setFullConfigSyntax(String fullConfigSyntax) {
		this.fullConfigSyntax = fullConfigSyntax;
	}

	public void setIsBuild(String isBuild) {
		this.isBuild = isBuild;
	}

	public void setIsShared(String isShared) {
		this.isShared = isShared;
	}

	public void setIsSubproject(String isSubproject) {
		this.isSubproject = isSubproject;
	}

	public void setIsVariant(String isVariant) {
		this.isVariant = isVariant;
	}

	public void setLastCheckpoint(String lastCheckpoint) {
		this.lastCheckpoint = lastCheckpoint;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumSubprojects(String numSubprojects) {
		this.numSubprojects = numSubprojects;
	}

	public void setParent(String parent) {
		this.parent = parent;  
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setProjectAnnotation(String projectAnnotation) {
		this.projectAnnotation = projectAnnotation;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}





	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}


	public void setServer(String server) {
		this.server = server;
	}


	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}


	public void setSharedFrom(String sharedFrom) {
		this.sharedFrom = sharedFrom;
	}





	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", path="
				+ path + ", isSubproject=" + isSubproject + ", isShared="
				+ isShared + ", parent=" + parent + ", isVariant=" + isVariant
				+ ", isBuild=" + isBuild + ", buildRevision=" + buildRevision
				+ ", revision=" + revision + ", server=" + server
				+ ", fullConfigSyntax=" + fullConfigSyntax + ", projectType="
				+ projectType + ", numSubprojects=" + numSubprojects
				+ ", sharedFrom=" + sharedFrom + ", serverPort=" + serverPort
				+ ", lastCheckpoint=" + lastCheckpoint + ", projectAnnotation="
				+ projectAnnotation + ", developmentPaths=" + developmentPaths
				+ "]";
	}


	public String getRevision() {
		return revision;
	}


	public void setRevision(String revision) {
		this.revision = revision;
	}


	public String getLastMigrated() {
		return lastMigrated;
	}


	public void setLastMigrated(String lastMigrated) {
		this.lastMigrated = lastMigrated;
	}
}
