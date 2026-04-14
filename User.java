import User.doctor;
import User.patient;
import java.util.*;

public class User {
    Map<String , patient> P = new HashMap<>();
    Map<String , doctor> D = new HashMap<>();
    Map<String , ArrayList<Treatment>> T = new HashMap<>();
    Map<String , ArrayList<Treatment>> PTreat = new HashMap<>();
    List<Treatment> Treat = new ArrayList<>();

    public void createPatient(String id , String name , String password , String mobileNumber){
        patient p = new patient(name, password, mobileNumber);
        P.put(id, p);
        PTreat.put(id , new ArrayList());
    }
    public void createDoctor(String id , String name , String password){
        doctor d = new doctor(name, password);
        D.put(id, d);
        T.put(id , new ArrayList<>());
    }
    public void totalPatient(){
        System.out.println("Patients List");
        System.out.println("Patient ID\tName\tMobile Number");
        for(Map.Entry<String,patient> p : P.entrySet()){
            System.out.println(p.getKey() + "\t" + p.getValue().getName() + "\t" + p.getValue().getMobileNo());
        }
    }
    public void totalDoctor(){
        System.out.println("Doctors List");
        System.out.println("Doctor ID\tName");
        for(Map.Entry<String,doctor> d : D.entrySet()){
            System.out.println(d.getKey() + "\t" + d.getValue().getName());
        }
    }

    public void assignDoctorToPatient(long treatmentId, String patientId , String doctorId , String assignmentDate){
        Treatment t = new Treatment(patientId, doctorId, assignmentDate, treatmentId);
        Treat.add(t);

        ArrayList<Treatment> list = T.get(doctorId);
        list.add(t);
        T.put(doctorId, list);

        ArrayList<Treatment> list2 = PTreat.get(patientId);
        list2.add(t);
        PTreat.put(patientId, list2);
    }

    public void doctorList(String doctorId){
        ArrayList<Treatment> list = T.get(doctorId);
        doctor d = D.get(doctorId);
        System.out.println("Doctor " + d.getName() + " Treated: " );
        System.out.println("Treatment Id\tAssignment Date\tPatient Name" );
        for(Treatment t : list){
            patient p = P.get(t.getPatientId());
            System.out.println(t.getId() + "\t" + t.getAssignmentDate() + "\t" + p.getName());
        }
    }

    public void patientList(String patientId){
        ArrayList<Treatment> l = PTreat.get(patientId);
        patient p = P.get(patientId);
        System.out.println("Treatment Id\tAssignment Date\tDoctor Name" );
        System.out.println("Patient " + p.getName() + " : " );
        for(Treatment t : l){
            doctor d = D.get(t.getDoctorId());
            System.out.println(t.getId() + "\t" + t.getAssignmentDate() + "\t" + d.getName());
        }
    }

    public void treatmentDetails(){
        System.out.println("Treatment Information");
        System.out.println("Treatment Id\tAssignment Date\tDoctor Name\tPatient Name" );
        for(Treatment t : Treat){
            doctor d = D.get(t.getDoctorId());
            patient p = P.get(t.getPatientId());
            System.out.println(t.getId() + "\t" + t.getAssignmentDate() + "\t" + d.getName() + "\t" + p.getName());
        }
    }

}
