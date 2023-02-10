package org.fsdphaseone;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declare variables
        final String dir = System.getProperty("user.dir");
        Scanner in = new Scanner(System.in);

        FileHandler fh = new FileHandler();

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


            int option = in.nextInt();
            switch (option){
                case 1:
                    System.out.println("Files list:");
                    fh.filesInDir(dir);
                    break;
                case 2:
                    context = "file_management";
                    do{
                        System.out.println("Manage files operations:\n\t1.Create file\n\t2.Delete file\n\t3.Search file\n\t4.Go back");
                        option = in.nextInt();
                        String file = "";
                        switch (option){

                            case 1:
                                System.out.print("Enter file name:");
                                file = getInput();
                                fh.createFile(dir, file);
                                break;

                            case 2:
                                System.out.print("Enter file name:");
                                file = getInput();
                                fh.deleteFile(dir, file);
                                break;

                            case 3:
                                System.out.print("Enter file name:");
                                file = getInput();
                                System.out.println("Searching:"+file);
                                fh.searchFile(dir, file);
                                break;
                            case 4:
                                context = "welcome_page";
                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;

                        }
                    }while (context == "file_management");
                    break;
                case 3:
                    System.out.println("Application closed");
                    System.exit(0);
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

}