package live.iyahir.springboot.task_manager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException {
	
	
    public TaskNotFoundException(Long id) {
        super("Tarea con ID " + id + " no encontrada");
    }
}