package helperClasses;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.example.fortunephiri.assignment.R;

public class SharedPreferenceConfig {
    private SharedPreferences sharedPreferences;
    private Context context;

    public SharedPreferenceConfig(Context context)    //constructor that sets initializes the sharedPreference object
        {
            this.context = context;
            //getting the name of the shared preference that is stored as a string resource
            this.sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference_name),Context.MODE_PRIVATE);

        }

    public void writeUsernamePref(String name)      //method writes the username to shared preferences
        {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(context.getResources().getString(R.string.username_preference),name);
            editor.commit();
            Log.d("SharedPref",name);
        }

    public String readUserNamePref()              //method used to get the username from shared preferences
        {
            String username ="";
            username= sharedPreferences.getString(context.getResources().getString(R.string.username_preference),username);
            return username;
        }
}
