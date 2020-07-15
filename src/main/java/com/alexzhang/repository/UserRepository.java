package com.alexzhang.repository;

import com.alexzhang.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alexzhang on 2017/12/16.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
