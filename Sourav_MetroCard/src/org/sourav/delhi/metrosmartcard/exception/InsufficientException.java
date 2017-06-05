package org.sourav.delhi.metrosmartcard.exception;

public class InsufficientException extends Exception {
	
	private String message = null;
	 
    public InsufficientException() {
        super();
    }
 
    public InsufficientException(String message) {
        super(message);
        this.message = message;
    }
 
    public InsufficientException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
	
}

