package com.ildardev.calorage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Данная дата уже зарегистрирована в системе.")
public class CalorageDayExistsException extends RuntimeException {
}
