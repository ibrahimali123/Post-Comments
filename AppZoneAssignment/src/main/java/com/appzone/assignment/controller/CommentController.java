package com.appzone.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.appzone.assignment.entity.Comment;
import com.appzone.assignment.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentSerive;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveComment(@RequestBody Comment comment) {
		Boolean status = commentSerive.save(comment);
		if (!status)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/approve", method = RequestMethod.POST)
	public ResponseEntity<String> updateJob(@RequestBody Long commentID) {
		Boolean status = commentSerive.approve(commentID);
		if (!status)
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		else
			return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/approvedComments", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> approvedComments() {
		List<Comment> comments = commentSerive.getApprovedComments();
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}

	@RequestMapping(value = "/unApprovedComments", method = RequestMethod.GET)
	public ResponseEntity<List<Comment>> unApprovedComments() {
		List<Comment> comments = commentSerive.getUnApprovedComments();
		return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
	}
}
