package com.infobip.push.dto;


import java.util.List;


public class ApplicationsServiceInfoDTO {

	private List<ApplicationInfoDTO> applicationsPackages;
	
	

	public List<ApplicationInfoDTO> getApplicationPackages() {
		return applicationsPackages;
	}
	public void setApplicationPackages(List<ApplicationInfoDTO> packages) {
		this.applicationsPackages = packages;
	}
	
	@Override
	public String toString() {
		return "[applicationsPackages=" + applicationsPackages + "]";
	}
	
	
	
	
	
}
