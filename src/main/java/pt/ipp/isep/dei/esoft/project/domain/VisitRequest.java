package pt.ipp.isep.dei.esoft.project.domain;

public class VisitRequest {

    private Announcement announcement;
    private String UserName;

    private String PhoneNumber;

    private String Date;

    private int [][] TimeSlot;

    public VisitRequest(Announcement announcement, String userName, String phonenumber, String date , int[][] timeSlot  , String message) {
    }

    public int[][] getTimeSlot() {
    return getTimeSlot();
    }

    @Override
    public String toString() {
        return "VisitRequest{" +
                "UserName='" + UserName + '\'' +
                ", PhoneNumber=" + PhoneNumber +
                ", Date=" + Date +
                ", TimeSlot=" + TimeSlot +
                '}';
    }
}
