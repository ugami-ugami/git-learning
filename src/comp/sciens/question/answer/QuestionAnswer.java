package comp.sciens.question.answer;

import java.lang.Math;

public class QuestionAnswer {
    public static void main (String[] args) {
        double PI = Math.PI;
        System.out.println(PI);

        boolean a = true;
        boolean b = false;

        System.out.println( !(a && b) && (b || a) || ((a && b) || !(a || b)) );

        int a1 = 5;
        int b1 = 10;

        System.out.println( ((a1 > b1) && (a1 < b1)) );

        System.out.println('b');
        System.out.println('b' + 'c');
        System.out.println((char) 'a' + '4');

        int Ingr = Integer.MAX_VALUE;

        System.out.println(2 * Ingr);

        System.out.println("----------------");

        double a2 = 3.14159;

        System.out.println(a2);
        System.out.println(a2 + 1);

        System.out.println("----------------");

        System.out.println(8 / (int) a2);
        System.out.println(8 / a2);
        System.out.println((int) (8 / a2));
    }
}
