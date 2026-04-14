package User;

import Hospital.Treatment;
import java.util.ArrayList;

public class doctor {
    public static int idcounter = 0;
    private String name, password, doctorId;
    private ArrayList<Treatment> treatments;

    public doctor(String name , String password){
        this.name = name;
        this.password = password;
        this.doctorId = String.valueOf(++idcounter);
        this.treatments = new ArrayList<>();
    }

    public String getDoctorId(){
        return doctorId;
    }
    public void addTreatment(Treatment t){
        treatments.add(t);
    }
    public ArrayList<Treatment> getTreatment(){
        return treatments;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String toString(){
        return "Doctor ID: " + doctorId + "\nName: " + name + "\n";
    }
}
