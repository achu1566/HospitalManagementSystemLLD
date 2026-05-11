package Hospital;

import User.*;
import java.util.*;

abstract public class Auth{
    public Auth(){
        
    }
    public static boolean loginPatient(HospitalService u, String username, String password){
        Map<String, patient> P = u.P;
        for(Map.Entry<String, patient> p : P.entrySet()){
            if(p.getValue().getUserName().trim().equalsIgnoreCase(username.trim()) && p.getValue().getPassword().trim().equalsIgnoreCase(password.trim())){
                return true;
            }
        }
        return false;
    }
    public static boolean loginDoctor(HospitalService u, String username, String password){
        Map<String, doctor> D = u.D;
        for(Map.Entry<String, doctor> p : D.entrySet()){
            if(p.getValue().getUserName().trim().equalsIgnoreCase(username.trim()) && p.getValue().getPassword().trim().equalsIgnoreCase(password.trim())){
                return true;
            }
        }
        return false;
    }
    public static boolean loginAdmin(String username, String password){
        Admin admin = new Admin();
        if(admin.getUserName().trim().equalsIgnoreCase(username.trim()) && admin.getPassword().trim().equalsIgnoreCase(password.trim())){
            return true;
        }
        return false;
    }
}