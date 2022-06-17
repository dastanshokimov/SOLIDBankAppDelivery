package bankapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class AccountNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Object> accountNotFound(AccountNotFoundException e) {
        AccountNotFoundResponse accountNotFoundResponse = new AccountNotFoundResponse(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(accountNotFoundResponse, HttpStatus.NOT_FOUND);
    }
}
