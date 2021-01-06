//--== CS400 File Header Information ==--
//Name: Carter Craney
//Email: wcraney@wisc.edu
//Team: IG
//TA: Mu Cai
//Lecturer: Gary Dahl
//Notes to Grader: none

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MajorMaker {
    private Backend app;
    
    public MajorMaker(Backend app) {
        this.app = app;
    }

public static void main(String[] args) {
     Backend majors = new Backend();
     String compsci = "Computer Science";
     String math = "Mathematics";
     String econ = "Economics";
     majors.addMajor(compsci);
     majors.addMajor(math);
     majors.addMajor(econ);
     String CSFile = "CSMajor.txt";
     String EconFile = "EconMajor.txt";
     String MathFile = "MathMajor.txt";
     File csMajor = new File(CSFile);
     File econMajor = new File(EconFile);
     File mathMajor = new File(MathFile);
     maker(csMajor, compsci, majors);
     maker(econMajor, econ, majors);
     maker(mathMajor, math, majors);
 }

 public static void maker(File majorFile, String major, Backend majors) {
   //Loop to add all the cs classes first
   
   try {
     Scanner CS = new Scanner(majorFile);
     //Creates an over sized array for pre reqs
     String[] preReqs = new String[10];
     int counter = 0;
     //Keeps running through the file until there are no lines left
     while(CS.hasNextLine()) {
       counter = 0;
       //Keeps the first line, which is course
       String course = CS.nextLine();
       //Runs until the line is in integer, which will be the credits
       while(!CS.hasNextInt() && CS.hasNextLine()) {
         preReqs[counter] = CS.nextLine();
         //Adds the pre-req to the over sized array and adds one to the counter
         counter += 1;
       }
       //Then creates an array of the correct size and fills it
       String[] preReq = new String[counter];
       for(int i = 0; i<counter; i++) {
         preReq[i] = preReqs[i];
       }
       //Then adds the course and skips unnecessary lines in the text file
       majors.addCourse(major, course);
       if (CS.hasNextLine()) 
           CS.nextLine();
           if (CS.hasNextLine()) 
               CS.nextLine();
     }
   }catch(FileNotFoundException e) {
     System.out.println("Could not find file");
   }
  
   //Then a loop to add all of the edges with pre-reqs
   try {
     Scanner CS1 = new Scanner(majorFile);
     while(CS1.hasNextLine()) {
       
       String course1 = CS1.nextLine();
       if (course1.equals("")) {
           continue;
       }
       //Creates an oversized array to hold pre req classes
       String[] preReq1 = new String[20];
       int counter1 = 0;
       while(!CS1.hasNextInt() && CS1.hasNextLine()) {
         //Runs a loop until it runs into an integer, and adds pre reqs to the array
         preReq1[counter1] = CS1.nextLine();
         counter1++;
//         System.out.println(preReq1[counter1]);
       }
       int credits = 0;
       if (CS1.hasNextLine()) {
           credits = CS1.nextInt();
       }
       //Then creates a credits variable and adds all the pre reqs 
       for(int i = 0; i < counter1; i++) {
           System.out.println("Course Src: " + course1);
           System.out.println("Course Target: " + preReq1[i]);
         majors.addCourseConnection(major, course1, preReq1[i], credits);
       } 
     }
   }catch(FileNotFoundException e) {
     System.out.println("Could not find file");
   }
 }
 
   
}


