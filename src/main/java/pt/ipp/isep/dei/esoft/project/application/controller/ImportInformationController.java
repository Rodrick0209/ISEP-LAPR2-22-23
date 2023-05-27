/*package pt.ipp.isep.dei.esoft.project.application.controller;

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

    private Optional<Owner> owner;
    private String propertyType;

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

        public void readFile(String fileName){
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
                        owner = createOwner(information);
                        property = createProperty(information);
                        agency = createAgency(information);
                        request = createRequest(information);
                        announcement = createAnnoouncement(information);
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            }
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
            switch (information[6]) {
                case "land":
                    if (getPropertyRepository() != null) {
                        newProperty = Optional.of(getPropertyRepository().createLand());


                    }
                case "apartment":
                    if (getPropertyRepository() != null) {
                        newProperty = Optional.of(getPropertyRepository().createApartment());
                    }
                case "house":
                    if (getPropertyRepository() != null) {
                        newProperty = Optional.of(getPropertyRepository().createHouse());
                    }

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + information[6]);
            }
            return newProperty;
        }

        public Optional<Request> createRequest(String[] information) {
            Optional<Request> newRequest = Optional.empty();
            Owner owner = getOwnerByEmail(information[4]);
            Property property = getPropertyByLocation(information[8]);
            if (getRequestRepository() != null) {
                newRequest = Optional.of(getRequestRepository().createRequest());
            }
            return newRequest;
        }

        public Optional<Announcement> createAnnoouncement(String[] information){
            Optional<Announcement> newAnnouncement = Optional.empty();
            Request request = getRequestByPropertyLocation(information[4]);
            if (getAnnouncementRepository() != null){
                newAnnouncement = Optional.of(getAnnouncementRepository().createAnnouncement());
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

        private Property getPropertyByLocation(String propertyLocation){
            return getPropertyRepository().getPropertyByLocation(propertyLocation);
    }

        private Request getRequestByPropertyLocation(String propertyLocation){
            return getRequestRepository().getRequestByPropertyLocation(propertyLocation);
        }
}
*/

