package nl.catchvifyoucan;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MainActivity extends MapActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		com.google.android.maps.MapView mapView = (com.google.android.maps.MapView) findViewById(R.id.mainMV);
		mapView.setBuiltInZoomControls(true);

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.androidmarker);
		MyItemizedOverlay itemizedoverlay = new MyItemizedOverlay(
				drawable, this);
		
		GeoPoint point = new GeoPoint(41889882,12479267);
		OverlayItem overlayitem = new OverlayItem(point, "Hey", "I'm in Rome!");
		GeoPoint point2 = new GeoPoint(52374004,4890359);
		OverlayItem overlayitem2 = new OverlayItem(point2, "Hallo", "I'm in Amsterdam!");
		
		itemizedoverlay.addOverlay(overlayitem);
		itemizedoverlay.addOverlay(overlayitem2);
		mapOverlays.add(itemizedoverlay);
		
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}