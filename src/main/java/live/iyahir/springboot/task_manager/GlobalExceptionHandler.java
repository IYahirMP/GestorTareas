package live.iyahir.springboot.task_manager;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import live.iyahir.springboot.task_manager.exceptions.ErrorResponseDto;
import live.iyahir.springboot.task_manager.exceptions.GeneralErrorResponse;
import live.iyahir.springboot.task_manager.exceptions.TaskNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<GeneralErrorResponse> handleTaskNotFoundException(
			TaskNotFoundException e, WebRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = e.getMessage();
		String path = request.getDescription(false).replace("uri=", "");
		
		GeneralErrorResponse error = new GeneralErrorResponse(status, message, path);
		return new ResponseEntity<>(error, status);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(FieldError::getDefaultMessage)
				.toList();
		
		HttpStatus responseStatus = HttpStatus.UNPROCESSABLE_ENTITY;
		
		ErrorResponseDto errorResponseDto = ErrorResponseDto.builder()
				.errors(errors)
				.build();
		
		return ResponseEntity.status(responseStatus).body(errorResponseDto);
	}

}
