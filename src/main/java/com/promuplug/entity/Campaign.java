package com.promuplug.entity;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.promuplug.constants.CampaignState;
import com.promuplug.constants.CampaignType;
import com.promuplug.constants.Network;

@Entity
@Table(name = "campaign")
public class Campaign {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private Long id;
	
	@Column(name="name",nullable=false,length=50)
	private String name;
	
	@Column(name="network",nullable=false)
	private Network network;
	
	@Column(name="campaign_type",nullable=false)
	private CampaignType campaignType;
	
	@Column(name="campaign_state",nullable=false)
	private CampaignState campaignState;
	
	@Column(name="start_date",nullable=false)
	private Calendar startDate;
	
	@Column(name="end_date",nullable=false)
	private Calendar endDate;
	
	@Column(name="start_time")
	private Timestamp startTime;
	
	@Column(name="end_time")
	private Timestamp endTime;
	
	@Column(name="latitude")
	private double latitude;
	
	@Column(name="longitude")
    private double longitude;
	
	@ManyToOne
	@JoinColumn
	private Advertiser advertiser;
	
	@OneToOne(cascade = CascadeType.ALL)
	private AdContent adContent;
	
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

	public Network getNetwork() {
		return network;
	}

	public void setNetwork(Network network) {
		this.network = network;
	}

	public CampaignType getCampaignType() {
		return campaignType;
	}

	public void setCampaignType(CampaignType campaignType) {
		this.campaignType = campaignType;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public CampaignState getCampaignState() {
		return campaignState;
	}

	public void setCampaignState(CampaignState campaignState) {
		this.campaignState = campaignState;
	}

	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
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

	public AdContent getAdContent() {
		return adContent;
	}

	public void setAdContent(AdContent adContent) {
		this.adContent = adContent;
	}
	
}
