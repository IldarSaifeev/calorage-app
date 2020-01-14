package com.ildardev.calorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Продукт не найден.")
public class ItemNotExistException extends RuntimeException {
}
