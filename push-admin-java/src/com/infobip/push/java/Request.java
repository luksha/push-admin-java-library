package com.infobip.push.java;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private String postBody;
    private int responseCode;
    private String response;

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

    /**
     * Add headers to connection
     */
    private void addHeaders() {
        for (Header header : this.headers) {
            this.con.setRequestProperty(header.getName(), header.getValue());
        }
    }

    /**
     * Return params, as URL postfix
     *
     * @return String url postfix
     */
    private String addParams() {
        String params = null;
        for (Param param : this.params) {
            params += param.toString() + '&';
        }
        //remove last '&' sign from string
        if (params.length() > 0 && params.charAt(params.length() - 1) == '&') {
            params = params.substring(0, params.length() - 1);
        }
        return '?' + params;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    /**
     *
     * @return String GET response
     * @throws Exception
     */
    public String executeGet() throws Exception {
        this.con.setRequestMethod("GET");
        this.addHeaders();

        this.responseCode = this.con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public String executePost() throws Exception {
        this.con.setRequestMethod("GET");
        this.addHeaders();

        this.con.setDoOutput(true);
        this.con.setDoInput(true);
        this.con.setInstanceFollowRedirects(false);

        DataOutputStream os = new DataOutputStream(this.con.getOutputStream());
        os.writeBytes(this.postBody);
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(this.con.getInputStream()));
        StringBuffer response = new StringBuffer();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        this.con.disconnect();

        return response.toString();
    }
}
