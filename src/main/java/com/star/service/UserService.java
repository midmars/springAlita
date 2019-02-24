package com.star.service;

import com.star.domain.User;

public interface UserService {

    User findByUserId(String userId);
}
