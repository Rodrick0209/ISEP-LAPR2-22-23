package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.CreateRequestController;
import pt.ipp.isep.dei.esoft.project.application.controller.CreateVisitController;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Utils;

public class CreateVisitUI implements Runnable {
    String name;

    @Override
    public void run() {

        CreateVisitController controller = new CreateVisitController();

        name = requestName();
        //requestPhoneNumber();
        //requestDate();
        //requestTimeLSlot();



    }

    /*private int requestPhoneNumber() {
        int input=0;
        boolean valid = false;
        int n=0;
        do {
            try{
                input = Utils.readIntegerFromConsole("Phone number: ");
                valid = true;
                if(input >=10 ){
                    input / 10 = input;
                    n++;
                }
            }catch (NullPointerException e){
                System.out.println("Invalid price. Please enter a valid price.");
            }

        }while (!valid);
        return input;
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
    */

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


}
