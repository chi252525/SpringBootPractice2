package com.becky.demo.exception.general;

import com.becky.demo.exception.constants.ErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AccessDeniedException extends AppRuntimeException {
    private static final long serialVersionUID = -8585054398916667669L;

    public AccessDeniedException() {
        super();
    }

    public AccessDeniedException(ErrorEnum errorEnum, Object... params) {
        super(errorEnum, params);
    }
}
