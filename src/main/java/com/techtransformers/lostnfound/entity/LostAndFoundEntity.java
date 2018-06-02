package com.techtransformers.lostnfound.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lostandfound")
public class LostAndFoundEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="createdon")
	private Timestamp createdOn;
	@Column(name="category")
	private String category;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="attachment")
	private String attachment;
	@Column(name="description")
	private String description;
	@Column(name="lostrcvdate")
	private Timestamp lostRcvDate;

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLostRcvDate() {
		return lostRcvDate;
	}

	public void setLostRcvDate(Timestamp lostRcvDate) {
		this.lostRcvDate = lostRcvDate;
	}

	@Override
	public String toString() {
		return "LostAndFoundEntity [id=" + id + ", createdOn=" + createdOn + ", category=" + category + ", name=" + name
				+ ", email=" + email + ", attachment=" + attachment + ", description=" + description + ", lostRcvDate="
				+ lostRcvDate + "]";
	}
}
