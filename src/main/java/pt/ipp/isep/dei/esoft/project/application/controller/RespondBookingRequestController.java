package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;

public class RespondBookingRequestController implements FileWriter {
    private VisitRepository visitRepository;
    private AuthenticationRepository authenticationRepository;
    private ClientRepository clientRepository;
    private AppointmentRequestRepository appointmentRequestRepository;

    public RespondBookingRequestController(){

    }

    public RespondBookingRequestController(VisitRepository visitRepository, AuthenticationRepository authenticationRepository, ClientRepository clientRepository, AppointmentRequestRepository appointmentRequestRepository) {
        this.visitRepository = visitRepository;
        this.authenticationRepository = authenticationRepository;
        this.clientRepository = clientRepository;
        this.appointmentRequestRepository = appointmentRequestRepository;
    }

    private VisitRepository getVisitRepository(){
        if(visitRepository == null){
            Repositories repositories = Repositories.getInstance();
            visitRepository = repositories.getVisitRepository();
        }
        return visitRepository;
    }

    private AuthenticationRepository getAuthenticationRepository(){
        if(authenticationRepository == null){
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private ClientRepository getClientRepository(){
        if(clientRepository == null){
            Repositories repositories = Repositories.getInstance();
            clientRepository = repositories.getClientRepository();
        }
        return clientRepository;
    }

    private AppointmentRequestRepository getAppointmentRequestRepository(){
        if(appointmentRequestRepository == null){
            Repositories repositories = Repositories.getInstance();
            appointmentRequestRepository = repositories.getAppointmentRequestRepository();
        }
        return appointmentRequestRepository;
    }

    public Optional<AppointmentRequest> createAppointmentRequest(Announcement visitRequestAnnouncement, String message, String clientEmail){
        Optional<AppointmentRequest> newAppointmentRequest = Optional.empty();
        VisitRequest visitRequest = getVisitRepository().getVisitRequestByAnnouncement(visitRequestAnnouncement);
        Client client = getClientRepository().getClientByEmail(clientEmail);
        Employee agent = getAgentFromSession();

        if(getAppointmentRequestRepository() != null){
            newAppointmentRequest = getAppointmentRequestRepository().createAppointmentRequest(visitRequest, message, client, agent);
        }
        return newAppointmentRequest;
    }

    private Employee getAgentFromSession(){
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }


    @Override
    public void writeFile(VisitRequest visitRequest, String pwd) {
        AppointmentRequest appointmentRequest = getAppointmentRequestRepository().getAppointmentRequestByVisitRequest(visitRequest);
        String fileName = Files.pathTXT + "emailClient.txt";
        try {
            PrintWriter pw = new PrintWriter(fileName);
            pw.println("Your visit request has already been seen and answered by the agent!");
            pw.println();
            pw.println("Information about the visit: ");
            pw.println(appointmentRequest.toString());
            pw.println();
            pw.println("Message from agent: " + pwd);
            pw.println();
            pw.println("Real State USA Ltd.");
            pw.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
