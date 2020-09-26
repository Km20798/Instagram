package com.karim.post;

import com.karim.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepostiory extends JpaRepository<Post, Long> {
    List<Post> findByUser(User user);
}
