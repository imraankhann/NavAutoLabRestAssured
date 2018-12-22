package client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {

    /*
    Author : Imraan
    Simple CRUD operation / methods for Rest Assured

     */

    public CloseableHttpResponse getMethod(String url) throws IOException {
       CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpGet httpget= new HttpGet(url);
        CloseableHttpResponse closeableHttpResponse= httpClient.execute(httpget);
        //int statusCode = CloseableHttpResponse.getStatusLine().getStatusCode();
        //System.out.println("Status code is : "+statusCode);
        /*String respStr=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        JSONObject jsonObject=new JSONObject(respStr);
        System.out.println("Response JSON from Api : "+jsonObject);

        Header[] headerArray=closeableHttpResponse.getAllHeaders();
        HashMap<String, String>allHeaders=new HashMap<String, String>();
        for(Header header: headerArray){
            allHeaders.put(header.getName(),header.getValue());
        }
        System.out.println("Headers Array are : "+allHeaders);*/
        return closeableHttpResponse;

    }
}
