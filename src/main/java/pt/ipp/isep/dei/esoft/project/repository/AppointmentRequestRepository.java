package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentRequestRepository implements Serializable {
    private final List<AppointmentRequest> appointmentRequests = new ArrayList<>();

    public Optional<AppointmentRequest> createAppointmentRequest(VisitRequest visitRequest, String message, Client client, Employee agent){
        Optional<AppointmentRequest> optionalValue = Optional.empty();

        AppointmentRequest appointmentRequest = new AppointmentRequest(visitRequest, message, client, agent);

        if(addAppointmentRequest(appointmentRequest)){
            optionalValue = Optional.of(appointmentRequest);
        }
        return optionalValue;
    }

    public boolean addAppointmentRequest(AppointmentRequest appointmentRequest){
        boolean operationSuccess = false;
        if(validateAppointmentRequest(appointmentRequest)){
            operationSuccess = appointmentRequests.add(appointmentRequest);
        }
        return operationSuccess;
    }

    public AppointmentRequest getAppointmentRequestByVisitRequest(VisitRequest visitRequest){
        AppointmentRequest appointmentRequest = null;
        for(AppointmentRequest ar : appointmentRequests){
            if(ar.getVisitRequest().equals(visitRequest)){
                appointmentRequest = ar;
            }
        }
        return appointmentRequest;
    }

    private boolean validateAppointmentRequest(AppointmentRequest appointmentRequest){return !appointmentRequests.contains(appointmentRequest);}
}
