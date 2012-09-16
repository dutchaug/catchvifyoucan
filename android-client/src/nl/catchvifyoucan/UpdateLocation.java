package nl.catchvifyoucan;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class UpdateLocation extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return START_NOT_STICKY;
	}

}
