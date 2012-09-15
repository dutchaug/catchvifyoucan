/** Copyright 2011 by m2mobi & Lorenzo Marchiori
 *
 * Standard splash screen for general purposes
 *
 * @author Lorenzo */

package nl.catchvifyoucan;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.CountDownTimer;

public class Splash extends Activity {

	private MyCount counter;
	private final int SPLASH_TIME = 2000;
	private final int SPLASH_STEP = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
	}

	/** Method called when the screen orientation changes to set the landscape image */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		setContentView(R.layout.splash);
		super.onConfigurationChanged(newConfig);
	}

	@Override
	protected void onResume() {
		counter = new MyCount(SPLASH_TIME, SPLASH_STEP);
		counter.start();
		super.onResume();
	}

	/** The cancel here prevents the application to launch multiple activities once the splash ends */
	@Override
	protected void onPause() {
		super.onPause();
		counter.cancel();
	}

	public class MyCount extends CountDownTimer {

		public MyCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			finish();
			startActivity(new Intent(Splash.this, UserChoice.class));
		}

		@Override
		public void onTick(long millisUntilFinished) {
		}
	}
}