package com.vti.shoppe.Exception;

import org.springframework.http.HttpStatus;

public enum ErrorResponseBase {

    NOT_FOUND(HttpStatus.NOT_FOUND, "id không tồn tại"),
    USERNAME_EXITED(HttpStatus.INTERNAL_SERVER_ERROR, "Username đã tồn tại");

    public final HttpStatus status;
    public final String message;

    ErrorResponseBase(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
