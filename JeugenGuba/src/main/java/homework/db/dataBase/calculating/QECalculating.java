package homework.db.dataBase.calculating;

import static java.lang.Math.sqrt;
import static java.sql.Types.NULL;

public class QECalculating {

    public static int calcD(int a, int b, int c) {
        int D = (b*b)-(4*a*c);
        return D;
    }

    public static double calcX1(int a, int b, int D) {
        if (a==0){
            double x1 = NULL;
            return x1;
        } else {
            double x1 = (b*(-1)+sqrt(D))/(2*a);
            return x1;
        }
    }

    public static double calcX2(int a, int b, int D) {
        if (a==0){
            double x2 = NULL;
            return x2;
        } else {
            double x2 = (b*(-1)-sqrt(D))/(2*a);
            return x2;
        }
    }
}
