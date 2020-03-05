package com.landinguy.kotlin.service

import com.landinguy.kotlin.util.Handle
import com.landinguy.kotlin.util.Result
import com.landinguy.kotlin.util.Validator
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.validation.BindingResult
import javax.annotation.Resource

@Service
class CommonService {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Resource
    lateinit var validator: Validator

    fun setErrMsg(result: Result, code: Int?, msg: String?, e: Exception) {
        result.msg = msg ?: "系统错误：${e.message}"
        result.code = code ?: -1
    }

    fun process(bindingResult: BindingResult? = null, businessHandle: Handle<Result>, errHandle: Handle<Exception>): Result {
        val result = Result()

        //参数校验
        if (bindingResult != null) {
            val validate = validator.validate(bindingResult)
            if (validate != null) return validate
        }

        try {
            businessHandle(result)
        } catch (e: Exception) {
            errHandle(e)
            setErrMsg(result, null, null, e)
        }
        return result
    }

}