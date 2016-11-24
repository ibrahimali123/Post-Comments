package com.appzone.assignment.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appzone.assignment.dao.CommentDao;
import com.appzone.assignment.entity.Comment;
import com.appzone.assignment.service.CommentService;

@Service("CommentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public boolean save(Comment comment) {
		comment.setDate(new Date());
		comment.setIsApproved(false);
		return commentDao.save(comment);
	}

	@Override
	public boolean approve(Long commentID) {
		return commentDao.approve(commentID);
	}

	@Override
	public List<Comment> getApprovedComments() {
		return commentDao.getApprovedComments();
	}

	@Override
	public List<Comment> getUnApprovedComments() {
		return commentDao.getUnApprovedComments();
	}

}
