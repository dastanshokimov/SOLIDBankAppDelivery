package bankapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class WithdrawExceptionAdvice {
    @ResponseStatus
    @ExceptionHandler(WithdrawException.class)
    public ResponseEntity<Object> handleWithdrawException(WithdrawException e) {
        return new ResponseEntity<>(new WithdrawResponse(e.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
