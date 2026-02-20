package com.kce.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.kce.dao.AdoptionDAO;
import com.kce.entity.Adoption;

public class AdoptionMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AdoptionDAO adoptionDAO = new AdoptionDAO();

        int choice;

        do {
            System.out.println("\n=== ADOPTION MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Adoption");
            System.out.println("2. View All Adoptions");
            System.out.println("3. Find Adoption by ID");
            System.out.println("4. Update Adoption");
            System.out.println("5. Delete Adoption");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                Adoption adoption = new Adoption();

                System.out.print("Enter Pet ID: ");
                adoption.setPetID(sc.nextLine());

                System.out.print("Enter Adopter Name: ");
                adoption.setAdopterName(sc.nextLine());

                System.out.print("Enter Contact: ");
                adoption.setAdopterContact(sc.nextLine());

                adoption.setAdoptionDate(new Date(System.currentTimeMillis()));

                System.out.print("Enter Status: ");
                adoption.setStatus(sc.nextLine());

                boolean saved = adoptionDAO.recordAdoption(adoption);

                System.out.println(saved ? "Adoption Added!" : "Failed!");
                break;

            case 2:
                List<Adoption> adoptions = adoptionDAO.getAllAdoptions();

                if (adoptions.isEmpty()) {
                    System.out.println("No Records Found");
                } else {
                    adoptions.forEach(System.out::println);
                }
                break;

            case 3:
                System.out.print("Enter Adoption ID: ");
                int findId = sc.nextInt();

                Adoption found = adoptionDAO.findAdoption(findId);

                System.out.println(found != null ? found : "Not Found");
                break;

            case 4:
                System.out.print("Enter Adoption ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Adoption updateAdoption = adoptionDAO.findAdoption(updateId);

                if (updateAdoption == null) {
                    System.out.println("Not Found");
                    break;
                }

                System.out.print("Enter New Name: ");
                updateAdoption.setAdopterName(sc.nextLine());

                System.out.print("Enter New Contact: ");
                updateAdoption.setAdopterContact(sc.nextLine());

                System.out.print("Enter New Status: ");
                updateAdoption.setStatus(sc.nextLine());

                boolean updated = adoptionDAO.updateAdoption(updateAdoption);

                System.out.println(updated ? "Updated!" : "Failed!");
                break;

            case 5:
                System.out.print("Enter Adoption ID to Delete: ");
                int deleteId = sc.nextInt();

                boolean deleted = adoptionDAO.deleteAdoption(deleteId);

                System.out.println(deleted ? "Deleted!" : "Failed!");
                break;

            case 6:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        sc.close();
    }
}
