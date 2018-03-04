package com.promuplug.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.promuplug.constants.ResourceType;

@Entity
@Table(name = "resource")
public class Resource {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column(name="resourceType",nullable=false)
	private ResourceType resourceType;
	
	@Column(name="resource_path",nullable=false)
	private String resourcePath;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResourceType getResourceType() {
		return resourceType;
	}

	public void setResourceType(ResourceType resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Calendar getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Calendar lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
}
