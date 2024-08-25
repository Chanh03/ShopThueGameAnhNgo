package com.anhngo.shopthueaccanhngo.services;

import com.anhngo.shopthueaccanhngo.entities.Comment;
import com.anhngo.shopthueaccanhngo.repositories.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public List<Comment> getAllByGameId(String id) {
        return commentRepo.findByGameId(id);
    }
}
