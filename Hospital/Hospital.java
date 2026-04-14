package Hospital;
import java.util.*;


public class Hospital {
    public static void main(String[] args) {
        HospitalService u = new HospitalService();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the choice \n 1. create patient \n 2. create doctor \n 3. doctorassignment \n 4. patientHistory \n 5. doctor history \n 6. Treatment Information \n 7. Total Patient \n 8. Total Doctor \n 9. Exit");
        while (true) {
            System.out.println("Enter your choice: ");
            int n = s.nextInt();
            s.nextLine(); 

            switch (n) {
                case 1:
                    System.out.println("Enter Patient Name:");
                    String pname = s.nextLine();
                    System.out.println("Enter Patient Password:");
                    String ppwd = s.nextLine();
                    System.out.println("Enter Patient Mobile Number:");
                    String pmn = s.nextLine();

                    u.createPatient(pname, ppwd, pmn);
                    System.out.println("Patient Created");
                    break;

                case 2:
                    System.out.println("Enter Doctor Name:");
                    String dname = s.nextLine();
                    System.out.println("Enter Doctor Password:");
                    String dpwd = s.nextLine();

                    u.createDoctor(dname, dpwd);
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
                    System.out.println("Exiting...");
                    s.close();
                    break;

                default:
                    System.out.println("Invalid Choice. Try again!");
            }
            System.out.println();
        }
    }
}