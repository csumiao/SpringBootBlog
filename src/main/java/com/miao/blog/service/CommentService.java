package com.miao.blog.service;

import com.miao.blog.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment save(Comment comment);
}
