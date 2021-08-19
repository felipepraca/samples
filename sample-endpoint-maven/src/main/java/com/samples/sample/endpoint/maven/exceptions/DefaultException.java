package com.samples.sample.endpoint.maven.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Ocorreu algum erro!")
public class DefaultException extends RuntimeException {}
