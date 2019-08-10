package com.landinguy.kotlin.controller

import com.landinguy.kotlin.entity.User
import com.landinguy.kotlin.service.UserService
import com.landinguy.kotlin.util.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.stream.Collectors
import javax.annotation.Resource
import javax.validation.Valid

/**
 * @author landing guy
 * @date 2019/8/7
 */
@RestController
@RequestMapping("user")
class UserController {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @Resource
    lateinit var userService: UserService

    @PostMapping("add")
    fun save(@Valid @RequestBody user: User, bindingResult: BindingResult): Result {
        var result = Result()
        if (bindingResult.hasErrors()) {
            val errMsg = bindingResult.allErrors.stream().map { it.defaultMessage }.collect(Collectors.joining(","))
            log.info("errMsg: $errMsg")
            return Result(-1, errMsg)
        }

        try {
            userService.save(user)
        } catch (e: Exception) {
            result = Result(-1, "添加用户失败", Unit)
            log.error("添加用户失败,$e")
        }
        return result
    }

    @RequestMapping("findAll")
    fun select(): Result {
        var result = Result()
        try {
            val list = userService.findAll()
            result.data = list
        } catch (e: Exception) {
            result = Result(-1, "查询用户失败", Unit)
        }
        return result
    }

}