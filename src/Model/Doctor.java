package Model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    private String speciality;
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public Doctor(String name, String email) {
        super(name, email);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new AvailableAppointment(date,time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }
    //Metodo abstracto
    @Override
    public void ShowUserData() {
        System.out.println("El comportamiento que se desee");
    }
}
