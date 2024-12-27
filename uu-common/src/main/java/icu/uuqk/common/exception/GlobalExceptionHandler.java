package icu.uuqk.common.exception;

import icu.uuqk.common.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception e, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponseDto.builder()
                        .apiPath(request.getDescription(false))
                        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                        .errorMsg(e.getMessage())
                        .errorTime(LocalDateTime.now())
                        .build()
                );
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String, String> validationErrors = new HashMap<>();
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();

        for (ObjectError error : allErrors) {
            String fieldName = ((FieldError) error).getField();
            String errorMsg = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMsg);
        }

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationErrors);
    }
}
