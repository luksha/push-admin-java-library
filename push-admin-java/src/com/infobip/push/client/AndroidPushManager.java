/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.client;

import com.infobip.push.dto.ApplicationInfoDTO;
import com.infobip.push.dto.ApplicationsServiceInfoDTO;
import com.infobip.push.dto.ChannelDTO;
import com.infobip.push.java.Base64;
import com.infobip.push.java.Header;
import com.infobip.push.java.JSONDeserializer;
import com.infobip.push.java.Request;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmilivojevic
 */
public class AndroidPushManager implements PushManager {

    private String credentials;
    private String applicationId;

    public AndroidPushManager(String username, String password) {
        this.credentials = this.setCredentials(username, password);
    }

    @Override
    public List<ApplicationInfoDTO> getApplications() {
        Request request = new Request("https://pushapi.infobip.com/1/applications");
        List headerList = new ArrayList<Header>();

        headerList.add(new Header("Authorization", "Basic " + this.credentials));

        request.setHeaders(headerList);
        String response = null;
        try {
            response = request.executeGet();
            System.out.println(response);       //!!! return
            return JSONDeserializer.deserializeServiceInfo(response);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    @Override
    public void getChanels(String applicationId) {
        this.applicationId = applicationId;
        
        Request request = new Request("https://pushapi.infobip.com/1/application/"
                + this.applicationId + "/channels");
        List headerList = new ArrayList<Header>();

        headerList.add(new Header("Authorization", "Basic " + this.credentials));
        headerList.add(new Header("Content-Type", "application/json"));

        request.setHeaders(headerList);
        String response = null;
        try {
            response = request.executeGet();
            System.out.println(response);       //!!! return
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        //TODO: getChanels
    }

    /**
     * 
     * @param message JSON formated message with params
     */
    @Override
    public void sendMessages(String message, List<ChannelDTO> channels) {
        Request request = new Request("https://pushapi.infobip.com/3/application/"
                + this.applicationId + "/message");

        List headers = new ArrayList<Header>();
        headers.add(new Header("Authorization", "Basic " + this.credentials));
        headers.add(new Header("Content-Type", "application/json"));

        request.setHeaders(headers);
        request.setPostBody(message);

        try {
            String response = request.executePost();
            System.out.println(response);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String setCredentials(String user, String pass) {
        String cred = user + ':' + pass;
        return Base64.encode(cred.getBytes());
    }
}
