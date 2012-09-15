package nl.catchvifyoucan;

import android.os.Bundle;


import com.google.android.maps.MapActivity;

public class MainActivity extends MapActivity {
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        com.google.android.maps.MapView webView = (com.google.android.maps.MapView)findViewById(R.id.mainMV);
		webView.setBuiltInZoomControls(true);
		
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}