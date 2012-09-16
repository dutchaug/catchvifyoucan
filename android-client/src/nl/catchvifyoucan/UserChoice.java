package nl.catchvifyoucan;

import nl.catchvifyoucan.dal.Requests;
import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserChoice extends Activity {

	private Button register;
	private Button investigator, fugitive;
	private EditText name, email;
	private String myID;
	private String role;
	private App app;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = (App)getApplication();
		setContentView(R.layout.user_choice);
		init();
	}

	public void init() {

		myID = Secure.getString(app.getContentResolver(), Secure.ANDROID_ID);

		investigator = (Button) findViewById(R.id.btn_investigator);
		fugitive = (Button) findViewById(R.id.btn_escapee);
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
					Toast.makeText(app, "Fugitive", Toast.LENGTH_SHORT).show();
					role = Constants.FUGITIVE;
					break;
				case R.id.btn_investigator:
					Toast.makeText(app, "Investigator", Toast.LENGTH_SHORT).show();
					role = Constants.INVESTIGATOR;
					break;
				case R.id.register_user:
					setUser();
//					startActivity(new Intent(UserChoice.this, MainActivity.class));
					break;
				default:
					break;
			}
		}
	};

	public void setUser() {
		if (app.prefs != null) {
			Editor edit = app.prefs.edit();
			edit.putString(Constants.SP_USER_ROLE_LABEL, role);
			edit.putString(Constants.SP_USER_NAME_LABEL, name.getText().toString());
			edit.putString(Constants.SP_USER_EMAIL_LABEL, email.getText().toString());
			edit.commit();
		}
		new Requests().getListOfGames();
	}
}