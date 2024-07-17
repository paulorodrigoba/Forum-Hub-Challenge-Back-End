package br.com.forumhub.api.infra;

public class RegisterException extends RuntimeException {
    public RegisterException(String message) {
        super(message);
    }
}