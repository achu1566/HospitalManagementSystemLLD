import User.doctor;
import User.patient;

public class Treatment {
    public long treatmentId;
    String patientId , doctorId , assignmentDate;
    public Treatment(String patientId , String doctorId , String assignmentDate, long treatmentId){
        this.treatmentId = treatmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.assignmentDate = assignmentDate;
    }
    public long getId(){
        return treatmentId;
    }
    public String getDoctorId(){
        return doctorId;
    }
    public String getPatientId(){
        return patientId;
    }
    public String getAssignmentDate(){
        return assignmentDate;
    }
}
