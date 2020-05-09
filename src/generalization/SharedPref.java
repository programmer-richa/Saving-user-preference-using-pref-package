package generalization;

import java.util.ArrayList;
import java.util.prefs.Preferences;

/**
 * Generic class to set and retrieve preference values
 *
 * @author Richa
 */
public class SharedPref {

    /**
     * @param key name of the key to be retrieved
     * @return String value of the key
     */
    public static String getPrefVal(String key) {
        String result = "";
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            result = prefs.get(key, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @return ArrayList of key,value pair
     */
    public static ArrayList<PreferenceData> getAllKeyValuePair() {
        ArrayList<PreferenceData> result = new ArrayList<>();
        try {
            String[] keys = getAllKeys();
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            for (String key : keys) {
                result.add(new PreferenceData(key, prefs.get(key, "")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @return String[] of all the key
     */
    public static String[] getAllKeys() {
        String[] keys = null;
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            keys = prefs.keys();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keys;
    }

    /**
     * @param key name of the key to be removed
     * @return true if the key is removed
     */
    public static boolean removePrefKey(String key) {
        boolean result = false;
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            prefs.remove(key);
            prefs.sync();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @return true if the node is removed
     */
    public static boolean removePrefNode() {
        boolean result = false;
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            prefs.removeNode();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @return true if the key are unset
     */
    public static boolean clear() {
        boolean result = false;
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            prefs.clear();
            prefs.sync();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    /**
     * @param key name of the key to be assigned value
     * @param value value to be assigned
     * @return true if the value saved
     */
    public static boolean setPrefVal(String key, String value) {
        boolean result = false;
        try {
            Preferences prefs;
            prefs = Preferences.userRoot().node(Constants.SHARED_PREF_DB_NAME);
            prefs.put(key, value);
            prefs.sync();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

}
