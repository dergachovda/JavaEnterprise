package bug_11;

/**
 * uncommented this piece of code
 *
 * remember for min changes
 */
public class IsEmptyString {
    private static String CUSTOM_DEFAULT_VALUE;// not initialize it in declaration

    public static void main(String[] args) {
        CUSTOM_DEFAULT_VALUE = "test";
        if (args[0].equals(CUSTOM_DEFAULT_VALUE)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }
}
