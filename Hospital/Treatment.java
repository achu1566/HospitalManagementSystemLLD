package Hospital;

public class Treatment {
    private static long idcounter = 0;
    public long treatmentId;
    String patientId , doctorId , assignmentDate;
    public Treatment(String patientId , String doctorId , String assignmentDate){
        this.treatmentId = ++idcounter;
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
