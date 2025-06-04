package live.iyahir.springboot.task_manager.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import live.iyahir.springboot.task_manager.dto.TaskDto;
import live.iyahir.springboot.task_manager.dto.TimedTaskDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tareas")
public class Task {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id private Long id;
	
	@Column(nullable = false, length = 255, name = "titulo")
	@NotBlank( message = "El título no puede estar vacío")
	private String title;
	
	@Column(columnDefinition = "TEXT", name="descripcion")
	@NotBlank(message = "La descripción no puede estar vacía")
	private String description;
	
	@Column(nullable = false, name="creada")
	private LocalDateTime createdAt;
	
	@Column(name = "fecha_vencimiento")
	private LocalDateTime dueDate;
	
	@Column(nullable = false, name="completada")
	private boolean completed = false;
	
	public Task(String title, String description, LocalDateTime dueDate, boolean completed) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.completed = completed;
		
		this.createdAt = LocalDateTime.now();
	}
	

	/**
	 * Crea la tarea usando un DTO que no incluye fecha de creacion
	 * Utilizado para crear una nueva tarea.
	 * 
	 * @param dto Datos de la tarea, sin fecha de cración
	 */
	public Task(TaskDto dto) {
		this(dto.title(), dto.description(), dto.dueDate(), dto.completed());
	}
	
	/**
	 * Crea la tarea usando un DTO que sí incluye fecha de creacion
	 * Utilizado para crear una nueva tarea.
	 * 
	 * @param dto Datos de la tarea, con fecha de cración
	 */
	public Task(TimedTaskDto dto) {
		this(dto.title(), dto.description(), dto.dueDate(), dto.completed());
		this.createdAt = dto.createdAt();
	}
		
}
