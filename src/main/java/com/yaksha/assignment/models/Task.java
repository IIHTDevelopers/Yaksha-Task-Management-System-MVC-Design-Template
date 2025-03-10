package com.yaksha.assignment.models;

public class Task {

	private long id;
	private String name;
	private String description;

	// Constructors
	public Task() {
	}

	public Task(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}
