package com.cg.courseservice.exception;

import java.util.LinkedHashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler  {
	
	 @ExceptionHandler(value = CourseNotFoundException.class)
	    public ResponseEntity<String> handleCourseNotFoundException(Exception e) {
	        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	        return responseEntity;
	    }
	 
	// handling those errors validation errors here.
		@Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers, HttpStatus status, WebRequest request)
	    {

	        Map<String, Object> body = new LinkedHashMap<>();
	        //body.put("timestamp" , new Date());
	        body.put("status" , status.value());

	        //Get all errors
	        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());

	        body.put("errors", errors);

	        return new ResponseEntity<>(body, headers, status);

	    }


}
