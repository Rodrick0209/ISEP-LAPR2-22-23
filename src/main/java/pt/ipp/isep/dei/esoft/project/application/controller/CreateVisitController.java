package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.AnnouncementRepository;
import pt.ipp.isep.dei.esoft.project.repository.OwnerRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.repository.VisitRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Create visit controller.
 */
public class CreateVisitController {

    private VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();
    /**
     * The Owner repository.
     */
    OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();

    /**
     * Save time slot int [ ] [ ].
     *
     * @param timereal the timereal
     * @param count    the count
     * @return the int [ ] [ ]
     */
    public int[][] saveTimeSlot(int[][] timereal, int count) {


        List<VisitRequest> list = visitRepository.getListVisitRepository();


        List<Integer> hoursTaked = new ArrayList<>();


        List<Integer> userHoursTaked = new ArrayList<>();

        for (VisitRequest v : list) {

            for (int[] slot : v.getTimeSlot()
            ) {
                int firstHour = slot[0];
                int finalHour = slot[1];

                if (!hoursTaked.contains(firstHour)) {
                    hoursTaked.add(firstHour);
                }

                if (!hoursTaked.contains(finalHour)) {
                    hoursTaked.add(finalHour);
                }

                int hour = firstHour;
                while (hour != finalHour) {
                    hour++;
                    if (!hoursTaked.contains(hour)) {
                        hoursTaked.add(hour);
                    }

                }
            }
        }


        int[][] timeslot = new int[count][2];
        boolean impossible2Add = false;
        int countValidSlots = 0;


        for (int i = 0; i < count; i++) {
            int hour = timereal[i][0];

            if (!userHoursTaked.contains(hour)) {
                userHoursTaked.add(hour);
            }

            while (hour != timereal[i][1]) {
                hour++;
                if (!userHoursTaked.contains(hour)) {
                    userHoursTaked.add(hour);
                }
            }

            for (Integer h : userHoursTaked
            ) {
                if (hoursTaked.contains(h)) {
                    impossible2Add = true;
                    //break;
                }
            }

            if (!impossible2Add) {
                for (int hourTakedByThisUser : userHoursTaked
                ) {
                    if (!hoursTaked.contains(hourTakedByThisUser)) {
                        hoursTaked.add(hourTakedByThisUser);
                    }
                }
                timeslot[countValidSlots][0] = timereal[i][0];
                timeslot[countValidSlots][1] = timereal[i][1];
                countValidSlots++;
            }

            userHoursTaked = new ArrayList<>();
            impossible2Add = false;
        }
        if (countValidSlots > 0) {
            System.out.println("Timeslots:");
            for (int i = 0; i < countValidSlots; i++) {
                System.out.println(timeslot[i][0] + " - " + timeslot[i][1]);
            }
            return timeslot;
        } else {
            return null;
        }
    }


    /**
     * The Announcement repository.
     */
    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

    /**
     * Gets announcements.
     *
     * @return the announcements
     */
    public List<Announcement> getAnnouncements() {
        return announcementRepository.getAnnouncements();
    }

    /**
     * Create visit request.
     *
     * @param announcement the announcement
     * @param username     the username
     * @param phonenumber  the phonenumber
     * @param date         the date
     * @param timeSlot     the time slot
     * @param message      the message
     */
    public void createVisitRequest(Announcement announcement, String username, String phonenumber, String date, int[][] timeSlot, String message) {
        VisitRequest visit = new VisitRequest(announcement, username, phonenumber, date, timeSlot, message);
        visitRepository.addRequests(visit);
    }

    /**
     * Gets owner repository.
     *
     * @return the owner repository
     */
    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

}
