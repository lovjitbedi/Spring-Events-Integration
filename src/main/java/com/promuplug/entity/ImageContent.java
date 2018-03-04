package com.promuplug.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.promuplug.constants.ContentType;

@Entity
@Table(name = "image_content")
public class ImageContent {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Resource resource;
	
	@Column(name="content_type")
	private ContentType contentType;
	
	@Column(name = "date_created",nullable=false)
    private Calendar dateCreated;
	
	@Column(name = "last_updated",nullable=false)
    private Calendar lastUpdated;
	
	@PrePersist
	protected void onCreate() {
		dateCreated = Calendar.getInstance();
	}

	@PreUpdate
	protected void onUpdate() {
		lastUpdated = Calendar.getInstance();
	}

}
