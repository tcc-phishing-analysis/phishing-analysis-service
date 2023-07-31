package com.tcc.phishing.analysis.application.web.exception

import com.tcc.phishing.analysis.domain.exception.GenericException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

/*
@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(value = [GenericException::class])
    fun genericException(ex: GenericException): ResponseEntity<GenericException> {
        return ResponseEntity
                .status(404)
                .body(ex)
    }

    @ExceptionHandler(value = [Exception::class])
    fun unknownException(ex: Exception): ResponseEntity<GenericException> {
        return ResponseEntity
                .status(400)
                .body(
                        GenericException(message = ex.message ?: "banana")
                )
    }


}

 */