package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    private Optional<Owner> owner;

    public Optional<Owner> getOwner() {
        return owner;
    }

    public void setOwner(Optional<Owner> owner) {
        this.owner = owner;
    }

    public Optional<Property> getProperty() {
        return property;
    }

    public void setProperty(Optional<Property> property) {
        this.property = property;
    }

    public Optional<Agency> getAgency() {
        return agency;
    }

    public void setAgency(Optional<Agency> agency) {
        this.agency = agency;
    }

    public Optional<Request> getRequest() {
        return request;
    }

    public void setRequest(Optional<Request> request) {
        this.request = request;
    }

    public Optional<Announcement> getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Optional<Announcement> announcement) {
        this.announcement = announcement;
    }

    private Optional<Property> property;

    private Optional<Agency> agency;

    private Optional<Request> request;

    private Optional<Announcement> announcement;

    public ImportInformationController() {
        getOwnerRepository();
        getEmployeeRepository();
        getOwnerRepository();
        getAuthenticationRepository();
        getRequestRepository();
        getPropertyRepository();
        getPropertyTypeRepository();
        getTypeOfBusinessRepository();
    }

    public ImportInformationController(PropertyTypeRepository propertyTypeRepository, TypeBusinessRepository typeBusinessRepository, EmployeeRepository employeeRepository, PropertyRepository propertyRepository, RequestRepository requestRepository, AnnouncementRepository announcementRepository, AgencyRepository agencyRepository, AuthenticationRepository authenticationRepository, OwnerRepository ownerRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
        this.typeBusinessRepository = typeBusinessRepository;
        this.employeeRepository = employeeRepository;
        this.propertyRepository = propertyRepository;
        this.requestRepository = requestRepository;
        this.announcementRepository = announcementRepository;
        this.agencyRepository = agencyRepository;
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
            typeBusinessRepository = repositories.getTypeBusinessRepository();
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

        public AgencyRepository getAgencyRepository() {
            if (agencyRepository == null) {
                Repositories repositories = Repositories.getInstance();
                agencyRepository = repositories.getAgencyRepository();
            }
            return agencyRepository;
        }

        public boolean readFile(String fileName){
            String csvFile = Files.path + fileName;
            boolean operationSuccess = false;
            try {
                Scanner sc = new Scanner(new File(csvFile));
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
                        owner = createOwner(information);
                        property = createProperty(information);
                        agency = createAgency(information);
                        request = createRequest(information);
                        announcement = createAnnoouncement(information);
                    }
                }
                sc.close();
                operationSuccess = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            }
            return operationSuccess;
        }

        public Optional<Owner> createOwner (String[] information){
            Optional<Owner> newOwner = Optional.empty();
            if(getOwnerRepository() != null) {
                newOwner = getOwnerRepository().createOwner(information[1], Integer.parseInt(information[2]), information[3], information[4], information[5]);
            }
            return newOwner;
        }

    public Optional<Agency> createAgency (String[] information){
        Employee administrator = getAdministratorFromSession();
        Optional<Agency> newAgency = Optional.empty();
        if(getAgencyRepository() != null){
            newAgency = getAgencyRepository().createAgency(Integer.parseInt(information[25]), information[26], information[27], information[29], information[28], administrator);
        }
        return newAgency;
        }

        public Optional<Property> createProperty(String[] information) {
            Owner owner = getOwnerByEmail(information[4]);
            Optional<Property> newProperty = Optional.empty();
            PropertyType propertyType = getPropertyTypeByName(information[6]);
            String[] informationLocation = information[8].split(", ");
            Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3]));
            switch (information[6]) {
                case "land":
                    if (getPropertyRepository() != null) {
                        newProperty = getPropertyRepository().createLand(propertyType, Double.parseDouble(information[7]), location, Double.parseDouble(information[9]), owner);
                    }
                    break;
                case "apartment":
                    if (getPropertyRepository() != null) {
                        boolean centralHeating = information[13].equalsIgnoreCase("Y");
                        boolean airConditioning = information[14].equalsIgnoreCase("Y");
                        newProperty = getPropertyRepository().createApartment(propertyType, Double.parseDouble(information[7]), location, Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, owner);
                    }
                    break;
                case "house":
                    if (getPropertyRepository() != null) {
                        boolean centralHeating = information[13].equalsIgnoreCase("Y");
                        boolean airConditioning = information[14].equalsIgnoreCase("Y");
                        boolean existenceOfAnBasement = information[15].equalsIgnoreCase("Y");
                        boolean inhabitableLoft = information[16].equalsIgnoreCase("Y");
                        newProperty = getPropertyRepository().createHouse(propertyType, Double.parseDouble(information[7]), location, Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, information[17], owner);
                    }
                    break;
            }
            return newProperty;
        }

        public Optional<Request> createRequest(String[] information) {
            Optional<Request> newRequest = Optional.empty();
            Owner owner = getOwnerByEmail(information[4]);
            String[] informationLocation = information[8].split(", ");
            Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3]));
            Property property = getPropertyByLocation(location);
            TypeBusiness typeBusiness = getTypeBusinessByName(information[24]);
            switch (information[24]) {
                case "sale":
;                    if (getRequestRepository() != null) {
                        newRequest = getRequestRepository().createSaleRequest(property, typeBusiness, Integer.parseInt(information[18]), owner);
                    }
                    break;
                case "rent":
                    if (getRequestRepository() != null) {
                        newRequest = getRequestRepository().createRentRequest(property, typeBusiness, Integer.parseInt(information[18]), Integer.parseInt(information[21]), owner);
                    }
                    break;
            }
            return newRequest;
        }

        public Optional<Announcement> createAnnoouncement(String[] information){
            Optional<Announcement> newAnnouncement = Optional.empty();
            String[] informationLocation = information[8].split(", ");
            Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3]));
            Property property = getPropertyByLocation(location);
            Request request = getRequestByProperty(property);
            Commission commission = new Commission("Percentage Commission", Double.parseDouble(information[20]));
            if (getAnnouncementRepository() != null) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = sdf.parse(information[22]);
                    newAnnouncement = getAnnouncementRepository().createAnnouncement(request, commission, date);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Invalid Date Format");
                }
            }
            return newAnnouncement;
        }


        private Employee getAdministratorFromSession() {
            Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
            return new Employee(email.getEmail());
        }

        private Owner getOwnerByEmail(String ownerEmailAddress){
            return getOwnerRepository().getOwnerByEmail(ownerEmailAddress);
        }

        private Property getPropertyByLocation(Location location){
            return getPropertyRepository().getPropertyByLocation(location);
    }

        private Request getRequestByProperty(Property property){
            return getRequestRepository().getRequestByProperty(property);
        }

        private PropertyType getPropertyTypeByName(String propertyTypeName){
            return getPropertyTypeRepository().getPropertyTypeByName(propertyTypeName);
        }

        private TypeBusiness getTypeBusinessByName(String typeBusinessName){
            return getTypeOfBusinessRepository().getTypeBusinessbyName(typeBusinessName);
        }

}


