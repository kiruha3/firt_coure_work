package com.kiruha3.list.selfexceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class EmployeeAlreadyAddedException extends RuntimeException {
}
