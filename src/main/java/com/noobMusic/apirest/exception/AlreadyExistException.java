package com.noobMusic.apirest.exception;

import javax.persistence.PersistenceException;

public class AlreadyExistException extends PersistenceException {
    public AlreadyExistException() {
    }

    public AlreadyExistException(String message) {
        super(message);
    }
}
