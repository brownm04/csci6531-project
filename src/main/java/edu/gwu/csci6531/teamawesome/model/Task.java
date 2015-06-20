package edu.gwu.csci6531.teamawesome.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TASK")
public class Task implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 162958150709570528L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "date_created", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateCreated;

	@Column(name = "date_claimed", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateClaimed;

	@Column(name = "description")
	String description;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	Category category;

	@Column(name = "payment")
	float payment;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "posted_by")
	User postedBy;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "claimed_by")
	User claimedBy;

	@Column(name = "deadline", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date deadline;

	@Column(name = "task_zip")
	long taskZip;

	public Task() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateClaimed() {
		return dateClaimed;
	}

	public void setDateClaimed(Date dateClaimed) {
		this.dateClaimed = dateClaimed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getPayment() {
		return payment;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

	public User getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(User postedBy) {
		this.postedBy = postedBy;
	}

	public User getClaimedBy() {
		return claimedBy;
	}

	public void setClaimedBy(User claimedBy) {
		this.claimedBy = claimedBy;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public long getTaskZip() {
		return taskZip;
	}

	public void setTaskZip(long taskZip) {
		this.taskZip = taskZip;
	}

}