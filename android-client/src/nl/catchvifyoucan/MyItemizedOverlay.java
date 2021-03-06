package nl.catchvifyoucan;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

@SuppressWarnings("rawtypes")
public class MyItemizedOverlay extends ItemizedOverlay {

	Context myContext;

	private ArrayList<OverlayItem> myOverlays = new ArrayList<OverlayItem>();

	public MyItemizedOverlay(Drawable defaultMarker, Context context) {
		super(boundCenterBottom(defaultMarker));
		myContext = context;
	}

	@Override
	protected OverlayItem createItem(int i) {

		return myOverlays.get(i);
	}

	@Override
	public int size() {
		return myOverlays.size();
	}

	public void addOverlay(OverlayItem overlay) {
		myOverlays.add(overlay);
		populate();
	}
	
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = myOverlays.get(index);
	  AlertDialog.Builder dialog = new AlertDialog.Builder(myContext);
	  dialog.setTitle(item.getTitle());
	  dialog.setMessage(item.getSnippet());
	  dialog.show();
	  return true;
	}

}
