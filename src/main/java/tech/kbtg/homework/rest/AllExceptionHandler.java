package tech.kbtg.homework.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.kbtg.homework.exception.NotFoundException;
import tech.kbtg.homework.response.HospitalErrorResponse;

@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<HospitalErrorResponse> handleException(NotFoundException ex){
        HospitalErrorResponse err = new HospitalErrorResponse();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return  new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<HospitalErrorResponse> handleException(Exception ex){
        HospitalErrorResponse err = new HospitalErrorResponse();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage(ex.getMessage());
        err.setTimeStamp(System.currentTimeMillis());
        return  new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

}
