package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateVisitController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Schedule visit ui.
 */
public class ScheduleVisitUI implements Runnable {
    private Date date;
    private String message;
    private Announcement announcement;
    /**
     * The Name.
     */
    String name;
    /**
     * The Input.
     */
    Scanner input = new Scanner(System.in);

    private int[][] timeSlot;
    private Owner owner;

    private String username;
    private String phoneNumber;
    /**
     * The Controller.
     */
    CreateVisitController controller = new CreateVisitController();
    private Request request;

    private Commission commission;

    private String prompt;



    @Override
    public void run() {
        requestData();
        submitOrNot();
    }

    private void submitOrNot() {
            showsData();
            boolean answer = Utils.confirm("Confirm Data? (type yes or no)");
            if(answer){
                submitData();
            } else run();
    }

    private void showsData() {

    }

    private void submitData() {

        Optional<VisitRequest> visitRequest = controller.createVisitRequest (new Announcement( request , commission ,date), username,phoneNumber,date, timeSlot,message);
                if(visitRequest.isPresent()){
                    System.out.println("Request was created");
                }
                else{
                    System.out.println("Request not created");
                }
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

    /*private Date requestDate() {
        System.out.println("Type the date you want to visit this property (dd-MM-yyyy)");

        input = Utils.readLineFromConsole("Date");

            return date;
    }
*/
    private String requestString(String print) {
        System.out.println(print);
        return input.nextLine();
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

    private int verfiInt(String s) {

        int number;
        while (true) {
            System.out.print(s);
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

        message = requestMessage();
        System.out.println();

        username = requestUsername();

        phoneNumber = requestPhoneNumber();
        if (timeSlot != null) {

        /*request the user ID (name and phone number;
         owner = requestID();
        System.out.println(controller.getOwnerRepository());
*/



            createVisitRequest(announcement,username, phoneNumber , date, timeSlot, message);
        } else {
            System.out.println("The hour you've written is not available ");
        }
    }

    private Date requestDate() {
        System.out.println("Type the date you want to visit this property (yyyy/mm/dd)");
        //Date date2 =  new Date(2000, 1, 1);
        int year = Utils.readIntegerFromConsole("year");
        int month = Utils.readIntegerFromConsole("month");
        int day = Utils.readIntegerFromConsole("day");
        return new Date( year,month,day);
    }

    private String requestPhoneNumber() {
        String input = null;
        boolean valid = false;
        do {
            try{
                input = Utils.readStringFromConsole("Number of the client's phone: ");
                phoneNumber = input.toString();
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid phone number. Please enter a valid phone number.");
            }
        }while (!valid);
        return input;
    }


    private String requestUsername() {
        String input = null;
        boolean valid = false;
        do {
            try{
                input = Utils.readStringFromConsole("Name of the client: ");
                username = input.toString();
                valid = true;
            }catch (NullPointerException e){
                System.out.println("Invalid name. Please enter a valid name.");
            }
        }while (!valid);
        return input;
    }


    private Client requestID() {
        return controller.getClientRepository().getClient();
    }



    private void createVisitRequest(Announcement announcement, String username, String phonenumber, Date date, int[][] timeSlot, String message) {
        controller.createVisitRequest(announcement,username, phonenumber, date, timeSlot, message);


    }

    @Override
    public String toString() {
        return "CreateVisitUI{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                ", announcement=" + announcement +
                ", name='" + name + '\'' +
                ", input=" + input +
                ", timeSlot=" +timeSlot +
                ", owner=" + owner +
                ", controller=" + controller +
                '}';
    }
}
