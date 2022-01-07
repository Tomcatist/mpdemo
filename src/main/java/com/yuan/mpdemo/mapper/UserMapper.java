package com.yuan.mpdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuan.mpdemo.entity.User;
import org.springframework.stereotype.Component;

// extends BaseMapper<实体类> 就可以调用mp对该实体类的增删改查
@Component
public interface UserMapper extends BaseMapper<User> {

}
