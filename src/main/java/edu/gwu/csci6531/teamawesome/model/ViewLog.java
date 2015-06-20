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
@Table(name = "VIEWLOG")
public class ViewLog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4132784734017546104L;

	@Id
	@GeneratedValue
	private long id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "task")
	private Task task;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user")
	private User user;
	
	@Column(name = "date_viewed", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	Date dateViewed;

	public ViewLog() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public User getUser() {
		return user;
	}

	public void setViewedById(User user) {
		this.user = user;
	}

	public Date getDateViewed() {
		return dateViewed;
	}

	public void setDateViewed(Date dateViewed) {
		this.dateViewed = dateViewed;
	}
}