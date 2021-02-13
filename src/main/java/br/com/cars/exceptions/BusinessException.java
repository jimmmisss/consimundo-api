package br.com.cars.exceptions;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -2273865182434997002L;

    public BusinessException(String message, Exception cause) {
        super(message, cause);
    }

}
