package com.infobip.push.java;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mmilivojevic
 */
public class Request {

    private String url;
    private List<Header> headers;
    private List<Param> params;
    private HttpURLConnection con;

    public Request(String url) {
        this.url = url;
        this.connection();
    }

    private void connection() {
        try {
            URL obj = new URL(this.url);
            this.con = (HttpURLConnection) obj.openConnection();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Request.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addHeaders() {
        for (Header header : this.headers) {
            this.con.setRequestProperty(header.getName(), header.getValue());
        }
    }
    
    private void addParams(){
      String params;  
      for(Param param : this.params){
          params.
      }   
    }
}
