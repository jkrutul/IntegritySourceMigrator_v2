package com.ptc.sourcemigrator.models;

import java.util.Map;

public class Member {
	private Long memberId;
	
	private String  name, memberName, parent, type,
					memberRevLocedByMe, workingRevLockedByMe,
					lockrecord, wfdelta, revsyncDelta,
					newRevDelta, merge, canonicalSandbox,
					canonicalMember,projectDevpath, date,
					frozen, author, projectName, developmentBranch,
					state, description, memberRevision, cpsummary,
					labels, locksandbox, symboliclink, revisionrule, attributes,
					lastMigrated;
	
	public String getDevelopmentBranch() {
		return developmentBranch;
	}

	public void setDevelopmentBranch(String developmentBranch) {
		this.developmentBranch = developmentBranch;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMemberRevision() {
		return memberRevision;
	}

	public void setMemberRevision(String memberRevision) {
		this.memberRevision = memberRevision;
	}

	public String getCpsummary() {
		return cpsummary;
	}

	public void setCpsummary(String cpsummary) {
		this.cpsummary = cpsummary;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getLocksandbox() {
		return locksandbox;
	}

	public void setLocksandbox(String locksandbox) {
		this.locksandbox = locksandbox;
	}

	public String getSymboliclink() {
		return symboliclink;
	}

	public void setSymboliclink(String symboliclink) {
		this.symboliclink = symboliclink;
	}

	public String getRevisionrule() {
		return revisionrule;
	}

	public void setRevisionrule(String revisionrule) {
		this.revisionrule = revisionrule;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	private Project project;
	
	public Member() {
		
	}

	public Member(Map<String, String> memberPrefs) {
		for (String field : memberPrefs.keySet()) {
			String value = memberPrefs.get(field);
			if (field.equals("name")) {
				setName(value);
			} else if (field.equals("membername")) {
				setMemberName(value);
			} else if (field.equals("parent")) {
				setParent(value);
			} else if (field.equals("type")) {
				setType(value);
			} else if (field.equals("memberrev") || field.equals("memberrevision")) {
				setMemberRevision(value);
			} else if (field.equals("memberrevlockedbyme")) {
				setMemberRevLocedByMe(value);
			} else if (field.equals("workingrevlockedbyme")) {
				setWorkingRevLockedByMe(value);
			}else if (field.equals("lockrecord")) {
				setLockrecord(value);
			}else if (field.equals("wfdelta")) {
				setWfdelta(value);
			}else if (field.equals("revsyncdelta")) {
				setRevsyncDelta(value);
			}else if (field.equals("newrevdelta")) {
				setNewRevDelta(value);
			}else if (field.equals("merge")) {
				setMerge(value);
			}else if (field.equals("canonicalSandbox")) {
				setCanonicalSandbox(value);
			}else if (field.equals("canonicalMember")) {
				setCanonicalMember(value);
			}else if (field.equals("projectDevpath")) {
				setProjectDevpath(value);
			}else if (field.equals("date")) {
				setDate(value);
			}else if (field.equals("frozen")) {
				setFrozen(value);
			}else if (field.equals("author")) {
				setAuthor(value);
			}else if (field.equals("projectname")) {
				setProjectName(value);
			}else if (field.equals("developmentbranch")) {
				setDevelopmentBranch(value);
			}else if (field.equals("state")) {
				setState(value);
			}else if (field.equals("description")) {
				setDescription(value);
			}else if (field.equals("memberrevision")) {
				setMemberRevision(value);
			}else if (field.equals("cpsummary")) {
				setCpsummary(value);
			}else if (field.equals("labels")) {
				setLabels(value);
			}else if (field.equals("locksandbox")) {
				setLocksandbox(value);
			}else if (field.equals("symboliclink")) {
				setSymboliclink(value);
			}else if (field.equals("revisionrule")) {
				setRevisionrule(value);
			}else if (field.equals("attributes")) {
				setAttributes(value);
			}	
		}
	}

	public void addMemberProps(Map<String, String> memberProps) {
		for (String field : memberProps.keySet()) {
			String value = memberProps.get(field);

			
			if (field.equals("name")) {
				setName(value);
			} else if (field.equals("membername")) {
				setMemberName(value);
			} else if (field.equals("parent")) {
				setParent(value);
			} else if (field.equals("type")) {
				setType(value);
			} else if (field.equals("memberrev") || field.equals("memberrevision")) {
				setMemberRevision(value);
			} else if (field.equals("memberrevlockedbyme")) {
				setMemberRevLocedByMe(value);
			} else if (field.equals("workingrevlockedbyme")) {
				setWorkingRevLockedByMe(value);
			}else if (field.equals("lockrecord")) {
				setLockrecord(value);
			}else if (field.equals("wfdelta")) {
				setWfdelta(value);
			}else if (field.equals("revsyncdelta")) {
				setRevsyncDelta(value);
			}else if (field.equals("newrevdelta")) {
				setNewRevDelta(value);
			}else if (field.equals("merge")) {
				setMerge(value);
			}else if (field.equals("canonicalSandbox")) {
				setCanonicalSandbox(value);
			}else if (field.equals("canonicalMember")) {
				setCanonicalMember(value);
			}else if (field.equals("projectDevpath")) {
				setProjectDevpath(value);
			}else if (field.equals("date")) {
				setDate(value);
			}else if (field.equals("frozen")) {
				setFrozen(value);
			}else if (field.equals("author")) {
				setAuthor(value);
			}else if (field.equals("projectname")) {
				setProjectName(value);
			}else if (field.equals("developmentbranch")) {
				setDevelopmentBranch(value);
			}else if (field.equals("state")) {
				setState(value);
			}else if (field.equals("description")) {
				setDescription(value);
			}else if (field.equals("memberrevision")) {
				setMemberRevision(value);
			}else if (field.equals("cpsummary")) {
				setCpsummary(value);
			}else if (field.equals("labels")) {
				setLabels(value);
			}else if (field.equals("locksandbox")) {
				setLocksandbox(value);
			}else if (field.equals("symboliclink")) {
				setSymboliclink(value);
			}else if (field.equals("revisionrule")) {
				setRevisionrule(value);
			}else if (field.equals("attributes")) {
				setAttributes(value);
			}	
		}
	}

	public String getAuthor() {
		return author;
	}

	public String getCanonicalMember() {
		return canonicalMember;
	}
	
	public String getCanonicalSandbox() {
		return canonicalSandbox;
	}
	
	public String getDate() {
		return date;
	}

	public String getFrozen() {
		return frozen;
	}

	public String getLockrecord() {
		return lockrecord;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMemberRevLocedByMe() {
		return memberRevLocedByMe;
	}

	public String getMerge() {
		return merge;
	}

	public String getName() {
		return name;
	}

	public String getNewRevDelta() {
		return newRevDelta;
	}

	public String getParent() {
		return parent;
	}

	public String getProjectDevpath() {
		return projectDevpath;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getRevsyncDelta() {
		return revsyncDelta;
	}

	public String getType() {
		return type;
	}

	public String getWfdelta() {
		return wfdelta;
	}

	public String getWorkingRevLockedByMe() {
		return workingRevLockedByMe;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setCanonicalMember(String canonicalMember) {
		this.canonicalMember = canonicalMember;
	}

	public void setCanonicalSandbox(String canonicalSandbox) {
		this.canonicalSandbox = canonicalSandbox;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}

	public void setLockrecord(String lockrecord) {
		this.lockrecord = lockrecord;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setMemberRevLocedByMe(String memberRevLocedByMe) {
		this.memberRevLocedByMe = memberRevLocedByMe;
	}

	public void setMerge(String merge) {
		this.merge = merge;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNewRevDelta(String newRevDelta) {
		this.newRevDelta = newRevDelta;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public void setProjectDevpath(String projectDevpath) {
		this.projectDevpath = projectDevpath;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setRevsyncDelta(String revsyncDelta) {
		this.revsyncDelta = revsyncDelta;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setWfdelta(String wfdelta) {
		this.wfdelta = wfdelta;
	}

	public void setWorkingRevLockedByMe(String workingRevLockedByMe) {
		this.workingRevLockedByMe = workingRevLockedByMe;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name
				+ ", memberName=" + memberName + ", parent=" + parent
				+ ", type=" + type + ", memberRevLocedByMe="
				+ memberRevLocedByMe + ", workingRevLockedByMe="
				+ workingRevLockedByMe + ", lockrecord=" + lockrecord
				+ ", wfdelta=" + wfdelta + ", revsyncDelta=" + revsyncDelta
				+ ", newRevDelta=" + newRevDelta + ", merge=" + merge
				+ ", canonicalSandbox=" + canonicalSandbox
				+ ", canonicalMember=" + canonicalMember + ", projectDevpath="
				+ projectDevpath + ", date=" + date + ", frozen=" + frozen
				+ ", author=" + author + ", projectName=" + projectName
				+ ", developmentBranch=" + developmentBranch + ", state="
				+ state + ", description=" + description + ", memberRevision="
				+ memberRevision + ", cpsummary=" + cpsummary + ", labels="
				+ labels + ", locksandbox=" + locksandbox + ", symboliclink="
				+ symboliclink + ", revisionrule=" + revisionrule
				+ ", attributes=" + attributes + ", project=" + project + "]";
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getLastMigrated() {
		return lastMigrated;
	}

	public void setLastMigrated(String lastMigrated) {
		this.lastMigrated = lastMigrated;
	}

}
