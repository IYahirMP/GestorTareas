package live.iyahir.springboot.task_manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import live.iyahir.springboot.task_manager.entities.Task;
import live.iyahir.springboot.task_manager.exceptions.TaskNotFoundException;
import live.iyahir.springboot.task_manager.repositories.TaskRepository;

@Service
public class TaskServiceImplementation implements TaskService{
	@Autowired
	private TaskRepository repository;
	
	public List<Task> findAll() {
        return repository.findAll();
    }

    public Task findById(Long id) throws TaskNotFoundException{
        return repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public Task create(Task task) {
        return repository.save(task);
    }

    public Task update(Long id, Task newTask) throws TaskNotFoundException{
        Task task = findById(id);
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setCompleted(newTask.isCompleted());
        return repository.save(task);
    }

    public void delete(Long id) {
        repository.delete(findById(id));
    }
    
    public Task completeTask(Long id) throws TaskNotFoundException {
    	Task task = findById(id);
    	task.setCompleted(true);
    	
    	return repository.save(task);
    }
}
