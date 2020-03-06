package com.landinguy.kotlin

import com.landinguy.kotlin.service.UserService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
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
//        val language = mutableListOf("java", "kotlin", "python")
//
//        val result = language.also {
//            log.info("first item is ${it.first()}")
//        }.apply {
//            add("groovy")
//            log.info("size#$size")
//            add("scala")
//            log.info("size#$size")
//        }.let {
//            log.info("$it")
//            it
//        }.run {
//            add("c")
//            log.info("size#$size")
//            this
//        }
//
//        with(result) {
//            add("go")
//            log.info("result$this")
//            log.info("language$language")
//        }

        /*** 协程用法 ***/
//        f1()
//        f2()

        /*** 匿名函数作为接收者类型 ***/
//        val add = fun Int.(other: Int): Int = this + other
//        println("######${2.add(3)}")

        /*** inline内联函数可以提高运行效率 ***/


    }

    fun f1() {
//        GlobalScope.launch {
//            delay(1000)//launch中的delay会阻塞协程，不会阻塞线程
//            println("world")
//        }
//
//        println("hello")
//        runBlocking {
//            delay(2000)//runBlocking中的delay会阻塞线程
//        }

        //主协程
//        runBlocking {
//            //启动一个新协程
//            launch {
//                delay(1000)
//                println("world")
//            }
//            println("hello")
//            delay(5000)
//        }
//        println("测试runBlocking中delay是否会阻塞线程")
    }

    fun f2() = runBlocking {
        //        launch {
//            delay(2000)
//            println("task1...")
//        }
//
//        //创建一个协程作用域,coroutineScope在等待所有子协程执行完毕时不会?阻塞当前线程
//        coroutineScope {
//            launch {
//                delay(5000)
//                println("task2...")
//            }
//            delay(1000)
//            println("task3...")
//        }
//        println("task4...")

        //创建1000个协程
        repeat(1000) {
            delay(10)
            launch {
                println(".")
            }
        }

    }

}
