package com.cdincer.CurrencyConverter.Exception;

import com.cdincer.CurrencyConverter.Exception.ExchangeRateErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExchangeRateExceptionHandler {


    //Catching all with Exception variable
    @ExceptionHandler
    public ResponseEntity<ExchangeRateErrorResponse> handleException(Exception exc)
    {
        ExchangeRateErrorResponse error= new ExchangeRateErrorResponse(HttpStatus.BAD_REQUEST.value(),exc.getMessage()+" modified",System.currentTimeMillis()
        );

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
