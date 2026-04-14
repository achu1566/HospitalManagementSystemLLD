import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        User u = new User();
        Scanner s = new Scanner(System.in);
        System.out.println(
                "Enter the choice \n 1. create patient \n 2. create doctor \n 3. doctorassignment \n 4. patientHistory \n 5. doctor history \n 6. Treatment Information \n 7. Total Patient \n 8. Total Doctor");
        while (true) {
            System.out.println("Enter your choice: ");
            int n = s.nextInt();
            s.nextLine(); 

            switch (n) {
                case 1:
                    System.out.println("Enter Patient ID:");
                    String pid = s.nextLine();
                    System.out.println("Enter Patient Name:");
                    String pname = s.nextLine();
                    System.out.println("Enter Patient Password:");
                    String ppwd = s.nextLine();
                    System.out.println("Enter Patient Mobile Number:");
                    String pmn = s.nextLine();

                    u.createPatient(pid, pname, ppwd, pmn);
                    System.out.println("Patient Created");
                    break;

                case 2:
                    System.out.println("Enter Doctor ID:");
                    String did = s.nextLine();
                    System.out.println("Enter Doctor Name:");
                    String dname = s.nextLine();
                    System.out.println("Enter Doctor Password:");
                    String dpwd = s.nextLine();

                    u.createDoctor(did, dname, dpwd);
                    System.out.println("Doctor Created");
                    break;

                case 3:
                    System.out.println("Enter Treatment ID:");
                    long tid = s.nextLong();
                    s.nextLine(); 

                    System.out.println("Enter Patient ID:");
                    String patientId = s.nextLine();
                    System.out.println("Enter Doctor ID:");
                    String docId = s.nextLine();
                    System.out.println("Enter Appointment Date:");
                    String aDate = s.nextLine();

                    u.assignDoctorToPatient(tid, patientId, docId, aDate);
                    System.out.println("Doctor assigned to Patient");
                    break;

                case 4:
                    System.out.println("Enter Patient ID:");
                    String patid = s.nextLine();
                    System.out.println("Patient Information:");
                    u.patientList(patid);
                    break;

                case 5:
                    System.out.println("Enter Doctor ID:");
                    String docid = s.nextLine();
                    System.out.println("Doctor Information:");
                    u.doctorList(docid);
                    break;

                case 6:
                    System.out.println("Treatment Information:");
                    u.treatmentDetails();
                    break;

                case 7:
                    u.totalPatient();
                    break;

                case 8:
                    u.totalDoctor();
                    break;

                default:
                    System.out.println("Invalid Choice. Try again!");
            }
            System.out.println();
        }
    }
}