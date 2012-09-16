package nl.catchvifyoucan.dal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import nl.catchvifyoucan.Constants;

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

import android.util.Log;

public class GetListOfGames implements IRequest {
	private static final String TAG = "GetListOfGames";

	@Override
	public JSONArray doOperation() {
		StringBuilder builder = new StringBuilder();
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpGet = null;
			try {
				httpGet = new HttpGet(new URI(Constants.SERVER_URL + "game?format=json"));

			} catch (URISyntaxException e) {
				Log.e(TAG, "URI exception: "+e);
			}

			// Execute HTTP Post Request
			HttpResponse response = httpclient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			int statusCode = statusLine.getStatusCode();
			if (statusCode == 200) {
				HttpEntity entity = response.getEntity();
				InputStream content = entity.getContent();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(content));
				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}
			} else {
				Log.e(TAG, "Failed to download file");
			}
		} catch (ClientProtocolException e) {
			Log.e(TAG, "Protocol exception: "+e);
		} catch (IOException e) {
			Log.e(TAG, "IO exception: "+e);
		}

		JSONObject jObj = null;
		try {
			jObj = new JSONObject(builder.toString());
		} catch (JSONException e) {
			Log.e(TAG, "Error parsing data " + e.toString());
		}
		JSONArray array = new JSONArray();
		try {
			array.put(0, jObj);
		} catch (JSONException e) {
			Log.e(TAG, "Failed to add object to array");
		}
		registerToFirstGame(array);
		return array;
	}
	
	/**This should be called from as a separate step, after the user chooses a game from the list in the UI*/
	private void registerToFirstGame(JSONArray array){
		JSONObject obj = null;
		try {
			obj = array.getJSONObject(0);
		} catch (JSONException e) {
			Log.e(TAG, "Could not find object at index 0: "+e);
		}
		JSONArray games = null;
		try {
			games = obj.getJSONArray(Constants.GAMES);
		} catch (JSONException e) {
			Log.e(TAG, "Could not find object with tag \"games\"");
		}
		String gameId = null;
		try {
			gameId = games.getString(0);
		} catch (JSONException e) {
			Log.e(TAG, "Could not get game id from array");
		}
		
		
	}
}
