package com.yaksha.assignment.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yaksha.assignment.models.Task;

@Repository
public class TaskRepository {

	private List<Task> tasks = new ArrayList<>();
	private long nextId = 1;

	// Get all tasks
	public List<Task> findAll() {
		return tasks;
	}

	// Find a task by ID
	public Task findById(long id) {
		return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
	}

	// Save a task (add or update)
	public void save(Task task) {
		if (task.getId() == 0) {
			task.setId(nextId++);
			tasks.add(task);
		} else {
			tasks.removeIf(t -> t.getId() == task.getId());
			tasks.add(task);
		}
	}

	// Delete a task
	public void delete(long id) {
		tasks.removeIf(task -> task.getId() == id);
	}
}
