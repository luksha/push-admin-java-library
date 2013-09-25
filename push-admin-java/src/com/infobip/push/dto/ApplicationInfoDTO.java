package com.infobip.push.dto;

public class ApplicationInfoDTO {
	
	
	private String name;
	private String applicationID;
	private String apiKey;
    private String description;
    private boolean disabled;
    private String notificationURL;
    private String[] supportedOSTypes;
    private boolean isIOSProduction;
 
    public ApplicationInfoDTO() {}
    
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	
	
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String  apiKey) {
		this. apiKey =  apiKey;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean getDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	public String getNotificationURL() {
		return notificationURL;
	}
	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
		
	}
	
	public String[] getSupportedOSTypes() {
		return supportedOSTypes;
	}
	public void setSupportedOSTypes(String[] supportedOSTypes) {
		this.supportedOSTypes = supportedOSTypes;
	}
	
	public boolean  getIsIOSProduction() {
		return isIOSProduction;
	}
	public void  setIsIOSProduction(boolean  isIOSProduction) {
		this.isIOSProduction = isIOSProduction;
	}
	
	
	@Override
	public String toString() {
		return "ApplicationInfoDTO [name=" + name + ", applicationId=" + applicationID + ", apiKey=" + apiKey
				+ ",description=" + description + ", disabled=" + disabled + ",notificationURL=" + notificationURL + ", supportedOSTypes="
				+ supportedOSTypes + ", isIOSProduction=" + isIOSProduction
				+ "]";
	}

   
	


}
