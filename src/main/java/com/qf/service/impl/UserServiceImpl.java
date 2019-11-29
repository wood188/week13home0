package com.qf.service.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User selectOne(User user) {
        /*ExampleMatcher  matcher =ExampleMatcher.matchingAny().withMatcher("name", ExampleMatcher.GenericPropertyMatchers.caseSensitive().exact());
        Example<User> of=Example.of(user,matcher);
        Optional<User> one = userRespositry.findOne(of);
        User user1=null;
       if(one.isPresent()){
           user1=one.get();
       }*/
        System.out.println(user);
        return userDao.selectOne(user);
    }

    @Override
    public Integer userAdd(User user) {
        return userDao.userAdd(user);
    }
}
