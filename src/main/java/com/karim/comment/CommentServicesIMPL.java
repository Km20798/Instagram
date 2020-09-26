package com.karim.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicesIMPL implements CommentServices {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getComment() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findCommentById(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);
    }
}
