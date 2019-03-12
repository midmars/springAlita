package com.star.service;

import com.star.domain.User;

public interface UserService {

    User findByUserId(String userId);

    void save(User source);

    void update(User source);
}
