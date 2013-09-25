package com.infobip.push.dto;


import java.util.List;

/**
*
* @author nkolarevic
*/
public class ChannelServiceDTO {

	private List<ChannelDTO> channelPackages;
	
	

	public List<ChannelDTO> getChannelPackages() {
		return channelPackages;
	}
	public void setChannelPackages(List<ChannelDTO> packages) {
		this.channelPackages = packages;
	}
	
	@Override
	public String toString() {
		return "[channelPackages=" + channelPackages + "]";
	}
	
	
	
	
	
}