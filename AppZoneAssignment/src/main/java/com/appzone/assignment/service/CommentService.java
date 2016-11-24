package com.appzone.assignment.service;

import java.util.List;

import com.appzone.assignment.entity.Comment;

public interface CommentService {

	public boolean save(Comment comment);

	public boolean approve(Long commentID);

	public List<Comment> getApprovedComments();

	public List<Comment> getUnApprovedComments();

}
