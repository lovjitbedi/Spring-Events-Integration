package com.promuplug.constants;

public enum CampaignState {
	
	PENDING_APPROVAL("PENDING_APPROVAL"),
	STARTED("STARTED"),
	COMPLETED("COMPLETED");
	
	String campaignState;
	
	CampaignState(String campaignState){
		this.campaignState = campaignState;
	}

}
