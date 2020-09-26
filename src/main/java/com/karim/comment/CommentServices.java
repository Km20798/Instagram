package com.karim.comment;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentServices {

    public List<Comment> getComment();

    public Comment findCommentById(long id);

    public Comment addComment(Comment comment);

    public void deleteCommentById(long id);
}
