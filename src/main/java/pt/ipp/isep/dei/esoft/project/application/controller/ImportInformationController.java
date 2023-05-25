package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;
import java.util.Scanner;

public class ImportInformationController implements FileReader {
    private PropertyTypeRepository propertyTypeRepository;

    private TypeBusinessRepository typeBusinessRepository;

    private EmployeeRepository employeeRepository;

    private PropertyRepository propertyRepository;

    private RequestRepository requestRepository;
    private AnnouncementRepository announcementRepository;

    private AgencyRepository agencyRepository;
    private AuthenticationRepository authenticationRepository;
    private OwnerRepository ownerRepository;

    public ImportInformationController() {
        getOwnerRepository();
        getAuthenticationRepository();
        getPropertyTypeRepository();
        getRequestRepository();
        getPropertyRepository();
        getTypeOfBusinessRepository();
    }

    public ImportInformationController(PropertyTypeRepository propertyTypeRepository, TypeBusinessRepository typeBusinessRepository, EmployeeRepository employeeRepository, PropertyRepository propertyRepository, RequestRepsitory requestRepository, AnnouncementRepository announcementRepository, AuthenticationRepository authenticationRepository, OwnerRepository ownerRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
        this.typeBusinessRepository = typeBusinessRepository;
        this.employeeRepository = employeeRepository;
        this.propertyRepository = propertyRepository;
        this.requestRepository = requestRepository;
        this.announcementRepository = announcementRepository;
        this.authenticationRepository = authenticationRepository;
        this.ownerRepository = ownerRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private PropertyTypeRepository getPropertyTypeRepository() {
        if (propertyTypeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyTypeRepository = repositories.getPropertyTypeRepository();
        }
        return propertyTypeRepository;
    }

    private OwnerRepository getOwnerRepository() {
        if (ownerRepository == null) {
            Repositories repositories = Repositories.getInstance();
            ownerRepository = repositories.getOwnerRepository();
        }
        return ownerRepository;
    }

    public TypeBusinessRepository getTypeOfBusinessRepository() {
        if (typeBusinessRepository == null) {
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBussinessRepository();
        }
        return typeBusinessRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    public RequestRepository getRequestRepository() {
        if (requestRepository == null) {
            Repositories repositories = Repositories.getInstance();
            requestRepository = repositories.getRequestRepository();
        }
        return requestRepository;
    }

    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

        public AnnouncementRepository getAnnouncementRepository () {
            if (announcementRepository == null) {
                Repositories repositories = Repositories.getInstance();
                announcementRepository = repositories.getAnnouncementRepository();
            }
            return announcementRepository;
        }

        public boolean readFile(String fileName){
            boolean operationSuccess = false;
            try {
                Scanner sc = new Scanner(new File(fileName));
                if (!fileName.contains(".csv")) {
                    throw new FileNotFoundException("File is not on the correct format");
                }
                String headLine = sc.nextLine();
                if (headLine == null) {
                    throw new FileNotFoundException("File is Empty");
                } else {
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        String[] information = line.split(";");
                        int systemID = Integer.parseInt(information[0]);
                        insertInformationAboutOwner(information);
                        insertInformationAboutProperty(information);
                        insertInformationAboutAnnouncement(information);
                        insertInformationAboutAgency(information);
                    }
                }
                sc.close();
                operationSuccess = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            }
            return operationSuccess;
        }


        public Optional<Apartment> insertInformationAboutApartment (String[]information){
            Owner owner = insertInformationAboutOwner(information);
            int apartmentNumberOfBedrooms = Integer.parseInt(information[10]);
            int apartmentNumberOfBathrooms = Integer.parseInt(information[11]);
            int apartmentNumberParkingSpaces = Integer.parseInt(information[12]);
            String apartmentCentralHeatingChar = information[13];
            boolean apartmentCentralHeating = apartmentCentralHeatingChar.equalsIgnoreCase("Y");
            String apartmentAirConditioningChar = information[14];
            boolean apartmentAirConditioning = apartmentAirConditioningChar.equalsIgnoreCase("Y");
            createApartment(propertyTypeName, propertyArea, propertyLocation, propertyDistanceFromCityCenter, apartmentNumberOfBedrooms, apartmentNumberOfBathrooms, apartmentNumberParkingSpaces, apartmentCentralHeating, apartmentAirConditioning, ownerEmailAddress);
        }

        public Optional<House> insertInformationAboutHouse (String[]information){

        }
        public Optional<Owner> createOwner (String[] information){
            Optional<Owner> newOwner = Optional.empty();
            if(getOwnerRepository() != null) {
                newOwner = getOwnerRepository().createOwner(information[1], Integer.parseInt(information[2]), information[3], information[4], information[5]);
            }
            return newOwner;
        }

        public Optional<Property> createProperty(String[] information) {
            Optional<Property> newProperty = Optional.empty();
            Owner owner = getOwnerRepository().getOwnerByEmail(information[4]);
            switch(information[6]){
                case "land":
                    Optional<Land> createLand =
        }



        private Employee getAdministratorFromSession() {
            Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
            return new Employee(email.getEmail());
        }

        private Owner getOwnerByEmail(String ownerEmailAddress){
            OwnerRepository ownerRepository = getOwnerRepository();
            return ownerRepository.getOwnerByEmail(ownerEmailAddress);
        }
    }
}
