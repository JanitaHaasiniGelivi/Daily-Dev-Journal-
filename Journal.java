import java.util.*;
import java.io.*;

public class Journal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n====== DAILY DEV JOURNAL ======");
            System.out.println("1. Add Details");
            System.out.println("2. Read Details");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

           
            if (choice == 1) {

                try {

                    File file = new File("Journal.txt");

                    if (file.createNewFile()) {
                        System.out.println("File created successfully");
                    } else {
                        System.out.println("File already exists");
                    }

                    
                    try (BufferedWriter bw =
                                 new BufferedWriter(new FileWriter("Journal.txt", true))) {
                        System.out.println("Enter Name:");
                        String name = sc.nextLine();
                        System.out.print("Enter Date (dd.mm.yyyy): ");
                        String date = sc.nextLine();

                        System.out.print("Enter Leetcode Problem Number: ");
                        int problemNumber = sc.nextInt();
                        sc.nextLine(); 

                        System.out.print("Enter Difficulty Level: ");
                        String difficultyLevel = sc.nextLine();

                        System.out.print("Enter Topics Included: ");
                        String topic = sc.nextLine();

                        bw.write("=================================\n");
                        bw.write("Name: "+name+"\n");
                        bw.write("Date: " + date + "\n");
                        bw.write("Problem Number: " + problemNumber + "\n");
                        bw.write("Difficulty Level: " + difficultyLevel + "\n");
                        bw.write("Topics Covered: " + topic + "\n");
                        bw.write("=================================\n\n");

                        System.out.println("Details added successfully!");

                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }

            else if (choice == 2) {

                try (BufferedReader br =
                             new BufferedReader(new FileReader("Journal.txt"))) {

                    int chr;

                    while ((chr = br.read()) != -1) {
                        System.out.print((char) chr);
                    }

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
            else if (choice == 3) {
                System.out.println("Exiting Daily Dev Journal...");
            }

            else {
                System.out.println("Invalid Choice");
            }

        } while (choice != 3);

        sc.close();
    }
}