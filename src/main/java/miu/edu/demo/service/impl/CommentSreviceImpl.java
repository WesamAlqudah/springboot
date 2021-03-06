package miu.edu.demo.service.impl;

import miu.edu.demo.domain.Comment;
import miu.edu.demo.domain.Post;
import miu.edu.demo.repo.CommentRepo;
import miu.edu.demo.repo.PostRepo;
import miu.edu.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentSreviceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    PostRepo postRepo;

    @Override
    public void addComment(int postID, Comment comment) {
        Post post = postRepo.findById(postID);
        if (post != null) {
            comment.setPostLi(post);
            commentRepo.save(comment);
        }
    }

    @Override
    public Comment findCommentByPostIdByUserId(int postId, long userId, int commentId) {
        return commentRepo.findCommentByPostIdByUserId(postId, userId, commentId);
    }

    @Override
    public List<Comment> findCommentsByPostIdByUserId(int postId, long userId) {
        return commentRepo.findCommentsByPostIdByUserId(postId, userId);
    }
    /*@Override
    public void addComment(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void addComment(int postId, Comment comment) {

    }

    @Override
    public Comment findCommentByPostIdByUserId(int postId, long userId, int commentId) {
        return null;
    }

    @Override
    public List<Comment> findCommentsByPostIdByUserId(int postId, long userId) {
        return null;
    }*/
}
