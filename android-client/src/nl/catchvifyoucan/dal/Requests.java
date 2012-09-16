package nl.catchvifyoucan.dal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;

public class Requests {
	private static final String TAG = "Requests";

	HttpClient httpclient = new DefaultHttpClient();
	HttpGet httpGet = new HttpGet("http://10.0.1.7:8080/catchvifyoucan-grails-server/game?format=json");
	StringBuilder builder = new StringBuilder();

	public void getListOfGames() {
		try {
			
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

			StrictMode.setThreadPolicy(policy); 
			
			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
		      int statusCode = statusLine.getStatusCode();
		      if (statusCode == 200) {
		        HttpEntity entity = response.getEntity();
		        InputStream content = entity.getContent();
		        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		        String line;
		        while ((line = reader.readLine()) != null) {
		          builder.append(line);
		        }
		      } else {
		        Log.e(TAG, "Failed to download file");
		      }
		    } catch (ClientProtocolException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		 Log.e(TAG, builder.toString());
		 
		 JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(builder.toString()); 
			Log.i(TAG, "Number of entries " + jsonArray.length());
	      for (int i = 0; i < jsonArray.length(); i++) {
	        JSONObject jsonObject = jsonArray.getJSONObject(i);
	        Log.i(TAG, jsonObject.getString("text"));
	      }
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
}
