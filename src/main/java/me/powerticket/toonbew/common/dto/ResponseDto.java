package me.powerticket.toonbew.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ResponseDto<T> {
    @Builder.Default
    private int status = HttpStatus.OK.value();
    private String message;
    private T data;
}
