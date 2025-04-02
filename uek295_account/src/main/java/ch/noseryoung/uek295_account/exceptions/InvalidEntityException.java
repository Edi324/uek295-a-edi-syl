package ch.noseryoung.uek295_account.exceptions;

public class InvalidEntityException extends RuntimeException {
    public InvalidEntityException(String message) {
        super(message);
    }
}