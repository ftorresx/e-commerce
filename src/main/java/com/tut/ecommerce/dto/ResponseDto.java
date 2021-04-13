package com.tut.ecommerce.dto;

/**
 * CLASE QUE MANEJA LOS ESTADOS Y MENSAJES DE RESPUESTA
 * @author ferdando.torres
 *
 */
public class ResponseDto {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
