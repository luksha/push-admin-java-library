/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.client;

import com.infobip.push.dto.ApplicationsServiceInfoDTO;

/**
 *
 * @author mmilivojevic
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        AndroidPushManager manager = new AndroidPushManager("pushdemo", "pushdemo");
        ApplicationsServiceInfoDTO app = manager.getApplications();
        System.out.println(app.getApplicationPackages().get(0).getName());
        
//        Request request = new Request("https://pushapi.infobip.com/3/application/50be430aed76/message");
//        List headers = new ArrayList<Header>();
//        headers.add(new Header("Authorization", "Basic cHVzaGRlbW86cHVzaGRlbW8="));
//        headers.add(new Header("Content-Type", "application/json"));
//        
//        request.setHeaders(headers);
//        request.setPostBody("{\"sentType\":\"application\",\"mimeType\":\"text/plain\",\"OSTypes\":[\"Android\"],\"notificationMessage\":\"Test\",\"androidData\":{}}");
//        
//        try {
//            String response = request.executePost();
//            System.out.println(response);
//        } catch (Exception ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
    }
}
