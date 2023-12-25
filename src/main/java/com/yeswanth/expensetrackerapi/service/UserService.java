package com.yeswanth.expensetrackerapi.service;

import com.yeswanth.expensetrackerapi.models.User;
import com.yeswanth.expensetrackerapi.models.UserModel;

public interface UserService {
    User createUser(UserModel user);

    User read(Long id);

    User update(UserModel user, Long id);

    void delete(Long id);

    User getLoggedInUser();

}
