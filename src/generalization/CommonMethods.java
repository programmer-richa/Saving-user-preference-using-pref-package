package generalization;

/**
 * Methods frequently used in un-related classes
 *
 * @author Richa
 */
public interface CommonMethods {

    /**
     * @param arr reference of the object array to be printed
     */
    default void printArray(Object[] arr) {
        for (Object val : arr) {
            System.out.println(val.toString());
        }
    }

    default void printSeperator() {
        System.out.println("=============================================");
    }

}
