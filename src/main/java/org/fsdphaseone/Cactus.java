package org.fsdphaseone;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Cactus {
    public static void main(String[] args) {

        //declare variables
        final String dir = System.getProperty("user.dir");
        Scanner in = new Scanner(System.in);

        //menu contexts
        System.out.println("------------------------------------------------------------");
        System.out.println("Cactus- directory management application\n");
        System.out.println("Author: \n\tEvance Nganyaga (evance.nganyaga@vodacom.co.tz)");
        System.out.println("Usage: \n\tEnter a corresponding number to execute an operation");
        System.out.println("------------------------------------------------------------\n");

        String context = "welcome_page";
        System.out.println("Current directory: \n\t"+dir+"\n");
        do{
            System.out.println("Select operation:");
            System.out.println("\t1.List files\n\t2.Manage files\n\t3.Close program");

            String option = in.nextLine();
            switch (option){
                case "1":
                    System.out.println("Files list:");
                    filesInDir(dir);
                    break;
                case "2":
                    context = "file_management";
                    do{
                        System.out.println("Manage files operations:\n\t1.Create file\n\t2.Delete file\n\t3.Search file\n\t4.Go back");
                        option = in.nextLine();
                        String file = "";
                        switch (option){

                            case "1":
                                System.out.print("Enter file name:");
                                file = getInput();
                                createFile(dir, file);
                                break;

                            case "2":
                                System.out.print("Enter file name:");
                                file = getInput();
                                deleteFile(dir, file);
                                break;

                            case "3":
                                System.out.print("Enter file name:");
                                file = getInput();
                                System.out.println("Searching:"+file);
                                searchFile(dir, file);
                                break;
                            case "4":
                                context = "welcome_page";
                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;

                        }
                    }while (context == "file_management");
                    break;
                case "3":
                    System.out.println("Application closed");
                    close();
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }while (context=="welcome_page");

    }

    static String getInput(){
        Scanner userInputObj = new Scanner(System.in);
        return userInputObj.nextLine().toString();
    }

    static  void filesInDir(String dir){
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        int k = 1;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("\t"+ listOfFiles[i].getName());
                k++;
            }
        }
    }

    static void  createFile(String dir, String filename){
        try {
            File myObj = new File(dir+"/"+filename);
            if (myObj.createNewFile()) {
                System.out.println("\tFile created: " + myObj.getName());
            } else {
                System.out.println("\tFile already exists.");
            }
        } catch (IOException e) {
            System.out.println("\tAn error occurred.");
            e.printStackTrace();
        }
    }

    static  void deleteFile(String dir, String filename){
        //delete file
        File myObj = new File(dir+"/"+filename);
        if (myObj.delete()) {
            System.out.println("\tDeleted the file: " + myObj.getName());
        } else {
            System.out.println("\tFailed to delete the file.");
        }
    }

    static  void searchFile(String dir, String filename){
        //search for a file
        File folder = new File(dir);
        File[] listOfFiles = folder.listFiles();
        Arrays.sort(listOfFiles);
        int k = 1;
        boolean found = false;
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                String temp = listOfFiles[i].getName();
                temp = temp.toLowerCase();
                filename = filename.toLowerCase();
                if(temp.indexOf(filename) >= 0){
                    //the file is found
                    System.out.println("\t"+ listOfFiles[i].getName());
                    found = true;
                }

                k++;
            }
        }
        //file not found
        if (!found){
            System.out.println("\tFile not found");
        }

    }

    static void close(){
        System.exit(0);
    }


}