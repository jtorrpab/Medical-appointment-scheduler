package Controllers;

import Model.AvailableAppointment;
import Model.Doctor;
import Model.Patient;
import UI.UIDoctorMenu;
import UI.UIPatiente;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AuthUserController {
    public static Doctor doctorLogued;
    public static Patient patientLogued;
    public static void authUser(int userType){
        //userType = 1 Doctor
        //userType = 2 Pacientes

        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Alejandro Martinez", "alejandr@mail.com"));
        doctors.add(new Doctor("Caren Soza", "kare@mail.com"));
        doctors.add(new Doctor("Rocio Gomez", "Rocio@mail.com"));

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("Alejandro Martinez", "alejandr@mail.com"));
        patients.add(new Patient("Caren Soza", "kare@mail.com"));
        patients.add(new Patient("Rocio Gomez", "Rocio@mail.com"));

        boolean emailCorrect = false;

        do{
            System.out.println("Insert your correct email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if(userType == 1){
                for (Doctor d: doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect=true;
                        //Obtener los datos del usuario logueado
                        doctorLogued = d;
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }
            if(userType == 2){
                for(Patient p: patients) {
                    if(p.getEmail().equals(email)){
                        emailCorrect= true;
                        patientLogued = p;
                        UIPatiente.showPatientMenu();
                    }
                }
            }
        }while (!emailCorrect);

    }
}
