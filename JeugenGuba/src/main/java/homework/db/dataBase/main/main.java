package homework.db.dataBase.main;


import java.util.Scanner;
import static homework.db.dataBase.calculating.QECalculating.*;
import static homework.db.dataBase.insert.InsertRecord.*;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int i=0;
        System.out.print("Insert min value of koef a - ");
        int minA = scan.nextInt();
        System.out.print("Insert max value of koef a - ");
        int maxA = scan.nextInt();
        if (maxA<minA){
            System.out.println("Max value of koef a must be higher than min one. Re-Enter all, please");
            System.exit(0);
        }

        System.out.print("Insert min value of koef b - ");
        int minB = scan.nextInt();
        System.out.print("Insert max value of koef b - ");
        int maxB = scan.nextInt();
        if (maxB<minB){
            System.out.println("Max value of koef b must be higher than min one. Re-Enter all, please");
            System.exit(0);
        }

        System.out.print("Insert min value of koef c - ");
        int minC = scan.nextInt();
        System.out.print("Insert max value of koef c - ");
        int maxC = scan.nextInt();
        if (maxC<minC){
            System.out.println("Max value of koef c must be higher than min one. Re-Enter all, please");
            System.exit(0);
        }

        System.out.println("Koef a - is from " + minA + " to " + maxA);
        System.out.println("Koef b - is from " + minB + " to " + maxB);
        System.out.println("Koef b - is from " + minC + " to " + maxC);
        int koefB = minB;
        int koefC = minC;

        if (((maxC-minC)*(maxB-minB)*(maxA-minA))>=1000000){
            System.out.println("To many result. Please - insert lower diapasone of koef");
        }else {
            while (minA <= maxA){
                while (koefB <= maxB){
                    while (koefC <= maxC){
                        i++;
                        if (calcD(minA, koefB, koefC)>0) {
                            insertInDB(i,minA,koefB,koefC,calcD(minA, koefB, koefC),calcX1(minA, koefB, calcD(minA, koefB, koefC)),calcX2(minA, koefB, calcD(minA, koefB, koefC)));
                        } else {
                            if (calcD(minA, koefB, koefC)==0){
                                insertInDB(i,minA,koefB,koefC,calcD(minA, koefB, koefC),calcX1(minA, koefB, calcD(minA, koefB, koefC)));
                            } else {
                                koefC++;
                                continue;
                            }
                        }
                        koefC++;
                    }
                    koefC = minC;
                    koefB++;
                }
                koefB = minB;
                minA++;
            }
        }

    }
}
