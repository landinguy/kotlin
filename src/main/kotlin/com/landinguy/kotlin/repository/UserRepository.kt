package com.landinguy.kotlin.repository

import com.landinguy.kotlin.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author landing guy
 * @date 2019/8/7
 */
@Repository
interface UserRepository : JpaRepository<User, Long>