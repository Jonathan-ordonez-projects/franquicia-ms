package com.api.franquicia.controller.advice;

import com.api.franquicia.commons.exceptions.RequestException;
import com.api.franquicia.services.dto.ErrorDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.api.franquicia.commons.constants.Constants.*;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException e){
        ErrorDto errorDto = ErrorDto.builder().code(CODENOTCONTENT).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> EntityNotFoundExceptionHandler(EntityNotFoundException e){
        ErrorDto errorDto = ErrorDto.builder().code(CODETABLEWHITOUTACCESSORNOTEXIST).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DataAccessException.class)
    public ResponseEntity<ErrorDto> EntityNotFoundExceptionHandler(DataAccessException e){
        ErrorDto errorDto = ErrorDto.builder().code(CODETABLEWHITOUTACCESSORNOTEXIST).message(MESAGGETABLEWHITOUTACCESSORNOTEXIST).build();
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RequestException.class)
    public ResponseEntity<ErrorDto> requestExceptionHandler(RequestException e){
        ErrorDto errorDto = ErrorDto.builder().code(e.getCode()).message(e.getMessage()).build();
        return new ResponseEntity<>(errorDto, e.getHttpStatus());
    }
}
