package com.maha.ems.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maha.ems.employee.EmployeeRepository;
import com.maha.ems.exception.EmployeeNotFoundException;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	private boolean checkIfEmployeeExists(int empId) {
		if (!employeeRepository.existsById(empId)) {
			throw new EmployeeNotFoundException(empId);
		}
		return true;
	}

	public List<Task> getTasksByEmpId(int empId) {
		checkIfEmployeeExists(empId);
		return taskRepository.findByEmployeeId(empId);
	}

	public Task addTask(int empId, Task task) {
		return employeeRepository.findById(empId).map(employee -> {
			task.setEmployee(employee);
			return taskRepository.save(task);
		}).orElseThrow(() -> new EmployeeNotFoundException(empId));
	}

	public Task updateTask(int empId, Task taskToBeUpdated, int taskId) throws Exception {
		return taskRepository.findById(taskId).map(task -> {
			task.setDescription(taskToBeUpdated.getDescription());
			task.setEndDate(taskToBeUpdated.getEndDate());
			task.setStartDate(taskToBeUpdated.getStartDate());
			task.setName(taskToBeUpdated.getName());
			return taskRepository.save(task);
		}).orElseThrow(() -> new Exception("Update exception.. "));
	}

	public String deleteTaskByIdAndEmpId(int empId, int taskId) throws Exception {
		checkIfEmployeeExists(empId);
		return taskRepository.findById(taskId).map(task -> {
			taskRepository.delete(task);
			return "Task deleted successfully";
		}).orElseThrow(() -> new Exception("Task not found for taskid : " + taskId));
	}

}
