package com.promuplug.entity;

import java.util.Calendar;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.promuplug.constants.Category;

@Entity
@Table(name = "advertiser")
public class Advertiser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column(name = "name", length = 50,nullable=false)
    private String name;

	@Column(name = "category",nullable=false)
	private Category category;
	
	@OneToMany(mappedBy="advertiser")
	private Set<Campaign> campaigns;	
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Campaign> getCampaigns() {
		return campaigns;
	}

	public void setCampaigns(Set<Campaign> campaigns) {
		this.campaigns = campaigns;
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
