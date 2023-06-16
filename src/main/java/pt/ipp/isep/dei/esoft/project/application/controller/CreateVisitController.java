package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Client;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class CreateVisitController {

    private VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();
    OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();


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




    AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();
    ClientRepository clientRepository = Repositories.getInstance().getClientRepository();

    EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();

    public List<Announcement> getAnnouncements() {
        return announcementRepository.getAnnouncements();
    }

    public ClientRepository getClientRepository() { return clientRepository; }

    public Optional<VisitRequest> createVisitRequest(Announcement announcement, String username, String phonenumber, Date visitDate, int[][] timeSlot, String message, Employee agent) {
        VisitRequest visit = new VisitRequest(announcement, username, phonenumber, visitDate, timeSlot, message, agent);
        visitRepository.addRequests(visit);
        return Optional.of(visit);
    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    @Override
    public String toString() {
        return "CreateVisitController{}";
    }
}
