package com.karim.post;

import com.karim.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostServices {

    public List<Post> getPost();

    public Post findPostById(long id);

    public Post addPost(Post post);

    public void deletePostById(long id);

    public List<Post> getPosts(User user);

}
