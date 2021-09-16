package me.powerticket.toonbew.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorInfo {
    TOTAL_TOON_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "TOTAL_TOON_NOT_FOUND - 웹툰을 찾을 수 없습니다.");

    private final int errorCode;
    private final String errorMessage;
}