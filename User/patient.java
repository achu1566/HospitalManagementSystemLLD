package User;
import Hospital.Treatment;
import java.util.ArrayList;

public class patient {
    public static int idcounter = 0;

    private String patientId, mobileno, name, password;
    private ArrayList<Treatment> treatments;

    public patient(String name , String password, String mobileno){
        this.patientId = String.valueOf(++idcounter);
        this.name = name;
        this.password = password;
        this.mobileno = mobileno;
        this.treatments = new ArrayList<>();
    }
    public String getPatientId(){
        return patientId;
    }
    public void addTreatment(Treatment t){
        treatments.add(t);
    }
    public ArrayList<Treatment> getTreatments(){
        return treatments;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getMobileNo(){
        return mobileno;
    }
    public String toString(){
        return "Patient ID: " + patientId + "\nName: " + name + "\nMobile No: " + mobileno + "\n";
    }
}
