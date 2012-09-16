package nl.catchvifyoucan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Context appContext = arg0.getApplicationContext();
		Intent intent = new Intent(appContext, UpdateLocation.class);
		appContext.startService(intent);
	}

}
