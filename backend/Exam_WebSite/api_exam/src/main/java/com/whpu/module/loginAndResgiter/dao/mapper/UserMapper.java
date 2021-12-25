package com.whpu.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whpu.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/27 23:47
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
