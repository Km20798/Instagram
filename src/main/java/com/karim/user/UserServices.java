package com.karim.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServices {

    public List<User> getUser();

    public User findUserById(long id);

    public User addUser(User user);

    public void deleteUserById(long id);

    public User findByEmailAndPassword(String email, String password);

    public User findBUserName(String userName);

    public User updateUser(User user, long id);

}
