package com.mehedi.travedia.dto;

import lombok.Data;

@Data
public class ErrorMessageDto {

    private int code;
    private String message;

    public ErrorMessageDto() {

    }

    public ErrorMessageDto(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ErrorMessageDto(String message) {
        this.message = message;
    }
}
