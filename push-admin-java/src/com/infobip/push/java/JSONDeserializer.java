package com.infobip.push.java;

import java.util.ArrayList;
import java.util.List;






import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.infobip.push.dto.ApplicationInfoDTO;
import com.infobip.push.dto.ApplicationsServiceInfoDTO;
import com.infobip.push.dto.ChannelDTO;
import com.infobip.push.dto.ChannelServiceDTO;

/**
*
* @author nkolarevic
*/

public class JSONDeserializer {
	
	private static final String NAME = "name";
	private static final String APPLICATION_ID = "applicationID";
	private static final String APIKEY = "apiKey";
	private static final String DESCRIPTION = "description";
	private static final String DISABLED = "disabled";
    private static final String NOTIFICATION_URL = "notificationURL";
	private static final String SUPPORTED_OS_TYPES = "supportedOSTypes";
	private static final String IS_IOS_PRODUCTION = "isIOSProduction";
	
	private static final String PARENT = "parent";
	private static final String CHILDREN = "children";

	

    private static ApplicationInfoDTO deserializeApplicationInfo(JSONObject json)
    		throws JSONException {
		
		if(json == null) return null;
		
		ApplicationInfoDTO infoDTO = new ApplicationInfoDTO();
		
		if (json.has(NAME) && !json.isNull(NAME)) 		    			
			infoDTO.setName(json.getString(NAME));
		if (json.has(APPLICATION_ID)&& !json.isNull(APPLICATION_ID)) 	  
			infoDTO.setApplicationID(json.getString(APPLICATION_ID));
		if (json.has(APIKEY)) 												
			infoDTO.setApiKey(json.getString(APIKEY));
		if (json.has(DESCRIPTION) && !json.isNull(DESCRIPTION))   				
			infoDTO.setDescription(json.getString(DESCRIPTION));
        if (json.has(DISABLED)&& !json.isNull(DISABLED)) 	    				
        	infoDTO.setDisabled(json.getBoolean(DISABLED));
        if (json.has(NOTIFICATION_URL))											
        	infoDTO.setNotificationURL(json.getString(NOTIFICATION_URL)); 
        
        if (json.has(SUPPORTED_OS_TYPES)) 	{
        	
        JSONArray OsTypes = json.getJSONArray(SUPPORTED_OS_TYPES);
        String[] types = new String[5];
        
        for (int i = 0; i < OsTypes.length(); i++){
        	 types[i] = OsTypes.getString(i);
        	  infoDTO.setSupportedOSTypes(types);
            
        }}
        if (json.has(IS_IOS_PRODUCTION)&& !json.isNull(IS_IOS_PRODUCTION)) 	       	
        	infoDTO.setIsIOSProduction(json.getBoolean(IS_IOS_PRODUCTION));
      
	
		return infoDTO;
        }
    
    
	public static ApplicationsServiceInfoDTO deserializeServiceInfo(String serviceInfoJson) 
			throws JSONException {
		
		
		JSONArray serviceInfo = new JSONArray(serviceInfoJson);
		
		ApplicationsServiceInfoDTO serviceInfoDTO = new ApplicationsServiceInfoDTO();
		
		List<ApplicationInfoDTO> applicationsList = new ArrayList<ApplicationInfoDTO>();
				
		for (int i = 0; i < serviceInfo.length(); ++i) {
					
	ApplicationInfoDTO packageInfo = deserializeApplicationInfo(serviceInfo.getJSONObject(i));
			
					applicationsList.add(packageInfo);
					}
					serviceInfoDTO.setApplicationPackages(applicationsList);
					
		
		return serviceInfoDTO;
	}
	
	
	 private static ChannelDTO deserializeChannle(JSONObject json) throws JSONException {
			
			if(json == null) return null;
			
			ChannelDTO infoDTO = new ChannelDTO();
			
			
			if (json.has(APPLICATION_ID)&& !json.isNull(APPLICATION_ID)) 	  
				infoDTO.setApplicationID(json.getString(APPLICATION_ID));
			
			if (json.has(NAME) && !json.isNull(NAME)) 		    			
				infoDTO.setName(json.getString(NAME));
			
			if (json.has(DESCRIPTION) && !json.isNull(DESCRIPTION))   				
				infoDTO.setDescription(json.getString(DESCRIPTION));
			
	        if (json.has(PARENT)&& !json.isNull(PARENT)) 	    				
	        	infoDTO.setDisabled(json.getBoolean(PARENT));
	       
	        
	        if (json.has(CHILDREN)) 	{
	        	
	        JSONArray OsTypes = json.getJSONArray(CHILDREN);
	        String[] types = new String[5];
	        
	        for (int i = 0; i < OsTypes.length(); i++){
	        	 types[i] = OsTypes.getString(i);
	        	  infoDTO.setSupportedOSTypes(types);
	            
	        }}
	  
	      
		
			return infoDTO;
	        }
	    
	    
		public static ChannelServiceDTO deserializeServiceChannel(String serviceInfoJson) 
				throws JSONException {
			
			
			JSONArray serviceInfo = new JSONArray(serviceInfoJson);
			
			ApplicationsServiceInfoDTO serviceInfoDTO = new ApplicationsServiceInfoDTO();
			
			List<ApplicationInfoDTO> applicationsList = new ArrayList<ApplicationInfoDTO>();
					
			for (int i = 0; i < serviceInfo.length(); ++i) {
						
ApplicationInfoDTO packageInfo = deserializeApplicationInfo(serviceInfo.getJSONObject(i));
				
						applicationsList.add(packageInfo);
						}
						serviceInfoDTO.setApplicationPackages(applicationsList);
						
					
				
			
			
			return serviceInfoDTO;
		}
		
		
    
}
