package com.ligg.dao;

import com.ligg.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户数据访问对象
 */
@Mapper
public interface UserDao {
    
    /**
     * 通过ID查询用户
     * @param id 用户ID
     * @return 用户对象
     */
    User findById(Long id);
    
    /**
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    User findByUsername(String username);
    
    /**
     * 插入新用户
     * @param user 用户对象
     * @return 影响行数
     */
    int insert(User user);
    
    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 影响行数
     */
    int update(User user);
    
    /**
     * 删除用户
     * @param id 用户ID
     * @return 影响行数
     */
    int deleteById(Long id);
    
    /**
     * 查询用户列表
     * @return 用户列表
     */
    List<User> findAll();
    
    /**
     * 验证用户登录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User login(@Param("username") String username, @Param("password") String password);
} 