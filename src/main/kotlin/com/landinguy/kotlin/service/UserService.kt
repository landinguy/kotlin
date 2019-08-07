package com.landinguy.kotlin.service

import com.landinguy.kotlin.entity.User
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

    fun save(user: User) = userRepository.save(user)

    fun findAll() = userRepository.findAll()

}