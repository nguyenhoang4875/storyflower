package storysflower.com.storysflower.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import storysflower.com.storysflower.dto.NotFoundException;

/**
 * @author ntynguyen
 */
@ControllerAdvice
public class HandleExceptionController {
    /*@ExceptionHandler(NotFoundException.class)
    private String getError() {
        return "home";
    }*/
}
