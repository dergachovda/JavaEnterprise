package bug_2;

public class NullPointerExceptionBug_1 {
    static String msg;

    public static void main(String[] args) {
        String out = Test.handle(new Formatter(), msg);
        System.out.println(out);
    }
}

class Formatter {
    public String format(String value) {
        return "[" + value + "]";
    }
}

class Test {
    public static String handle(Formatter f, String s) {
        if (s == null) {
            return "(none)";
        }
        return f.format(s.trim());
    }
}