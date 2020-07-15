package com.alexzhang.service.Impl;

import com.alexzhang.dynamic.TargetDataSource;
import com.alexzhang.dynamic.Type;
import com.alexzhang.pojo.User;
import com.alexzhang.repository.UserRepository;
import com.alexzhang.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexzhang on 2017/12/16.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository repository;


    @Override
    public void savePrimary(User user){
        repository.save(user);
    }

    @Override
    @TargetDataSource(type = Type.SLAVE)
    public void saveSlave(User user){
        repository.save(user);
    }

}
