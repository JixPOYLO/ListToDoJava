package com.POYLO.web.jdbc;

public class Todolist {
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	

	@Override
	public String toString() {
		return "Todolist [id=" + id + ", description=" + description + ", done=" + done + "]";
	}

	public Todolist(int id, String description, boolean done) {
		super();
		this.id = id;
		this.description = description;
		this.done = done;
	}

	
	public Todolist(int id,String description ) {
		super();
		this.description = description;
		this.id = id;
	}

	public Todolist(String description) {
		super();
		this.description = description;
	}

	private int id;
	private String description;
	private boolean done ;

}
