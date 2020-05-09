package generalization;

/**
 * Example of generic implementation of Preference (SharedPref) class
 *
 * @author Richa
 */
public class Example implements CommonMethods {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Example exmp = new Example();
        SharedPref.setPrefVal("Name", "Richa");
        SharedPref.setPrefVal("Qualification", "MCA");
        SharedPref.setPrefVal("Company", "TCY");
        System.out.println("Returned value : " + SharedPref.getPrefVal("Username"));
        System.out.println(SharedPref.getAllKeyValuePair());
//        exmp.printArray(SharedPref.getAllKeys());
//        exmp.printSeperator();
//        SharedPref.removePrefKey("Richa"); // doesn't raise an exception
//        SharedPref.removePrefKey("Name");
//        exmp.printArray(SharedPref.getAllKeys());
//        exmp.printSeperator();
//        SharedPref.clear();
//        exmp.printArray(SharedPref.getAllKeys());
//        exmp.printSeperator();
//        SharedPref.removePrefNode();
    }

}
