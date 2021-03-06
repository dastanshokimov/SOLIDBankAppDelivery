package bankapp.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class AccountResponse {
    private String message;
    private HttpStatus statusCode;
}
