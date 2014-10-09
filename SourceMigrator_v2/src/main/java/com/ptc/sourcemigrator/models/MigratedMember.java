package com.ptc.sourcemigrator.models;

public class MigratedMember {
	private Member member;
	private String date, newMemberRevision;
	
	public MigratedMember(Member member, String date, String newMemberRevision) {
		super();
		this.member = member;
		this.date = date;
		this.newMemberRevision = newMemberRevision;
	}
	public String getDate() {
		return date;
	}
	public Member getMember() {
		return member;
	}
	public String getNewMemberRevision() {
		return newMemberRevision;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void setNewMemberRevision(String newMemberRevision) {
		this.newMemberRevision = newMemberRevision;
	}
	@Override
	public String toString() {
		return "MigratedMember [member=" + member + ", date=" + date
				+ ", newMemberRevision=" + newMemberRevision + "]";
	}
}
