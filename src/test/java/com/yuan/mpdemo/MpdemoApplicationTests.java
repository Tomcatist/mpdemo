package com.yuan.mpdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuan.mpdemo.entity.User;
import com.yuan.mpdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class MpdemoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    // 查询user表中的所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    // 插入操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("林胡冲");
        user.setAge(30);
        user.setEmail("ybq@qq.com");
//        // 手动添加
//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert);
    }

    // 修改操作
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(2L);
        user.setAge(120);
        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    // 测试乐观锁
    @Test
    public void testOptimisticLocker() {
        // 根据id查询数据
        User user = userMapper.selectById(1478962888012820481L);
        // 进行修改
        user.setAge(200);
        userMapper.updateById(user);
    }

    // 多个id批量查询
    @Test
    public void testSelectDemo1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1l, 2l, 3l));
        System.out.println(users);
    }

    // 根据条件做查询 map条件构造器
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","Jone");
        map.put("age",18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    // 分页查新
    @Test
    public void testPage() {
        // 1、创建page对象
        // 传入了；两个参数： 当前页 和 每页显示记录数
        Page<User> page = new Page(1,3);
        // 调用mp分页查询的方法
        // 调用mp分页查询中,底层封装
        // 把分页的所有数据，封装到page对象里面
        userMapper.selectPage(page,null);

        // 通过page对象，获取分页数据
        System.out.println(page.getCurrent());  // 当前页
        System.out.println(page.getRecords());  // 每页数据list集合
        System.out.println(page.getSize());  // 每页显示记录数
        System.out.println(page.getTotal());  // 总记录数
        System.out.println(page.getPages()); // 总页数
        System.out.println(page.hasNext());  // 是否有下一页
        System.out.println(page.hasPrevious());  // 是否有上一页
    }

    // 删除操作：物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1478984634380353538L);
        System.out.println(result);
    }
    // 批量删除(物理)
    @Test
    public void testDeleteBatchIds() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1,2));
        System.out.println(result);
    }

    // mp实现复杂查询操作
    @Test
    public void testSelectQuery() {
        // 创建对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        // 通过QueryWrapper设置条件值
        // ge、gt、le、lt
        // 查询age >= 30 的记录
        // 第一个参数，字段值，第二个参数，设置值
//        wrapper.ge("age", 30);
//        userMapper.selectList(wrapper);
//        System.out.println(users);

        // eq ne
//        wrapper.eq("name", "lilei");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

//        wrapper.ne("name", "lilei");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // between
        // 查询年龄 20-30
//        wrapper.between("age",20,30);
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // like
//        wrapper.like("name","岳");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);

        // orderByDesc
//        wrapper.orderByDesc("id");

        // last
//        wrapper.last("limit 1");



    }





}
