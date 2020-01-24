package com.POYLO.web.jdbc;

public class Human {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_Name() {
		return first_Name;
	}
	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}
	public String getLast_Name() {
		return last_Name;
	}
	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	@Override
	public String toString() {
		return "Human [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", statut=" + statut
				+ "]";
	}
	
	
	public Human(int id, String first_Name, String last_Name, String statut) {
		super();
		this.id = id;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.statut = statut;
	}

	
	public Human(String first_Name, String last_Name, String statut) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.statut = statut;
	}

	private int id;
	private String first_Name;
	private String last_Name;
	private String statut;
}
