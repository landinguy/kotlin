package com.landinguy.kotlin.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.landinguy.kotlin.entity.User
import org.apache.ibatis.annotations.Select

/**
 * @author landing guy
 * @date 2019/8/10
 */
interface UserMapper : BaseMapper<User> {

    @Select("select * from user")
    fun selectPageVo(page: Page<User>): IPage<User>
}