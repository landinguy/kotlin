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
//        val list = userService.find()
//        log.info("size#${list.size}")

//        Result(0, "ok", "data1").let {
//            println(it)
//            it.msg = "error"
//            it.data = "data2"
//            println(it)
//        }

        /*** let、run、with 返回lambda表达式的值 ； also、apply 返回该对象 ***/
        val language = mutableListOf("java", "kotlin", "python")

        val result = language.also {
            log.info("first item is ${it.first()}")
        }.apply {
            add("groovy")
            log.info("size#$size")
            add("scala")
            log.info("size#$size")
        }.let {
            log.info("$it")
            it
        }.run {
            add("c")
            log.info("size#$size")
            this
        }

        with(result) {
            add("go")
            log.info("result$this")
            log.info("language$language")
        }


    }

}
