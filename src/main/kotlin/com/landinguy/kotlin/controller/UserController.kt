package com.landinguy.kotlin.controller

import com.landinguy.kotlin.entity.User
import com.landinguy.kotlin.service.CommonService
import com.landinguy.kotlin.service.UserService
import com.landinguy.kotlin.util.Result
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
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
    @Resource
    lateinit var commonService: CommonService


    @PostMapping("add")
    fun save(@Valid @RequestBody user: User, bindingResult: BindingResult): Result {
        log.info("添加用户,user#$user")
        return commonService.process({ userService.save(user) }, { log.error("添加用户失败", it) }, bindingResult)
    }

    @GetMapping("findAll")
    fun select(): Result = commonService.process({ it.data = userService.findAll() }, { log.error("查询用户失败", it) })


    @GetMapping("pageSelect")
    fun pageSelect(@RequestParam("pageNo", defaultValue = "1") pageNo: Long, @RequestParam("pageSize", defaultValue = "10") pageSize: Long): Result {
        log.info("pageNo#$pageNo,pageSize#$pageSize")
        return commonService.process({ it.data = userService.selectByPage(pageNo, pageSize) }, { log.error("查询用户失败", it) })
    }

}