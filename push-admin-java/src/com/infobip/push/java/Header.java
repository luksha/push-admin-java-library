/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infobip.push.java;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmilivojevic
 */
public class Header {
    
    private final String encoding = "UTF-8";

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Header(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        try {
            return URLEncoder.encode(this.name + ":" + this.value, encoding);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Header.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return null;
        }
    }
}
