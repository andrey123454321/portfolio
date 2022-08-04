package com.zaurtregulov.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception){//создаем метод, который ловит ошибки
        //класса NoSuchEmployeeException и возвращает обертку jsone для ответа http
        EmployeeIncorrectData data = new EmployeeIncorrectData();//создаем объект ответственный за jsone
        data.setInfo(exception.getMessage());
        return new ResponseEntity<> (data, HttpStatus.NOT_FOUND );
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception){//создаем метод, который ловит все ошибки
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<> (data,HttpStatus.BAD_REQUEST );
    }
}
