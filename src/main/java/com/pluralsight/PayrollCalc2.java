package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PayrollCalc2 {
    public static Scanner thescanner = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("Input file name: ");

        String inputFileName = thescanner.nextLine();

        System.out.println("Output file name: ");

        String outputFileName = thescanner.nextLine();



        String line;
        try {


            FileReader theReader = new FileReader("src/main/resources/" + inputFileName);
            BufferedReader theFile = new BufferedReader(theReader);

            FileWriter fileWriter = new FileWriter("src/main/resources/" +outputFileName);
            BufferedWriter bufWriter = new BufferedWriter(fileWriter);
             theFile.readLine();

              bufWriter.write("id|name|gross pay\n");


            while ((line = theFile.readLine()) != null) {


                String[] employeeLData = line.split("\\|");
                int employeeId = Integer.parseInt(employeeLData[0]);
                String name = employeeLData[1];
                double hoursWorked = Double.parseDouble(employeeLData[2]);
                double payRate = Double.parseDouble(employeeLData[3]);

                Employee currentemployee = new Employee(employeeId, name, hoursWorked, payRate);

              String newFile =  String.format("%d|%s|%.2f\n", currentemployee.getEmployeeId(), currentemployee.getName(), currentemployee.getGrossPay());

              bufWriter.write(newFile);

                }

            bufWriter.close();

            theFile.close();




        } catch (Exception e) {
            System.out.println("File not found");

        }




    }
}
