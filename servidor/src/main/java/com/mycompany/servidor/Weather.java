package com.mycompany.servidor;

/**
 *
 * @author ismaelds
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Weather {

    public static String doHttpGet(String ciudad) {
        /**
         * Api call by city name
         * http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=<ApiKey>
         *
         * Api call by city id:
         * http://api.openweathermap.org/data/2.5/weather?id=2172797=<ApiKey>
         */

        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + ciudad + ",es&APPID=" + ApiKey.getApiKey();
        HttpEntity entity = null;

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;

        try {
            resp = client.execute(get);
            entity = resp.getEntity();
            //System.out.println("Json response");
            //System.out.println(EntityUtils.toString(entity));
            //toPrettyFormat()
            return EntityUtils.toString(entity);
            
        } catch (IOException ioe) {
            System.err.println("Something went wrong getting the weather: ");
            ioe.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unknown error: ");
            e.printStackTrace();
        }
        return null;
    }
    
    /**
   * Convert a JSON string to pretty print version
   * @param jsonString
   * @return
   */
  public static String toPrettyFormat(String jsonString) 
  {
      JsonParser parser = new JsonParser();
      JsonObject json = parser.parse(jsonString).getAsJsonObject();

      Gson gson = new GsonBuilder().setPrettyPrinting().create();
      String prettyJson = gson.toJson(json);

      return prettyJson;
  }
}
