/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.client;

import sun.misc.BASE64Encoder;


/**
 *
 * @author mmilivojevic
 */
public class AndroidPushManager implements PushManager{
    private String credentials;

    public AndroidPushManager(String username, String password) {
        this.credentials = this.setCredentials(username, password);
    }
    
    
    
    @Override
    public void setUsername(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getApplications() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getChanels(String aplicationId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendMessages(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private String setCredentials(String user, String pass){
        String cred = user + ':' + pass;
        BASE64Encoder enc = new BASE64Encoder();
        return enc.encode(cred.getBytes());
    }
}
