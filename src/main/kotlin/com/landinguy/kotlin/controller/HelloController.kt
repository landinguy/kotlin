package com.landinguy.kotlin.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author landing guy
 * @date 2019/8/7
 */
@RestController
class HelloController {

    @RequestMapping("hello")
    fun hello() = "hello, kotlin"
}