import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        FractionList s1 = new FractionList();
        FileReader file = new FileReader("input.txt");
        Scanner scan = new Scanner(file);

        while(scan.hasNextInt()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            Fraction F = new Fraction(a, b);
            s1.add(F);
        }

        Polinom p1 = new Polinom(s1);
        System.out.println(p1.toString());
        //System.out.println(s1.getMin());
        //System.out.println(s1.getMax());

        Fraction f1 = new Fraction(2,5);
        Fraction f2 = new Fraction(3,4);
        Fraction f3 = new Fraction(4,7);
        FractionList s2 = new FractionList(f1, f2, f3);
        Polinom p2 = new Polinom(s2);
        System.out.println(p2.toString());
        Polinom p3 = p1.sum(p2);
        System.out.println(p3.toString());

    }
}