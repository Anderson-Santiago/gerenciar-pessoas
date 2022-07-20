package com.example.gerenciarpessoas.exception;

public class LoginNotExistsException extends RuntimeException {
    public LoginNotExistsException() {
        super("Login não encontrado!");
    }
}