package nl.catchvifyoucan.dal;

import org.json.JSONArray;

import android.os.AsyncTask;

public class RequestsTasks extends AsyncTask<IRequest, Void, JSONArray>{

	@Override
	protected JSONArray doInBackground(IRequest... params) {
		JSONArray response = null;
		for(IRequest req: params){
			response = req.doOperation();
		}
		return response;
	}

}
