package com.example.CadeVoce.exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleInvalidArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return "error"; // Crie uma página de erro 'error.html' no seu diretório de templates
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("error", "Ocorreu um erro inesperado: " + ex.getMessage());
        return "error"; // Crie uma página de erro 'error.html' no seu diretório de templates
    }
}
