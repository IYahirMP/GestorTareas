package live.iyahir.springboot.task_manager.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;

public record TaskDto (
		@NotBlank(message = "El título es obligatorio")
		String title,
		String description,
		LocalDateTime dueDate,
		boolean completed
) {}
