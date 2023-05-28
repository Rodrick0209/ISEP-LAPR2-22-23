package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateVisitController;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CreateVisitUI implements Runnable {
    /*String name;
    private Object controller;
    private Scanner input;

    String timeSlot;

    @Override
    public void run() {

        CreateVisitController controller = new CreateVisitController();

        name = requestName();
        //requestPhoneNumber();
        //requestDate();
       requestTimeSlot();



    }


    private String requestTimeSlot() {
        System.out.println("Type the hour you want to visit this property (24h format)");
        int op = 0;
        int[][] timeslot1 = new int[100][2];
        int count = 0;
        while (op == 0) {
            String timeSlot = requestString("Time slot (example: 15-16");
            String[] timeSlotArr = timeSlot.split("-");
            timeslot1[count][0] = Integer.parseInt(timeSlotArr[0]);
            timeslot1[count][1] = Integer.parseInt(timeSlotArr[1]);
            count++;
            op = verfiInt("What to add another timeslot? \n0: yes\n1: no\n");
            input.nextLine();
        }
        //timeSlot = controller.sav
        return timeSlot;
    }

    private int verfiInt(String s) {
    return verfiInt("What to add another timeslot? \n0: yes\n1: no\n");
    }

    private String requestString(String print) {
        System.out.println(print);
        return input.nextLine();
    }
    /*
    private int requestPhoneNumber() {
        int input=0;
        boolean valid = false;
        int n=0;
    int phoneNumber =0;
    do {
    try {
                input = Utils.readIntegerFromConsole("Phone number: ");
                valid = true;
                phoneNumber = input;
                for (input / 10 >= 10) {
                    input / 10;
                    if (input >= 10) {
                        input / 10 = input;
                        n++;
                    }
                }catch(NullPointerException e){
                    System.out.println("Invalid price. Please enter a valid price.");
                }

            }
        } while (!valid) ;
            return phoneNumber;
        }
        */



    /*private int requestPhoneNumber(){
        int phoneNumber;
        int n=0;
        phoneNumber = Utils.readIntegerFromConsole(" Client's phone number");
        int number = phoneNumber;
        if(phoneNumber >= 10){
            number / 10 = phoneNumber;
            n++;

        }
    }


    private String requestName() {
        String input = null;
        boolean valid = false;
        do {
            try{
                input = Utils.readStringFromConsole("Name of the client: ");
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid name. Please enter a valid name.");
            }
        }while (!valid);
        return input;
    }
*/

    private String date, message;
    private int[][] timeSlot;
    private Announcement announcement;


    /**
     * The Input.
     */
    Scanner input = new Scanner(System.in);

    /**
     * The Controller.
     */
    CreateVisitController controller = new CreateVisitController();

    /**
     * Runs this operation.
     */
    @Override
    public void run() {
        requestData();
    }

    private Announcement requestAnnouncement() {
        int count = 1;

        List<Announcement> announcementList = controller.getAnnouncements();
        Collections.reverse(announcementList);

        for (Announcement announcement : announcementList) {
            System.out.println("Announcement " + count + ":\n " + announcement.toString());
            System.out.println();
            System.out.println("----------------------------------------------------------");
            count++;
        }

        int option = Utils.readIntegerFromConsole("Choose the announcement you want to register an offer for: ");
        announcement = controller.getAnnouncements().get(option - 1);

        return announcement;
    }

    private String requestDate() {
        System.out.println("Type the date you want to visit this property (dd/mm)");
        date = input.nextLine();
        return date;
    }

    private int[][] requestTimeSlot() {
        System.out.println("Type the hour you want to visit this property (24h format)");
        int op = 0;
        int[][] timeslot1 = new int[100][2];
        int count = 0;
        while (op == 0) {
            String timeSlot = requestString("Time slot (example: 15-16)");
            String[] timeSlotArr = timeSlot.split("-");
            timeslot1[count][0] = Integer.parseInt(timeSlotArr[0]);
            timeslot1[count][1] = Integer.parseInt(timeSlotArr[1]);
            count++;
            op = verfiInt("What to add another timeslot? \n0: yes\n1: no\n");
            input.nextLine();
        }
        timeSlot = controller.saveTimeSlot(timeslot1, count);
        return timeSlot;
    }

    private String requestString(String print) {
        System.out.println(print);
        return input.nextLine();
    }

    /**
     * Verfi int int.
     *
     * @param print the print
     * @return the int
     */
    public int verfiInt(String print) {
        int number;
        while (true) {
            System.out.print(print);
            try {
                number = Integer.parseInt(input.next());

                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Not valid.");
            }
        }
        return number;
    }

    private String requestMessage() {

        System.out.println("Do you want to leave a message for the agent?\n" +
                "1: yes\n2: no ");
        int option = input.nextInt();
        input.nextLine();
        if (option == 1) {
            System.out.println("Write your message:");
            message = input.nextLine();
            return message;

        } else if (option == 2) {
            return "you didn't leave a message";

        } else {
            return null;
        }
    }

    /*private Person requestID() {
        return controller.getPersonRepository().getPerson();
    }*/

    private void requestData() {

        //request the property he wants to visit
        announcement = requestAnnouncement();
        System.out.println();

        //request the date he wants to visit the property
        date = requestDate();
        System.out.println();

        //request the hour he wants to visit the property
        timeSlot = requestTimeSlot();
        System.out.println();

        if (timeSlot != null) {

            //request the message
            message = requestMessage();
            System.out.println();

            //request the user ID (name and phone number)
            /*person = requestID();
            System.out.println(person.toString());
            */


            createVisitRequest(announcement, date, timeSlot, message);
        } else {
            System.out.println("The hour you've written is not available ");
        }
    }

    private void createVisitRequest(Announcement announcement, String date, int[][] timeSlot, String message) {
        controller.createVisitRequest(announcement, date, timeSlot, message);


    }
}
