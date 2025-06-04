package live.iyahir.springboot.task_manager.exceptions;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
	private List<String> errors;
}
