package com.appzone.assignment.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
@NamedQueries({
		@NamedQuery(name = "Comment.getAllApproved", query = "SELECT c FROM Comment c Where c.isApproved = true"),
		@NamedQuery(name = "Comment.getAllUnApproved", query = "SELECT c FROM Comment c Where c.isApproved = false") })
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@JoinColumn(name = "user_id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private User user;

	@Column(name = "text")
	private String text;

	@Column(name = "date")
	private Date date;

	@Column(name = "is_approved")
	private Boolean isApproved;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", user=" + user + ", text=" + text + ", date=" + date + ", isApproved="
				+ isApproved + "]";
	}

}
