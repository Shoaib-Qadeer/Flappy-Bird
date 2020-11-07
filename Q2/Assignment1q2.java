package com.company;


import java.math.BigInteger;
import java.util.Scanner;

public class Assignment1q2 {

    public static  BigInteger factcal(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {  // if number is equal to
            return BigInteger.valueOf(1);}
        else{
            return n.multiply(factcal(n.subtract(BigInteger.ONE)));  // subtracting one and then multiplying : calling method again.
        }
    }

    public static void main(final String[] args){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter Number :");  //
        BigInteger number= input.nextBigInteger();
        BigInteger factofnum=factcal(number);
        System.out.println("Factoiral of "+number+" is = "+factofnum);
    }

}
