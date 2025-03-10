package com.yaksha.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yaksha.assignment.models.Task;
import com.yaksha.assignment.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	// Get all tasks
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	// Get a task by ID
	public Task getTaskById(long id) {
		return taskRepository.findById(id);
	}

	// Add a new task
	public void addTask(Task task) {
		taskRepository.save(task);
		System.out.println(taskRepository.findAll().get(0).getName());
	}

	// Update an existing task
	public void updateTask(Task task) {
		taskRepository.save(task);
	}

	// Delete a task
	public void deleteTask(long id) {
		taskRepository.delete(id);
	}
}
