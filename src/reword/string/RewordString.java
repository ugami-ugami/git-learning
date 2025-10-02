package reword.string;

public class RewordString {

    public static String reStr (String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i --) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean pollyStr (String str) {
        boolean pollyResult = false;
        String result = "";
        for (int i = str.length() - 1; i >= 0; i --) {
            result += str.charAt(i);
        }
        if (str.equals(result)) {
            pollyResult = true;
        }
        return pollyResult;
    }

    public static void main (String[] args) {

        System.out.println(reStr("Hello 123"));

        System.out.println(pollyStr("ollo"));
    }
}
