package com.karim.data;

import com.karim.comment.Comment;
import com.karim.comment.CommentServices;
import com.karim.post.Post;
import com.karim.post.PostServices;
import com.karim.user.User;
import com.karim.user.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class myData implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private PostServices postServices;
    @Autowired
    private UserServices userServices;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        data();
    }

    public void data() {

        User user = new User();
        user.setEmail("kmaged207@gmail.com");
        user.setFullName("Karim Mohamed Maged");
        user.setUserName("Karim Mohamed");
        user.setPassword("kmaged207");
        userServices.addUser(user);


        Post post = new Post();
        post.setContant("Welcome this is my first post");
        post.setUser(user);
        postServices.addPost(post);


    }
}
