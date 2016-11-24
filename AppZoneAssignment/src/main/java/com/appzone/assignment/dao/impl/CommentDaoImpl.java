package com.appzone.assignment.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.appzone.assignment.dao.CommentDao;
import com.appzone.assignment.entity.Comment;
import com.appzone.assignment.entity.User;

@Repository("CommentDao")
public class CommentDaoImpl implements CommentDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public boolean save(Comment comment) {
		try {
			comment.setUser(em.find(User.class, comment.getUser().getId()));
			em.persist(comment);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean approve(Long commentID) {
		try {
			Comment comment = em.find(Comment.class, commentID);
			comment.setIsApproved(true);
			em.merge(comment);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Comment> getApprovedComments() {
		try {
			return em.createNamedQuery("Comment.getAllApproved").getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Comment> getUnApprovedComments() {
		try {
			return em.createNamedQuery("Comment.getAllUnApproved").getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
