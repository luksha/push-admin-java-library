/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.client;

/**
 *
 * @author mmilivojevic
 */
public interface PushManager {
    public void setUsername(String user);
    public void setPassword(String pass);
    public void getApplications();
    public void getChanels(String aplicationId);
    public void sendMessages(String message);
}
