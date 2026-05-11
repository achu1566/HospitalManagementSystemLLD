package Hospital;

import java.util.*;
import User.doctor;
import User.patient;

public class Hospital extends Auth{
    public static void main(String[] args) {
        HospitalService u = new HospitalService();
        Hospital h = new Hospital();
        Scanner s = new Scanner(System.in);
        System.out.println("\t\t\t-----------------------------------------");
        System.out.println();
        System.out.println("\t\t\tWelcome to the Hospital Management System");
        System.out.println();
        System.out.println("\t\t\t-----------------------------------------");

        while (true) {
            System.out.println("Login as: \n 1. Admin \n 2. Doctor \n 3. Patient");
            int choice = s.nextInt();
            s.nextLine();
            if (choice == 1) {
                System.out.println("Enter Admin ID: ");
                String AdminId = s.nextLine();
                System.out.println("Enter Admin Password: ");
                String AdminPassword = s.nextLine();
                
                if(!isLoginAdmin(AdminId, AdminPassword)){
                    System.out.println("Invalid Credentials. Returning to Login Page...");
                    continue;
                }

                System.out.println(
                        "Enter the choice \n 1. create patient \n 2. create doctor \n 3. doctorassignment \n 4. patientHistory \n 5. doctor history \n 6. Treatment Information \n 7. Total Patient \n 8. Total Doctor \n 9. Move to Login Page \n 10. Exit");
                while (true) {
                    System.out.println("Enter your choice: ");
                    int n = s.nextInt();
                    s.nextLine();
                    boolean isLogin = false;    

                    switch (n) {
                        case 1:
                            boolean createdPatient = false;
                            

                            while(!createdPatient){
                                System.out.println("Enter Patient Name:");
                                String pname = s.nextLine();
                                System.out.println("Enter Patient Username: ");
                                String pun = s.nextLine();
                                System.out.println("Enter Patient Password:");
                                String ppwd = s.nextLine();
                                System.out.println("Enter Patient Mobile Number:");
                                String pmn = s.nextLine();

                                createdPatient = u.createPatient(pname, pun, ppwd, pmn);
                                if(!createdPatient){
                                    System.out.println("Failed to create patient. Please try again.");
                                }
                            }
                            System.out.println("Patient Created");
                            break;

                        case 2:
                            boolean created = false;
                            

                            while(!created){
                                System.out.println("Enter Doctor Name:");
                                String dname = s.nextLine();
                                System.out.println("Enter Doctor Username:");
                                String dun = s.nextLine();
                                System.out.println("Enter Doctor Password:");
                                String dpwd = s.nextLine();
                                created = u.createDoctor(dname,dun, dpwd);

                                if(!created){
                                    System.out.println("Failed to create doctor. Please try again.");
                                }
                            }

                            System.out.println("Doctor Created");
                            break;

                        case 3:
                            System.out.println("Enter Patient ID:");
                            String patientId = s.nextLine();
                            System.out.println("Enter Doctor ID:");
                            String docId = s.nextLine();
                            System.out.println("Enter Appointment Date:");
                            String aDate = s.nextLine();

                            u.assignDoctorToPatient(patientId, docId, aDate);
                            break;

                        case 4:
                            System.out.println("Enter Patient ID:");
                            String patid = s.nextLine();
                            u.patientList(patid);
                            break;

                        case 5:
                            System.out.println("Enter Doctor ID:");
                            String docid = s.nextLine();
                            u.doctorList(docid);
                            break;

                        case 6:
                            u.treatmentDetails();
                            break;

                        case 7:
                            u.totalPatient();
                            break;

                        case 8:
                            u.totalDoctor();
                            break;

                        case 9:
                            System.out.println("Moving to Login Page...");
                            isLogin = true;
                            break;

                        case 10:
                            System.out.println("Exiting...");
                            s.close();
                            break;

                        default:
                            System.out.println("Invalid Choice. Try again!");
                    }
                    System.out.println();
                    if(isLogin) {
                        break;
                    }
                }
            } else if (choice == 2) {
                System.out.println("Enter Doctor Username: ");
                String uname = s.nextLine();
                System.out.println("Enter Doctor Password: ");
                String upwd = s.nextLine();

                if(!h.isLoginDoctor(u, uname, upwd)){
                    System.out.println("Invalid Credentials. Returning to Login Page...");
                    continue;
                }

                String doctorId = "";
                for(Map.Entry<String, doctor> d : u.D.entrySet()){
                    if(d.getValue().getUserName().equals(uname)){
                        doctorId = d.getKey();
                        break;
                    }
                }

                System.out.println(
                        "Enter the choice \n 1. doctor history \n 2. Total Doctor \n 3. patientHistory \n 4. Total Patient \n 5. Treatment Information \n 6. Move to Login Page \n  7. Exit");
                while (true) {
                    System.out.println("Enter your choice: ");
                    int n = s.nextInt();
                    s.nextLine();
                    boolean isLogin = false;

                    switch (n) {
                        case 1:
                            u.doctorList(doctorId);
                            break;

                        case 2:
                            u.totalDoctor();
                            break;

                        case 3:
                            System.out.println("Enter Patient ID:");
                            String patid = s.nextLine();
                            u.patientList(patid);
                            break;

                        case 4:
                            u.totalPatient();
                            break;

                        case 5:
                            u.treatmentDetails();
                            break;

                        case 6:
                            System.out.println("Moving to Login Page...");
                            isLogin = true;
                            break;

                        case 7:
                            System.out.println("Exiting...");
                            s.close();
                            break;

                        default:
                            System.out.println("Invalid Choice. Try again!");
                    }
                    System.out.println();
                    if(isLogin) {
                        break;
                    }
                }
            } else if (choice == 3) {
                System.out.println("Enter Patient Username: ");
                String uname = s.nextLine();
                System.out.println("Enter Patient Password: ");
                String upwd = s.nextLine();

                if(!h.isLoginPatient(u, uname, upwd)){
                    System.out.println("Invalid Credentials. Returning to Login Page...");
                    continue;
                }
                System.out.println(
                        "Enter the choice \n 1. patientHistory \n 2. Total Patient \n 3. Total Doctor \n 4. Treatment Information  \n 5. Move to Login Page \n  6. Exit");

                String patientId = "";

                for(Map.Entry<String, patient> p : u.P.entrySet()){
                    if(p.getValue().getUserName().equals(uname)){
                        patientId = p.getKey();
                        break;
                    }
                }
                while (true) {
                    System.out.println("Enter your choice: ");
                    int n = s.nextInt();
                    s.nextLine();
                    boolean isLogin = false;

                    switch (n) {
                        case 1:
                            u.patientList(patientId);
                            break;

                        case 2:
                            u.totalPatient();
                            break;

                        case 3:
                            u.totalDoctor();
                            break;

                        case 4:
                            u.treatmentDetails();
                            break;

                        case 5:
                            System.out.println("Moving to Login Page...");
                            isLogin = true;
                            break;

                        case 6:
                            System.out.println("Exiting...");
                            s.close();
                            break;

                        default:
                            System.out.println("Invalid Choice. Try again!");
                    }
                    System.out.println();
                    if(isLogin){
                        break;
                    }
                }
            } else if (choice == 4) {
                System.out.println("Move to Login Page...");
                break;
            } else {
                System.out.println("Invalid Choice. Exiting...");
                s.close();
                break;
            }
        }
    }
    
    public static boolean isLoginAdmin(String AdminId, String AdminPassword){
        if(loginAdmin(AdminId, AdminPassword)) return true;
        else return false;
    }public boolean isLoginPatient(HospitalService HS, String patientUsername, String patientPassword){
        if(loginPatient(HS, patientUsername, patientPassword)) return true;
        else return false;
    }public boolean isLoginDoctor(HospitalService HS, String doctorUsername, String doctorPassword){
        if(loginDoctor(HS, doctorUsername, doctorPassword)) return true;
        else return false;
    }
}