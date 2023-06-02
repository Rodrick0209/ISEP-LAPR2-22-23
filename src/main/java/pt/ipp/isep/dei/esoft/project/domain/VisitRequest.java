package pt.ipp.isep.dei.esoft.project.domain;

public class VisitRequest {

    private Announcement Announcement;
    private String userName;

    private String phoneNumber;

    private String date;

    private int [][] timeSlot;
    private String message;

    public VisitRequest(Announcement announcement, String userName, String phoneNumber, String date, int[][] timeSlot, String message) {
        this.Announcement = announcement;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.timeSlot = timeSlot;
        this.message = message;
    }


    public int[][] getTimeSlot() {
    return getTimeSlot();
    }


    @Override
    public String toString() {
        return "VisitRequest:" +
                "\nAnnouncement" + Announcement +
                "\nUserName:" + userName  +
                "\nPhoneNumber: " + phoneNumber +
                "\nDate: " + date +
                "\nTimeSlot: " + timeSlot ;
    }
}
