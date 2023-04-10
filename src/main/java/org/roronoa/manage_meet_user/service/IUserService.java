package org.roronoa.manage_meet_user.service;


import org.roronoa.manage_meet_user.dto.AuthDto;
import org.roronoa.manage_meet_user.entity.User;

import java.util.List;

public interface IUserService {
    User save(User user);
    User getUser(String uuid);
    List<User> getListUsers();

    User findByEmail(AuthDto authDto);


}