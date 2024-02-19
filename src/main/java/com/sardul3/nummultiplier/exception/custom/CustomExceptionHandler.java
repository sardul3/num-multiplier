package com.sardul3.nummultiplier.exception.custom;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling custom exceptions.
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Handles InvalidInputException and adds the error message to the model.
     *
     * @param ex    The InvalidInputException that was thrown.
     * @param model The model to add the error message attribute.
     * @return The name of the Thymeleaf template for the form.
     */
    @ExceptionHandler(InvalidInputException.class)
    public String handleCustomException(InvalidInputException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "inputForm";
    }

}
