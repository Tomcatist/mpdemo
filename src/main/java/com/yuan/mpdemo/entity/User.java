package com.yuan.mpdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

/**
 * @author: yyss
 * @create: 2022-01-05 17:02
 **/
@Data
public class User {
        //@TableId(type = IdType.ID_WORKER)  //mp自带的策略，生成19位值，数字类型使用这种策略，比如long
        //@TableId(type = IdType.ID_WORKER_STR) // mp自带的策略，生成19位值，字符串类型生成这种策略
        private Long id;
        private String name;
        private Integer age;
        private String email;
        // create_time
        @TableField(fill = FieldFill.INSERT)  // 第一次添加有值
        private Date createTime;
        // update_time
        @TableField(fill = FieldFill.INSERT_UPDATE)  // 第一次添加和每次修改有值
        private Date updateTime;
        @Version
        @TableField(fill = FieldFill.INSERT)
        private Integer version;

        @TableLogic    // 逻辑删除
        private Integer deleted;

}
