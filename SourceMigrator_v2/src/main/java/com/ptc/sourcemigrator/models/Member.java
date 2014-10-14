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
				+ ", attributes=" + attributes + ", lastMigrated="
				+ lastMigrated + ", project=" + project + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((canonicalMember == null) ? 0 : canonicalMember.hashCode());
		result = prime
				* result
				+ ((canonicalSandbox == null) ? 0 : canonicalSandbox.hashCode());
		result = prime * result
				+ ((cpsummary == null) ? 0 : cpsummary.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime
				* result
				+ ((developmentBranch == null) ? 0 : developmentBranch
						.hashCode());
		result = prime * result + ((frozen == null) ? 0 : frozen.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result
				+ ((lastMigrated == null) ? 0 : lastMigrated.hashCode());
		result = prime * result
				+ ((lockrecord == null) ? 0 : lockrecord.hashCode());
		result = prime * result
				+ ((locksandbox == null) ? 0 : locksandbox.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result
				+ ((memberName == null) ? 0 : memberName.hashCode());
		result = prime
				* result
				+ ((memberRevLocedByMe == null) ? 0 : memberRevLocedByMe
						.hashCode());
		result = prime * result
				+ ((memberRevision == null) ? 0 : memberRevision.hashCode());
		result = prime * result + ((merge == null) ? 0 : merge.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((newRevDelta == null) ? 0 : newRevDelta.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result
				+ ((projectDevpath == null) ? 0 : projectDevpath.hashCode());
		result = prime * result
				+ ((projectName == null) ? 0 : projectName.hashCode());
		result = prime * result
				+ ((revisionrule == null) ? 0 : revisionrule.hashCode());
		result = prime * result
				+ ((revsyncDelta == null) ? 0 : revsyncDelta.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result
				+ ((symboliclink == null) ? 0 : symboliclink.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((wfdelta == null) ? 0 : wfdelta.hashCode());
		result = prime
				* result
				+ ((workingRevLockedByMe == null) ? 0 : workingRevLockedByMe
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (canonicalMember == null) {
			if (other.canonicalMember != null)
				return false;
		} else if (!canonicalMember.equals(other.canonicalMember))
			return false;
		if (canonicalSandbox == null) {
			if (other.canonicalSandbox != null)
				return false;
		} else if (!canonicalSandbox.equals(other.canonicalSandbox))
			return false;
		if (cpsummary == null) {
			if (other.cpsummary != null)
				return false;
		} else if (!cpsummary.equals(other.cpsummary))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (developmentBranch == null) {
			if (other.developmentBranch != null)
				return false;
		} else if (!developmentBranch.equals(other.developmentBranch))
			return false;
		if (frozen == null) {
			if (other.frozen != null)
				return false;
		} else if (!frozen.equals(other.frozen))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (lastMigrated == null) {
			if (other.lastMigrated != null)
				return false;
		} else if (!lastMigrated.equals(other.lastMigrated))
			return false;
		if (lockrecord == null) {
			if (other.lockrecord != null)
				return false;
		} else if (!lockrecord.equals(other.lockrecord))
			return false;
		if (locksandbox == null) {
			if (other.locksandbox != null)
				return false;
		} else if (!locksandbox.equals(other.locksandbox))
			return false;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (memberName == null) {
			if (other.memberName != null)
				return false;
		} else if (!memberName.equals(other.memberName))
			return false;
		if (memberRevLocedByMe == null) {
			if (other.memberRevLocedByMe != null)
				return false;
		} else if (!memberRevLocedByMe.equals(other.memberRevLocedByMe))
			return false;
		if (memberRevision == null) {
			if (other.memberRevision != null)
				return false;
		} else if (!memberRevision.equals(other.memberRevision))
			return false;
		if (merge == null) {
			if (other.merge != null)
				return false;
		} else if (!merge.equals(other.merge))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newRevDelta == null) {
			if (other.newRevDelta != null)
				return false;
		} else if (!newRevDelta.equals(other.newRevDelta))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (projectDevpath == null) {
			if (other.projectDevpath != null)
				return false;
		} else if (!projectDevpath.equals(other.projectDevpath))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		if (revisionrule == null) {
			if (other.revisionrule != null)
				return false;
		} else if (!revisionrule.equals(other.revisionrule))
			return false;
		if (revsyncDelta == null) {
			if (other.revsyncDelta != null)
				return false;
		} else if (!revsyncDelta.equals(other.revsyncDelta))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (symboliclink == null) {
			if (other.symboliclink != null)
				return false;
		} else if (!symboliclink.equals(other.symboliclink))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (wfdelta == null) {
			if (other.wfdelta != null)
				return false;
		} else if (!wfdelta.equals(other.wfdelta))
			return false;
		if (workingRevLockedByMe == null) {
			if (other.workingRevLockedByMe != null)
				return false;
		} else if (!workingRevLockedByMe.equals(other.workingRevLockedByMe))
			return false;
		return true;
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
