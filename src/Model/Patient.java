package Model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    private String birthday;
    private double weight;
    private double height;
    private String blood;
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.Scchdule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }
    public void setAppointmentDoctors(ArrayList<AppointmentDoctor> appointmentDoctors) {
        this.appointmentDoctors = appointmentDoctors ;
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }
    public Patient(String name, String email) {
        super(name, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    //Metodo abstracto
    @Override
    public void ShowUserData() {
        System.out.println("El comportamiento que se desee");
    }
}
