package org.sourav.delhi.metrosmartcard.exception;

public class MinimumBalanceException extends Exception {
	
	private String message = null;
	 
    public MinimumBalanceException() {
        super();
    }
 
    public MinimumBalanceException(String message) {
        super(message);
        this.message = message;
    }
 
    public MinimumBalanceException(Throwable cause) {
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
