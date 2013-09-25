/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.client;

import com.infobip.push.dto.ApplicationsServiceInfoDTO;
import com.infobip.push.dto.ChannelDTO;
import java.util.List;

/**
 *
 * @author mmilivojevic
 */
public interface PushManager {
    
    public ApplicationsServiceInfoDTO getApplications();
    public void getChanels(String applicationId);
    public void sendMessages(String message, List<ChannelDTO> channel);
}
