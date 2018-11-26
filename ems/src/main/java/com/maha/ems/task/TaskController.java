package com.maha.ems.task;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/employees/{empid}")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	/*
	 * api to get all the tasks that belongs to an employee
	 * @param empId
	 * @return list of task records that is assigned to the employee
	 */
	@GetMapping("/tasks")
	public List<Task> getTasksByEmpId(@PathVariable("empid") int empId) throws Exception{
		try {
			return taskService.getTasksByEmpId(empId);
		}catch(Exception e) {
			throw new Exception("Tasks can not be fetched");
		}
	}
	
	/*
	 * api to add task to a particular employee
	 * @param task, empId
	 * @return task record after saving to database 
	 */
	@PostMapping("/tasks")
	public Task addTask(@Valid @RequestBody Task task, @PathVariable("empid") int empId) throws Exception {
		try {
			return taskService.addTask(empId,task);
		}catch(Exception e) {
			throw new Exception("Task is not added : "+task);
		}
	}
	
	/*
	 * api to update task
	 * @param task, empId, taskId
	 * @return updated task record
	 */
	@PutMapping("/tasks/{taskid}")
	public Task updateTask(@RequestBody Task task, @PathVariable("empid") int empId, @PathVariable("taskid") int taskId)
			throws Exception {
		return taskService.updateTask(empId,task,taskId);
	}
	
	@DeleteMapping("/tasks/{taskid}")
	public String deleteTaskByIdAndEmpId(@PathVariable("empid") int empId, @PathVariable("taskid") int taskId)
			throws Exception {
		return taskService.deleteTaskByIdAndEmpId(empId, taskId);
	}
}
