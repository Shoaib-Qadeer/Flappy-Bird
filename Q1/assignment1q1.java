package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class assignment1q1 {
    public static void main(String[] args) throws IOException {
        int m1=0; int m2=0;int m3=0;int m4=0;int m5=0; int m6=0;
        int m7=0; int m8=0; int m9=0;int m10=0;int m11=0; int m12=0;

        for (int i  =0 ;i<100;i++) {
            int number = (int) (1 + Math.random() * ((12 - 1)+1) );
            if (number == 1) { m1 += 1; }
            else if (number == 2) { m2 += 1; }
            else if (number == 3) { m3 += 1; }
            else if (number == 4) { m4 += 1; }
            else if (number == 5) { m5 += 1; }
            else if (number == 6) { m6 += 1; }
            else if (number == 7) { m7 += 1; }
            else if (number == 8) { m8 += 1; }
            else if (number == 9) { m9 += 1; }
            else if (number == 10) { m10 += 1; }
            else if (number == 11) { m11 += 1; }
            else if (number == 12) { m12 += 1; } }

        System.out.println("Following are Months \n January = "+m1+"\n February = "+m2);
        System.out.println("March = "+m3+"\n April = "+m4+" \n May ="+m5);
        System.out.println("June ="+m6+" \n July = "+m7+"\n August = "+m8);
        System.out.println("September = "+m9+ "\n October = "+m10+ "\n November = "+m11+ "\n December = "+m12);

         String t_string= "Following are Months \n January = "+m1+"\n February = "+m2+"\n March = "+m3+"\n April = "+m4+" \n May ="+m5+"June ="+m6;
         String t_string2=" July = "+m7+"\n August = "+m8+"\n September = "+m9+ "\n October = "+m10+ "\n November = "+m11+ "\n December = "+m12;
        File monthsfile= new File("e:/monthsgeneratedrecord.txt");
        PrintWriter print_st= new PrintWriter(monthsfile);
        print_st.print(t_string);
        print_st.println(t_string2);
        print_st.close();
        System.out.println("Data Stored in to TXT File");
    } }
