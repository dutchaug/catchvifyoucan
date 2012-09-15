package nl.catchvifyoucan;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity {

	private LocationManager locationManager;
	private TelephonyManager telman;
	private MyItemizedOverlay itemizedoverlay;
	private OverlayItem overlayitem;
	private List<Overlay> mapOverlays;
	private com.google.android.maps.MapView mapView;
	private int longitude = 0;
	private int latitude = 0;
	private String imei = null;
	int updated = 0;

	private static final double LOCATIONMULTIPLIER = 1000000.0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		mapView = (com.google.android.maps.MapView) findViewById(R.id.mainMV);
		mapView.setBuiltInZoomControls(true);

		/** Here we get the overlay from the map on the view */
		mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.androidmarker);
		itemizedoverlay = new MyItemizedOverlay(drawable, this);

		setInitialPosition();

		/** Show the item on the current position */
		GeoPoint currentPoint = new GeoPoint(latitude, longitude);

		overlayitem = new OverlayItem(currentPoint, "Hallo",
				"I'm in Amsterdam!");

		itemizedoverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedoverlay);

		setImeiNumber();

		pushPosition();

	}
	
	private void updateLocation(Location location) {
		/**
		 * Google maps GeoPoint coordinates are specified in microdegrees
		 * (degrees * 1e6)
		 */

		updated += 1;

		latitude = (int) (location.getLatitude() * LOCATIONMULTIPLIER);
		longitude = (int) (location.getLongitude() * LOCATIONMULTIPLIER);
		/** Show the item on the current position */
		GeoPoint currentPoint = new GeoPoint(latitude, longitude);
		
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.androidmarker);
		itemizedoverlay = new MyItemizedOverlay(drawable, this);

		overlayitem = new OverlayItem(currentPoint, "" + updated,
				"keer geupdate");

		mapOverlays.clear();
		
		runOnUiThread(new Runnable() {
			public void run() {
				itemizedoverlay.addOverlay(overlayitem);
				mapOverlays.add(itemizedoverlay);
//				Toast.makeText(MainActivity.this, "Update!", Toast.LENGTH_SHORT).show();
				mapView.invalidate();
			}
		});
		
	}

	/** Instance of the locationmanager to get the lad and lon */
	private void setInitialPosition() {

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Location location = locationManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
				1 * 1000, 0, new MyLocationListener());

		/**
		 * Google maps GeoPoint coordinates are specified in microdegrees
		 * (degrees * 1e6)
		 */
		if(location != null){
			latitude = (int) (location.getLatitude() * LOCATIONMULTIPLIER);
			longitude = (int) (location.getLongitude() * LOCATIONMULTIPLIER);
		}else{
		latitude = 52000000;
		longitude = 4000000;}
	}

	

	private void pushPosition() {
		setInitialPosition();
		LocationDataManager dm = new LocationDataManager();
		dm.pushLocationToServer(imei, latitude, longitude);
	}

	/** Every 60 seconds the current position is pushed to the server */

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	/** Set the imei from the device so it can be pushed to the server */
	private void setImeiNumber() {
		telman = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
		imei = telman.getDeviceId();
	}

	private class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location loc) {
			if (loc != null) {
				/** Now we have the new location */
				updateLocation(loc);
			}
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// Do something here if you would like to know when the provider is
			// disabled by the user
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// Do something here if you would like to know when the provider is
			// enabled by the user
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// Do something here if you would like to know when the provider
			// status changes
		}
	}
}