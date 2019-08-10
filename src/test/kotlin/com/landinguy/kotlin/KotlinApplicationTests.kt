package com.landinguy.kotlin

import com.landinguy.kotlin.service.UserService
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinApplicationTests {

    val log: Logger = LoggerFactory.getLogger(this.javaClass)


    @Resource
    lateinit var userService: UserService

    @Test
    fun contextLoads() {
    }

    @Test
    fun test() {
        val list = userService.find()
        log.info("size#${list.size}")
    }

}
