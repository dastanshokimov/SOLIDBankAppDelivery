package bankapp.exception;

import org.springframework.http.HttpStatus;

public class WithdrawException extends RuntimeException {
    private String message;

    public WithdrawException(String message) {
        super(message);
    }
}
