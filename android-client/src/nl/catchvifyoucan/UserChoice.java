package nl.catchvifyoucan;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class UserChoice extends Activity {

	private Button register;
	private ImageButton investigator, fugitive;
	private EditText name, email;
	private String myID;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_choice);
		init();
	}

	public void init() {

		myID = Secure.getString(getBaseContext().getContentResolver(), Secure.ANDROID_ID);

		investigator = (ImageButton) findViewById(R.id.btn_investigator);
		fugitive = (ImageButton) findViewById(R.id.btn_escapee);
		name = (EditText) findViewById(R.id.user_name);
		email = (EditText) findViewById(R.id.user_email);
		register = (Button) findViewById(R.id.register_user);

		investigator.setOnClickListener(listener);
		fugitive.setOnClickListener(listener);
		register.setOnClickListener(listener);
	}

	public OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btn_escapee:

					break;
				case R.id.btn_investigator:

					break;
				case R.id.register_user:

					break;
				default:
					break;
			}
		}

	};
}
