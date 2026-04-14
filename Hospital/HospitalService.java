package Hospital;
import User.doctor;
import User.patient;
import java.util.*;

public class HospitalService {
    Map<String , patient> P = new HashMap<>();
    Map<String , doctor> D = new HashMap<>();
    List<Treatment> Treat = new ArrayList<>();

    public void createPatient(String name , String password , String mobileNumber){
        patient p = new patient(name, password, mobileNumber);
        String id  = p.getPatientId();
        P.put(id, p);
    }
    public void createDoctor(String name , String password){
        doctor d = new doctor(name, password);
        String id = d.getDoctorId();
        D.put(id, d);
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
        Treatment t = new Treatment(patientId, doctorId, assignmentDate);
        Treat.add(t);
        doctor d = D.get(doctorId);
        d.addTreatment(t);
        patient p = P.get(patientId);
        p.addTreatment(t);
        System.out.println("Doctor " + d.getName() + " assigned to Patient " + p.getName() + " on " + assignmentDate);
    }

    public void doctorList(String doctorId){
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
