package com.alexzhang.service;

import com.alexzhang.pojo.User;

/**
 * Created by alexzhang on 2017/12/16.
 */
public interface IUserService {
    void savePrimary(User user);

    void saveSlave(User user);
}
