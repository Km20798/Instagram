package com.karim.post;

import com.karim.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServicesIMPL implements PostServices {

    @Autowired
    private PostRepostiory postRepostiory;

    @Override
    public List<Post> getPost() {
        return postRepostiory.findAll();
    }

    @Override
    public Post findPostById(long id) {
        return postRepostiory.findById(id).get();
    }

    @Override
    public Post addPost(Post post) {
        return postRepostiory.save(post);
    }

    @Override
    public void deletePostById(long id) {
        postRepostiory.deleteById(id);
    }

    @Override
    public List<Post> getPosts(User user) {
        return (List<Post>) postRepostiory.findByUser(user);
    }
}
