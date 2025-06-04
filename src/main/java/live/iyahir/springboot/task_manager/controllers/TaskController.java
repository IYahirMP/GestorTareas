package live.iyahir.springboot.task_manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import live.iyahir.springboot.task_manager.dto.TaskDto;
import live.iyahir.springboot.task_manager.entities.Task;
import live.iyahir.springboot.task_manager.exceptions.TaskNotFoundException;
import live.iyahir.springboot.task_manager.services.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {
	@Autowired 
	private TaskService taskService;
	
	@GetMapping("/")
	public List<Task> getAllTasks(){
		return taskService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Task> getTask(@PathVariable Long id) {
			return ResponseEntity.ok(taskService.findById(id));

	}
	
	@PostMapping
	public Task createTask(@Valid @RequestBody TaskDto dto) {
		Task task = new Task(dto);
		return taskService.create(task);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody TaskDto dto) 
	{
		try {
			Task task = taskService.update(id, new Task(dto));
			return ResponseEntity.ok(task);
			
		}catch(TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
		try {
			taskService.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PatchMapping("/{id}/complete")
	public ResponseEntity<Task> completeTask(@PathVariable Long id)
	{
		try {
			return ResponseEntity.ok(taskService.completeTask(id));
		}catch(TaskNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
