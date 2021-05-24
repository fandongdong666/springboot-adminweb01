package com.fan;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fan.entity.User;
import com.fan.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class SpringbootUserTests {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        for (int i = 0; i < 10 ; i++) {
            User user = new User();
            user.setAge(3);
            user.setName(UUID.randomUUID().toString().substring(0,5));
            user.setEmail(UUID.randomUUID().toString().substring(2,5)+"@qq.com");
            int insert = userMapper.insert(user);
            System.out.println(insert);
            System.out.println(user);//主键自动回填到实体类中。MP自动帮我们完成的。
        }
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1);
        user.setAge(88);
        int update = userMapper.updateById(user);
        System.out.println(update);
    }
    @Test
    public void testLeguansuo(){
        //1.查询用户信息
        User user = userMapper.selectById(1);
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);

        user.setName("fans");
        user.setAge(18);
        //执行更新操作
        userMapper.updateById(user);
    }
    @Test
    public void testPage(){
        //构造分页对象
        Page<User> page = new Page<>(1, 5);
        //分页查询，内置的分页查询，条件包装器为null
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(page.getCurrent());
        page.getRecords().forEach(System.out::println);
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testDel(){
        int i = userMapper.deleteById(27);
        /*int i1 = userMapper.deleteBatchIds(Arrays.asList(30, 29));

        HashMap<String, Object> map = new HashMap<>();
        map.put("name","22e87");
        int i2 = userMapper.deleteByMap(map);*/
    }
    //条件构造器====================
    @Test
    public void testWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age",18);//ge：》=
        userMapper.selectList(wrapper).forEach(System.out::println);
    }
}
