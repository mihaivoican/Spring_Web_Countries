package com.fastrackit.countriesapplication.controller;

import com.fastrackit.countriesapplication.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice       //asa se adnoteaza clasa pt tratare erori
public class RestExceptionHandler {
    //aici ma ocup de cum se trateaza erorile
    //asa pot trata orice err runtimeexception
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)     //e status fixat de noi pt a fi intors de server in ac caz; altfel, fara ac procedura serverul intoarce status 500
//    public ErrorResponse handleRuntimeException(RuntimeException exception){
//        return new ErrorResponse(exception.getMessage());
//    }
//mai jos e o eroare tratata de mine in folder Esception, vezi metoda de acolo, si metoda de mai sus e particularizata pt tratarea acelei erori; eroarea care intervine de ex cand caut dupa id o tranz care nu exista
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)     //e status fixat de noi pt a fi intors de server in ac caz; altfel, fara ac procedura serverul intoarce status 500
    public ErrorResponse handleRuntimeException(ResourceNotFoundException exception){
        return new ErrorResponse(exception.getMessage() +exception.getEntityId());
    }
}

//e un obiect de returnat la erori; spring il serializeaza
record ErrorResponse(String message){

}

