package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="feedbacks")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private int feedbackId;
	
	@Column(name = "ratings",length = 5)
	private String rating;
	
	@Column(name="comments",length=100)
	private String comments;
	
	//----------mapping of feedback and enroll--------//

	@JsonIgnoreProperties("feedback")
	@OneToOne
	@JoinColumn(name = "fk_ef_id")
	private Enrollments enroll;

	
	
	//-----------constructors---------------//
	
	public Feedback() {
		super();
	}



	public Feedback(int feedbackId, String rating, String comments, Enrollments enroll) {
		super();
		this.feedbackId = feedbackId;
		this.rating = rating;
		this.comments = comments;
		this.enroll = enroll;
	}



	public int getFeedbackId() {
		return feedbackId;
	}



	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}



	public String getRating() {
		return rating;
	}



	public void setRating(String rating) {
		this.rating = rating;
	}



	public String getComments() {
		return comments;
	}



	public void setComments(String comments) {
		this.comments = comments;
	}



	public Enrollments getEnroll() {
		return enroll;
	}



	public void setEnroll(Enrollments enroll) {
		this.enroll = enroll;
	}



	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", rating=" + rating + ", comments=" + comments + ", enroll="
				+ enroll + "]";
	}



	
	
}
