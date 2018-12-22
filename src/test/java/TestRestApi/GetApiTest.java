package TestRestApi;

import Util.TestJsonUtil;
import client.RestClient;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restapibase.TestBase;

import java.io.IOException;

public class GetApiTest extends TestBase{

    TestBase testBase;
    String serviceUrl;
    String apiUrl;
    String uri;
    RestClient restClient;
    CloseableHttpResponse closeableHttpResponse;

    @BeforeMethod

    public void setUp() throws IOException {
        testBase=new TestBase();
         serviceUrl=prop.getProperty("url");
         apiUrl=prop.getProperty("serviceUrl");

         uri=serviceUrl+apiUrl;


    }

    @Test
    public void testGetRequest() throws ClientProtocolException, IOException {
        restClient=new RestClient();
        closeableHttpResponse =restClient.getMethod(uri);
        int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
        Assert.assertEquals(RESPONSE_STATUS_CODE_200,statusCode,"Status code is not 200.");
        String respStr= EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
        JSONObject respJson=new JSONObject(respStr);
        System.out.println("Response json from api ---->> : "+respJson);

        String s=TestJsonUtil.getValueByJPath(respJson,"/per_page");
        System.out.println("perpage from Response : "+s);

        //total val
        String totalVal=TestJsonUtil.getValueByJPath(respJson,"/total");
        System.out.println("total value is : "+totalVal);

        //get value from jsonArray

        String lastName=TestJsonUtil.getValueByJPath(respJson,"/data[0]/last_name");
        System.out.println("LastName of 0 index is : "+lastName);

        String id=TestJsonUtil.getValueByJPath(respJson,"/data[0]/id");
        System.out.println("id of 0 index is : "+id);

        String avatar=TestJsonUtil.getValueByJPath(respJson,"/data[0]/avatar");
        System.out.println("avatar of 0 index is : "+avatar);

        String firstName=TestJsonUtil.getValueByJPath(respJson,"/data[0]/first_name");
        System.out.println("first name of 0 index is : "+firstName);



    }


}
