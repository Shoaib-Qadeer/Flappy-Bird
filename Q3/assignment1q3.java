package com.company;

import java.io.*;
import java.util.Scanner;

public class assignment1q3 {

    public static void main(String[] args) throws IOException {
        try {
            Scanner input= new Scanner(System.in);
            File file1 = new File("e:/myfile001.txt");
            File file2 = new File("e:/");
            while (true) {
                System.out.println("Enter New File name: ");
                String filename = input.nextLine();
                file2 = new File("e:/" + filename + ".txt");
                if (file2.exists()) {
                    System.out.println("File already exist ");
                } else {
                    break;
                }
            }
            FileReader fileread = new FileReader(file1);
            BufferedReader br = new BufferedReader(fileread);
            FileWriter filewrite = new FileWriter(file2, true);
            String s;
            int count=0;

            while ((s = br.readLine()) != null) { // read a line
                filewrite.write(count+" "+ s); // write to output file
                filewrite.flush();
                count+=1;
                filewrite.write(System.getProperty("line.separator"));
            }
            br.close();
            filewrite.close();
            System.out.println("file copied");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        }
    }


