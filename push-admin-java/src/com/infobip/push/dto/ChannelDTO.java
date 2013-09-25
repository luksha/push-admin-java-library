
package com.infobip.push.dto;

/**
 *
 * @author nkolarevic
 */
public class ChannelDTO {
	private String name;
	private String applicationID;
    private String description;
    private String parent;
    private String[] children;
  
 
     public ChannelDTO() {}
    
 	public String getApplicationID() {
		return applicationID;
	}
	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent =parent;
		
	}
	
	public String[] getChildren() {
		return children;
	}
	public void setChildren(String[] children) {
		this.children = children;
	}

	
	
	@Override
	public String toString() {
		return "ApplicationInfoDTO [applicationId=" + applicationID +", name=" + name 
				+ ",description=" + description  + ", parent=" + parent + ", children="
				+ children + "]";
	}

   
    
}
