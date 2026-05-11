package Hospital;
import User.doctor;
import User.patient;
import java.util.*;

public class HospitalService {
    private static HospitalService instance = new HospitalService();
    public Map<String , patient> P = new HashMap<>();
    public Map<String , doctor> D = new HashMap<>();
    List<Treatment> Treat = new ArrayList<>();

    public HospitalService(){

    }

    public static HospitalService getInstance(){
        return instance;
    }

    public boolean createPatient(String name , String username, String password , String mobileNumber){
        if(username.trim().isEmpty() || password.trim().isEmpty()){
            System.out.println("Username and Password cannot be empty.");
            return false;
        }

        for(Map.Entry<String, patient> p : P.entrySet()){
            if(p.getValue().getUserName().trim().equalsIgnoreCase(username.trim())){
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            }
        }

        patient p = new patient(name, username, password, mobileNumber);
        String id  = p.getPatientId();
        P.put(id, p);
        return true;
    }
    public boolean createDoctor(String name , String username, String password){
        if(username.trim().isEmpty() || password.trim().isEmpty()){
            System.out.println("Username and Password cannot be empty.");
            return false;
        }

        for(Map.Entry<String, doctor> d : D.entrySet()){
            if(d.getValue().getUserName().trim().equalsIgnoreCase(username.trim())){
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            }
        }

        doctor d = new doctor(name, username, password);
        String id = d.getDoctorId();
        D.put(id, d);
        return true;
    }
    public void totalPatient(){
        System.out.println("Patients List");
        System.out.println("Patient ID\tName\tMobile Number");
        for(Map.Entry<String,patient> p : P.entrySet()){
            System.out.println(p.getKey() + "\t\t" + p.getValue().getName() + "\t\t" + p.getValue().getMobileNo());
        }
    }
    public void totalDoctor(){
        System.out.println("Doctors List");
        System.out.println("Doctor ID\tName");
        for(Map.Entry<String,doctor> d : D.entrySet()){
            System.out.println(d.getKey() + "\t" + d.getValue().getName());
        }
    }

    public void assignDoctorToPatient(String patientId , String doctorId , String assignmentDate){
        if(!P.containsKey(patientId)){
            System.out.println("Patient with ID " + patientId + " does not exist.");
            return;
        }
        if(!D.containsKey(doctorId)){
            System.out.println("Doctor with ID " + doctorId + " does not exist.");
            return;
        }
        Treatment t = new Treatment(patientId, doctorId, assignmentDate);
        Treat.add(t);
        doctor d = D.get(doctorId);
        d.addTreatment(t);
        patient p = P.get(patientId);
        p.addTreatment(t);
        System.out.println("Doctor " + d.getName() + " assigned to Patient " + p.getName() + " on " + assignmentDate);
    }

    public void doctorList(String doctorId){
        if(!D.containsKey(doctorId)){
            System.out.println("Doctor with ID " + doctorId + " does not exist.");
            return;
        }

        doctor d = D.get(doctorId);
        ArrayList<Treatment> list = d.getTreatment();

        System.out.println("Doctor " + d.getName() + " Treated List: " );
        System.out.println("Treatment Id\tAssignment Date\tPatient Name" );
        for(Treatment t : list){
            patient p = P.get(t.getPatientId());
            System.out.println(t.getId() + "\t\t" + t.getAssignmentDate() + "\t\t" + p.getName());
        }
    }

    public void patientList(String patientId){
        if(!P.containsKey(patientId)){
            System.out.println("Patient with ID " + patientId + " does not exist.");
            return;
        }
        
        patient p = P.get(patientId);
        ArrayList<Treatment> l = p.getTreatments();
        
        System.out.println("Patient " + p.getName() + " Treatment List: " );
        System.out.println("Treatment Id\tAssignment Date\tDoctor Name" );
        for(Treatment t : l){
            doctor d = D.get(t.getDoctorId());
            System.out.println(t.getId() + "\t\t" + t.getAssignmentDate() + "\t\t" + d.getName());
        }
    }

    public void treatmentDetails(){
        System.out.println("Treatment Information");
        System.out.println("Treatment Id\tAssignment Date\tDoctor Name\tPatient Name" );
        for(Treatment t : Treat){
            doctor d = D.get(t.getDoctorId());
            patient p = P.get(t.getPatientId());
            System.out.println(t.getId() + "\t\t" + t.getAssignmentDate() + "\t\t" + d.getName() + "\t\t" + p.getName());
        }
    }

}
