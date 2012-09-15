package nl.catchvifyoucan;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class App extends Application {
	
	public boolean firstTime = true;
	public SharedPreferences prefs;
	
	@Override
	public void onCreate() {
		super.onCreate();
		init();
	}
	
	public void init() {
		prefs = getSharedPreferences(Constants.PREFERENCES_NAME, Context.MODE_PRIVATE);
		
		if (isFirstTime()) {
			setFirstTime(false);
		}
	}
	
	public void setFirstTime(boolean status) {
		if (prefs != null) {
			Editor edit = prefs.edit();
			edit.putBoolean(Constants.SP_FIRST_TIME_LABEL, status);
			edit.commit();
		}
	}

	public boolean isFirstTime() {
		if (prefs != null && prefs.getBoolean(Constants.SP_FIRST_TIME_LABEL, true)) {
			return prefs.getBoolean(Constants.SP_FIRST_TIME_LABEL, true);
		} else {
			return false;
		}
	}
}
