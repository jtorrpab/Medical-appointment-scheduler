package UI;

import Controllers.AuthUserController;
import Model.AvailableAppointment;
import Model.Doctor;
import Model.Patient;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatiente {

    public static void showPatientMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome " + AuthUserController.patientLogued.getName());
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointment");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    ShowPatientMyAppointment();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response!=0);
    }

    private static void showBookAppointmentMenu(){
        int response =0;
        do {
            System.out.println("\n");
            System.out.println(":: Book Appointment");
            System.out.println(":: Select date");
            //Primera opción - Numeración de la lista de fechas
            //Indice de la fecha seleccionada
            Map<Integer,Map<Integer, Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointment.size(); i++) {
                ArrayList<AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointment.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointment = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k+". " + availableAppointments.get(j).getDate() + " at "+availableAppointments.get(j).getTime());
                    doctorAppointment.put(Integer.valueOf(j),UIDoctorMenu.doctorsAvailableAppointment.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointment);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseSelected = Integer.valueOf(sc.nextLine());

            Map<Integer, Doctor> doctorAvailableSelected= doctors.get(responseSelected);
            Integer indexDate = 0;

            Doctor doctorSelected = new Doctor("","");

            //Entryset es la forma para recorrer un map
            for (Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()){
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                    ". Date: "+ doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: "+ doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment \n1. Yes \n2. Change data");
            response = Integer.valueOf(sc.nextLine());
            if (response == 1){
                AuthUserController.patientLogued.addAppointmentDoctors(doctorSelected
                        ,doctorSelected.getAvailableAppointments().get(indexDate).getDate(null)
                        ,doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                System.out.println("\nSuccessfully scheduled appointment");
                showPatientMenu();
            }

        }while (response!=0);
    }

    private static void ShowPatientMyAppointment(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if(AuthUserController.patientLogued.getAppointmentDoctors().size() == 0){
                System.out.println("Don't have appointments yet");
                break;
            }
            for (int i = 0; i < AuthUserController.patientLogued.getAppointmentDoctors().size(); i++) {
                int j = i +1;
                System.out.println(j + ". "+
                        "Date: " +AuthUserController.patientLogued.getAppointmentDoctors().get(i).getDate() +
                        "\nDate: " +AuthUserController.patientLogued.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: " +AuthUserController.patientLogued.getAppointmentDoctors().get(i).getDoctor().getName());
            }

            System.out.println("0. Logout");
        }while(response!=0);
    }
}
