package com.ligg.service.impl;

import com.ligg.dao.UserDao;
import com.ligg.entity.User;
import com.ligg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @Transactional
    public boolean register(User user) {
        // 检查用户名是否已存在
        if (userDao.findByUsername(user.getUsername()) != null) {
            return false;
        }
        
        // 设置创建和更新时间
        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        
        // 进行密码加密（实际应用中应使用加密算法）
        // TODO: 密码加密
        
        return userDao.insert(user) > 0;
    }

    @Override
    public User login(String username, String password) {
        // TODO: 密码应该在比较前进行加密
        return userDao.login(username, password);
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        // 更新时间
        user.setUpdateTime(new Date());
        return userDao.update(user) > 0;
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
} 