package com.yaksha.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.yaksha.assignment.models.Task;
import com.yaksha.assignment.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	// Display list of tasks
	@GetMapping("/")
	public String viewTasks(Model model) {
		model.addAttribute("tasks", taskService.getAllTasks());
		return "task-list";
	}

	// Show form to add a new task
	@GetMapping("/task/add")
	public String showAddTaskForm(Model model) {
		model.addAttribute("task", new Task());
		return "add-task";
	}

	// Handle form submission to add a new task
	@PostMapping("/task/add")
	public String addTask(@ModelAttribute Task task) {
		taskService.addTask(task);
		return "redirect:/";
	}

	// Show form to edit an existing task
	@GetMapping("/task/edit/{id}")
	public String showEditTaskForm(@PathVariable("id") long id, Model model) {
		Task task = taskService.getTaskById(id); // Fetch the task by ID
		model.addAttribute("task", task); // Add the task to the model
		return "edit-task"; // Return the view for editing
	}

	// Handle form submission to update a task
	@PostMapping("/task/edit/{id}")
	public String updateTask(@PathVariable("id") long id, @ModelAttribute Task task) {
		task.setId(id); // Ensure ID is preserved during edit
		taskService.updateTask(task);
		return "redirect:/";
	}

	// Handle task deletion
	@GetMapping("/task/delete/{id}")
	public String deleteTask(@PathVariable("id") long id) {
		taskService.deleteTask(id);
		return "redirect:/";
	}
}
