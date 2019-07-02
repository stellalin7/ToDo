package com.tts.ToDo.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Long id;
		
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "user_id")
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private User user;
		
	private String creator;
	private String title;
	private String description;
	
//	@OneToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name = "status_id")
//	private Status status;
	
	private String status;
		
	@CreationTimestamp 
	private Date createdAt;
	
	public Task() {
	}
	
//	public Task(User user) {
//		this.user = user;
//		//this.status = "New";
//		
//	}
	
	public Task(Long id, String creator, String title, String description, String status, Date today) {
		this.id = id;
		this.creator = creator;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = today;
	}

	public Long getId() {
		return id;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreatedAt() {
		return createdAt;
	}



//	public Status getStatus() {
//		return status;
//	}
//
//	public void setStatus(Status status) {
//		this.status = status;
//	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
