package com.landinguy.kotlin.entity

import javax.persistence.*
import javax.validation.constraints.NotEmpty

/**
 * @author landing guy
 * @date 2019/8/7
 */
@Entity
@Table(indexes = [Index(name = "", unique = false, columnList = "username")])
class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = -1

    @NotEmpty(message = "用户名不能为空")
    @Column(unique = false, nullable = false)
    var username: String = ""

    @NotEmpty(message = "密码不能为空")
    @Column(nullable = false)
    var password: String = ""

    override fun toString(): String {
        return "User(id=$id, username='$username', password='$password')"
    }

}