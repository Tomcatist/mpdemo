package com.yuan.mpdemo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: yyss
 * @create: 2022-01-06 11:35
 **/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    // 使用mp实现添加操作，这个方法执行
    @Override
    public void insertFill(MetaObject metaObject) {  // metaObject 元数据对象
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("version",1,metaObject);
    }

    // 使用mp实现修改操作，这个方法执行
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
