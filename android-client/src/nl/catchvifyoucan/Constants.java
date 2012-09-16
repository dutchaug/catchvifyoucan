package nl.catchvifyoucan;

public class Constants {

	// Splash screen durations
	public static final int SPLASH_STEP = 100;
	public static final int SPLASH_TIME = 2000;

	// Shared Preference labels
	public final static String PREFERENCES_NAME = "CatchifVcanPref";
	public final static String SP_FIRST_TIME_LABEL = "first_time";
	public final static String SP_USER_ROLE_LABEL = "role";
	public final static String SP_USER_NAME_LABEL = "name";
	public final static String SP_USER_EMAIL_LABEL = "email";
	
	public final static String SERVER_URL ="http://10.0.1.7:8080/catchvifyoucan-grails-server/api/";
	
	//JSON Tags
	public final static String GAMES = "games";
	// Roles
	public final static String FUGITIVE = "fugitive";
	public final static String INVESTIGATOR = "investigator";
}