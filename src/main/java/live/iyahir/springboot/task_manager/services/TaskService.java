package live.iyahir.springboot.task_manager.services;

import java.util.List;

import live.iyahir.springboot.task_manager.entities.Task;

public interface TaskService {
	public List<Task> findAll();
	public Task findById(Long id);
	public Task create(Task task);
	public Task update(Long id, Task newTask);
	public void delete(Long id);
	public Task completeTask(Long id);
}
