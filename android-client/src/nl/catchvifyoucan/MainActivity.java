package nl.catchvifyoucan;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity {

	LocationManager locationManager;
	private int longitude = 0;
	private int latitude = 0;
	
	private static final double LOCATIONMULTIPLIER = 1000000.0;
	
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		com.google.android.maps.MapView mapView = (com.google.android.maps.MapView) findViewById(R.id.mainMV);
		mapView.setBuiltInZoomControls(true);
		
		/**Here we get the overlay from the map on the view*/
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.androidmarker);
		MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(drawable,
				this);

		setActualPosition();
		
		/**Show the item on the current position*/
		GeoPoint currentPoint = new GeoPoint(latitude, longitude);

		GeoPoint point = new GeoPoint(41889882, 12479267);
		OverlayItem overlayitem = new OverlayItem(point, "Hey", "I'm in Rome!");
		OverlayItem overlayitem2 = new OverlayItem(currentPoint, "Hallo",
				"I'm in Amsterdam!");

		itemizedoverlay.addOverlay(overlayitem);
		itemizedoverlay.addOverlay(overlayitem2);
		mapOverlays.add(itemizedoverlay);
		

	}
	
	/**Instance of the locationmanager to get the lad and lon*/
	private void setActualPosition(){
		
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		Location location = locationManager
				.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		
		/**Google maps GeoPoint coordinates are specified in microdegrees (degrees * 1e6)*/
		latitude = (int) (location.getLatitude() * LOCATIONMULTIPLIER);
		longitude = (int) (location.getLongitude() * LOCATIONMULTIPLIER);
	}


	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}