package com.maha.ems.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/employees/{empid}")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping("/tasks")
	public List<Task> getTasksByEmpId(@PathVariable("empid") int empId) throws Exception{
		try {
			return taskService.getTasksByEmpId(empId);
		}catch(Exception e) {
			new Exception("Tasks can not be fetched");
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/tasks")
	public Task addTask(@RequestBody Task task, @PathVariable("empid") int empId) throws Exception {
		try {
			return taskService.addTask(empId,task);
		}catch(Exception e) {
			new Exception("Task is not added : "+task);
		}
		return null;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/tasks/{taskid}")
	public Task updateTask(@RequestBody Task task, @PathVariable("empid") int empId, @PathVariable("taskid") int taskId)
			throws Exception {
		return taskService.updateTask(empId,task,taskId);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/tasks/{taskid}")
	public String deleteTaskByIdAndEmpId(@PathVariable("empid") int empId, @PathVariable("taskid") int taskId)
			throws Exception {
		return taskService.deleteTaskByIdAndEmpId(empId, taskId);
	}
}
