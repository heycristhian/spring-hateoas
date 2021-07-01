package br.com.heycristhian.hateoas.handler;

import br.com.heycristhian.hateoas.error.RequestError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class RestUserExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public RequestError handleIllegalArgumentException(IllegalArgumentException e) {
        RequestError requestError = RequestError.builder()
                .title("Illegal Argument Exception")
                .status(HttpStatus.BAD_REQUEST.value())
                .message("Inválid parameter")
                .localDateTime(LocalDateTime.now())
                .objectName(e.getClass().getName())
                .build();
        log.error("Illegal Argument Exception" + ": " + Arrays.toString(e.getStackTrace()));
        return requestError;
    }
}
