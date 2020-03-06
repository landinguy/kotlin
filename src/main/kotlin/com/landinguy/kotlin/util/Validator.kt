package com.landinguy.kotlin.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult
import java.util.stream.Collectors

@Component
class Validator {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun validate(bindingResult: BindingResult): Result? =
            if (bindingResult.hasErrors()) {
                val errMsg = bindingResult.allErrors.stream().map { it.defaultMessage }.collect(Collectors.joining(","))
                log.warn("参数校验失败,errMsg#$errMsg")
                Result(-1, "参数校验未通过：$errMsg")
            } else null

}