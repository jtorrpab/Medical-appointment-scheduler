package UI;

import Controllers.AuthUserController;
import Model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {
    public static ArrayList<Doctor> doctorsAvailableAppointment = new ArrayList<>();
    public static void showDoctorMenu(){
        int response = 0;

        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + AuthUserController.doctorLogued.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Schedule appointement");
            System.out.println("0. Logout");
            System.out.print("> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    ShowAddAvailableAppointmentMenu();
                    break;
                case 2:
                    ShowMyScheduleappointement();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }

    private static void ShowAddAvailableAppointmentMenu(){
        int response = 0;
        do {
            System.out.println("\n");
            System.out.println(":: Add Avaliable Appointment");
            System.out.println(":: Select a Month");

            for (int i = 0; i < 3; i++) {
                int j = i +1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");
            System.out.print("> ");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if(response > 0 && response< 4){
                //1,2,3
                int  monthSelected = response;
                System.out.println(monthSelected+ " . "+ UIMenu.MONTHS[monthSelected-1]);

                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                //La palabra reservada continue, lo que hace es que salta la sigueinte linea, pero no se sale del ciclo y vuelve a iniciar
                if(responseDate == 2) continue;

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: "+date+" [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Date");
                    responseTime = Integer.valueOf(sc.nextLine());
                    if (responseTime == 1) {
                        System.out.println("\nAdded the agenda to schedule");
                    }

                }while(responseTime == 2);

                AuthUserController.doctorLogued.addAvailableAppointment(date,time);
                checkDoctorAvailableAppointment(AuthUserController.doctorLogued);

            }else if(response == 0){
                UIDoctorMenu.showDoctorMenu();
            }
        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointment(Doctor doctor){
        if(doctor.getAvailableAppointments().size()>0 && !doctorsAvailableAppointment.contains(doctor)){
            doctorsAvailableAppointment.add(doctor);
        }
    }

    private static void ShowMyScheduleappointement(){

    }
}
