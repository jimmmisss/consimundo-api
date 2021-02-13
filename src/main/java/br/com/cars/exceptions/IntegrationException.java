package br.com.cars.exceptions;

public class IntegrationException extends RuntimeException {
    private static final long serialVersionUID = -2273865182434997002L;

    public IntegrationException(String message, Exception cause) {
        super(message, cause);
    }

}
