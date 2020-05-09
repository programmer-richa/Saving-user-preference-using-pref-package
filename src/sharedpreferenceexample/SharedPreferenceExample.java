package sharedpreferenceexample;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * This program demonstrates how to use the Preferences class to store and
 * retrieve preference data.
 *
 * @author Richa
 *
 */
public class SharedPreferenceExample {

    /**
     * Creates a user preference node, checks if there is no key exists, and
     * then stores some configuration data. If there are keys, retrieves their
     * values and prints out them to the console.
     */
    public void getPreference() {
        Preferences userPrefs = Preferences.userNodeForPackage(this.getClass());
        try {
            String[] keys = userPrefs.keys();

            if (keys == null || keys.length == 0) {
                userPrefs.put("hostname", "localhost");
                userPrefs.putInt("port", 80);
                userPrefs.putBoolean("authentication", true);
                userPrefs.putLong("timeout", 90000);
                   
            } else {
                String hostname = userPrefs.get("hostname", null);
                int port = userPrefs.getInt("port", 80);
                boolean authentication = userPrefs.getBoolean("authentication", false);
                long timeout = userPrefs.getLong("timeout", 20000);
                String username = userPrefs.get("username", "root");
                System.out.println(hostname);
                System.out.println(port);
                System.out.println(authentication);
                System.out.println(timeout);
                System.out.println(username);
            }
        } catch (BackingStoreException ex) {
            System.err.println(ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SharedPreferenceExample pref = new SharedPreferenceExample();
        pref.getPreference();
    }

}
