package com.ildardev.calorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Данный продукт уже присутствует в базе данных.")
public class ItemAlreadyExistsException extends RuntimeException {
}
