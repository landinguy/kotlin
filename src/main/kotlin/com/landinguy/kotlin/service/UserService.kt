package com.landinguy.kotlin.service

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.landinguy.kotlin.entity.User
import com.landinguy.kotlin.mapper.UserMapper
import com.landinguy.kotlin.repository.UserRepository
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author landing guy
 * @date 2019/8/7
 */
@Service
class UserService {

    @Resource
    lateinit var userRepository: UserRepository
    @Resource
    lateinit var userMapper: UserMapper

    fun save(user: User) = userRepository.save(user)

    fun findAll(): List<User> = userRepository.findAll()

    fun selectByPage(pageNo: Long, pageSize: Long): Any {
        val page = Page<User>(pageNo, pageSize)
        val pageVo = userMapper.selectPageVo(page)
        return mapOf<String, Any>("total" to pageVo.total, "list" to pageVo.records)
    }

}