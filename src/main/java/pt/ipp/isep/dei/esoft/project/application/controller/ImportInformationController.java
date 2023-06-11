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

/**
 * The type Import information controller.
 */
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

    private DealRepository dealRepository;

    private Optional<Owner> owner;

    /**
     * Gets owner.
     *
     * @return the owner
     */
    public Optional<Owner> getOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(Optional<Owner> owner) {
        this.owner = owner;
    }

    /**
     * Gets property.
     *
     * @return the property
     */
    public Optional<Property> getProperty() {
        return property;
    }

    /**
     * Sets property.
     *
     * @param property the property
     */
    public void setProperty(Optional<Property> property) {
        this.property = property;
    }

    /**
     * Gets agency.
     *
     * @return the agency
     */
    public Optional<Agency> getAgency() {
        return agency;
    }

    /**
     * Sets agency.
     *
     * @param agency the agency
     */
    public void setAgency(Optional<Agency> agency) {
        this.agency = agency;
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public Optional<Request> getRequest() {
        return request;
    }

    /**
     * Sets request.
     *
     * @param request the request
     */
    public void setRequest(Optional<Request> request) {
        this.request = request;
    }

    /**
     * Gets announcement.
     *
     * @return the announcement
     */
    public Optional<Announcement> getAnnouncement() {
        return announcement;
    }

    /**
     * Sets announcement.
     *
     * @param announcement the announcement
     */
    public void setAnnouncement(Optional<Announcement> announcement) {
        this.announcement = announcement;
    }

    private Optional<Property> property;

    private Optional<Agency> agency;

    private Optional<Request> request;

    private Optional<Announcement> announcement;

    private Optional<Deal> deal;

    /**
     * Instantiates a new Import information controller.
     */
    public ImportInformationController() {
        getOwnerRepository();
        getEmployeeRepository();
        getAuthenticationRepository();
        getRequestRepository();
        getPropertyRepository();
        getPropertyTypeRepository();
        getTypeOfBusinessRepository();
        getAnnouncementRepository();
        getDealRepository();
    }

    /**
     * Instantiates a new Import information controller.
     *
     * @param propertyTypeRepository   the property type repository
     * @param typeBusinessRepository   the type business repository
     * @param employeeRepository       the employee repository
     * @param propertyRepository       the property repository
     * @param requestRepository        the request repository
     * @param announcementRepository   the announcement repository
     * @param agencyRepository         the agency repository
     * @param authenticationRepository the authentication repository
     * @param ownerRepository          the owner repository
     */
    public ImportInformationController(PropertyTypeRepository propertyTypeRepository, TypeBusinessRepository typeBusinessRepository, EmployeeRepository employeeRepository, PropertyRepository propertyRepository, RequestRepository requestRepository, AnnouncementRepository announcementRepository, AgencyRepository agencyRepository, AuthenticationRepository authenticationRepository, OwnerRepository ownerRepository, DealRepository dealRepository) {
        this.propertyTypeRepository = propertyTypeRepository;
        this.typeBusinessRepository = typeBusinessRepository;
        this.employeeRepository = employeeRepository;
        this.propertyRepository = propertyRepository;
        this.requestRepository = requestRepository;
        this.announcementRepository = announcementRepository;
        this.agencyRepository = agencyRepository;
        this.authenticationRepository = authenticationRepository;
        this.ownerRepository = ownerRepository;
        this.dealRepository = dealRepository;
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

    /**
     * Gets type of business repository.
     *
     * @return the type of business repository
     */
    public TypeBusinessRepository getTypeOfBusinessRepository() {
        if (typeBusinessRepository == null) {
            Repositories repositories = Repositories.getInstance();
            typeBusinessRepository = repositories.getTypeBusinessRepository();
        }
        return typeBusinessRepository;
    }

    /**
     * Gets employee repository.
     *
     * @return the employee repository
     */
    public EmployeeRepository getEmployeeRepository() {
        if (employeeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            employeeRepository = repositories.getEmployeeRepository();
        }
        return employeeRepository;
    }

    /**
     * Gets request repository.
     *
     * @return the request repository
     */
    public RequestRepository getRequestRepository() {
        if (requestRepository == null) {
            Repositories repositories = Repositories.getInstance();
            requestRepository = repositories.getRequestRepository();
        }
        return requestRepository;
    }

    /**
     * Gets property repository.
     *
     * @return the property repository
     */
    public PropertyRepository getPropertyRepository() {
        if (propertyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyRepository = repositories.getPropertyRepository();
        }
        return propertyRepository;
    }

    /**
     * Gets announcement repository.
     *
     * @return the announcement repository
     */
    public AnnouncementRepository getAnnouncementRepository () {
            if (announcementRepository == null) {
                Repositories repositories = Repositories.getInstance();
                announcementRepository = repositories.getAnnouncementRepository();
            }
            return announcementRepository;
        }

    /**
     * Gets agency repository.
     *
     * @return the agency repository
     */
    public AgencyRepository getAgencyRepository() {
        if (agencyRepository == null) {
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
    }

    public DealRepository getDealRepository(){
        if(dealRepository == null){
            Repositories repositories = Repositories.getInstance();
            dealRepository = repositories.getDealRepository();
        }
        return dealRepository;
    }

        public boolean readFile(String fileName){
            String csvFile = Files.pathCSV + fileName;
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
                        announcement = createAnnouncement(information);
                        deal = createDeal(information);
                    }
                }
                sc.close();
                operationSuccess = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not Found");
            }
            return operationSuccess;
        }

    /**
     * Create owner optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Owner> createOwner(String[] information) {
        if (getOwnerRepository() != null) {
            return getOwnerRepository().createOwner(information[1], Integer.parseInt(information[2]), information[3], information[4], information[5]);
        }
        return Optional.empty();
    }

    /**
     * Create agency optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Agency> createAgency (String[] information){
        Employee administrator = getAdministratorFromSession();
        Optional<Agency> newAgency = Optional.empty();
        if(getAgencyRepository() != null){
            newAgency = getAgencyRepository().createAgency(Integer.parseInt(information[25]), information[26], information[27], information[29], information[28], administrator);
        }
        return newAgency;
        }

    /**
     * Create property optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Property> createProperty(String[] information) {
        double squareFeetConverter = 0.0929;
            Owner owner = getOwnerByEmail(information[4]);
            Optional<Property> newProperty = Optional.empty();
            PropertyType propertyType = getPropertyTypeByName(information[6]);
            String[] informationLocation = information[8].split(",");
            switch (information[6]) {
                case "land":
                    if (getPropertyRepository() != null) {
                        Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3].trim()));
                        newProperty = getPropertyRepository().createLand(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, location, Double.parseDouble(information[9]), owner);
                    }
                    break;
                case "apartment":
                    if (getPropertyRepository() != null) {
                        Location location = new Location(informationLocation[0], informationLocation[4], informationLocation[5], Integer.parseInt(informationLocation[6].trim()));
                        boolean centralHeating = information[13].equalsIgnoreCase("Y");
                        boolean airConditioning = information[14].equalsIgnoreCase("Y");
                        newProperty = getPropertyRepository().createApartment(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, location, Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, owner);
                    }
                    break;
                case "house":
                    if (getPropertyRepository() != null) {
                        Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3].trim()));
                        boolean centralHeating = information[13].equalsIgnoreCase("Y");
                        boolean airConditioning = information[14].equalsIgnoreCase("Y");
                        boolean existenceOfAnBasement = information[15].equalsIgnoreCase("Y");
                        boolean inhabitableLoft = information[16].equalsIgnoreCase("Y");
                        newProperty = getPropertyRepository().createHouse(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, location, Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, information[17], owner);
                    }
                    break;
            }
            return newProperty;
        }

    /**
     * Create request optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Request> createRequest(String[] information) {
            Optional<Request> newRequest = Optional.empty();
            Owner owner = getOwnerByEmail(information[4]);
            String[] informationLocation = information[8].split(",");
            TypeBusiness typeBusiness = getTypeBusinessByName(information[24]);
            switch (information[6]) {
                case "land":
                case "house":
                    Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3].trim()));
                    Property property = getPropertyByLocation(location);
                    switch (information[24]) {
                        case "sale":
                            if (getRequestRepository() != null) {
                                newRequest = getRequestRepository().createSaleRequest(property, typeBusiness, Integer.parseInt(information[18]), owner);
                            }
                            break;
                        case "rent":
                            if (getRequestRepository() != null) {
                                newRequest = getRequestRepository().createRentRequest(property, typeBusiness, Integer.parseInt(information[18]), Integer.parseInt(information[21].trim()), owner);
                            }
                            break;
                    }
                    break;
                case "apartment":
                    location = new Location(informationLocation[0], informationLocation[4], informationLocation[5], Integer.parseInt(informationLocation[6].trim()));
                    property = getPropertyByLocation(location);
                    switch (information[24]) {
                        case "sale":
                            if (getRequestRepository() != null) {
                                newRequest = getRequestRepository().createSaleRequest(property, typeBusiness, Integer.parseInt(information[18].trim()), owner);
                            }
                            break;
                        case "rent":
                            if (getRequestRepository() != null) {
                                newRequest = getRequestRepository().createRentRequest(property, typeBusiness, Integer.parseInt(information[18].trim()), Integer.parseInt(information[21]), owner);
                            }
                            break;
                    }
                    break;
            }
            return newRequest;
        }

    /**
     * Create annoouncement optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Announcement> createAnnouncement(String[] information){
            Optional<Announcement> newAnnouncement = Optional.empty();
            String[] informationLocation = information[8].split(",");
            switch(information[6]){
                case "land":
                case "house":
                    Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3].trim()));
                    Property property = getPropertyByLocation(location);
                    Request request = getRequestByProperty(property);
                    Commission commission = new Commission("Percentage Commission", Double.parseDouble(information[20]));
                    if (getAnnouncementRepository() != null) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            Date date = sdf.parse(information[22]);
                            newAnnouncement = getAnnouncementRepository().createAnnouncementWithInputDate(request, commission, date);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Invalid Date Format");
                        }
                    }
                    break;
                case "apartment":
                    location = new Location(informationLocation[0], informationLocation[4], informationLocation[5], Integer.parseInt(informationLocation[6].trim()));
                    property = getPropertyByLocation(location);
                    request = getRequestByProperty(property);
                    commission = new Commission("Percentage Commission", Double.parseDouble(information[20]));
                    if (getAnnouncementRepository() != null) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            Date date = sdf.parse(information[22]);
                            newAnnouncement = getAnnouncementRepository().createAnnouncementWithInputDate(request, commission, date);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Invalid Date Format");
                        }
                    }
                    break;
            }
            return newAnnouncement;
        }
        public Optional<Deal> createDeal(String[] information){
            Optional<Deal> newDeal = Optional.empty();
            String[] informationLocation = information[8].split(",");
            Agency agency = getAgencyByID(Integer.parseInt(information[25]));
            switch(information[6]){
                case "land":
                case "house":
                    Location location = new Location(informationLocation[0], informationLocation[1], informationLocation[2], Integer.parseInt(informationLocation[3].trim()));
                    Property property = getPropertyByLocation(location);
                    Request request = getRequestByProperty(property);
                    Announcement announcement = getAnnouncementByRequest(request);
                    if (getDealRepository() != null) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            Date dateOfSale = sdf.parse(information[23]);
                            newDeal = getDealRepository().createDeal(announcement, dateOfSale, agency);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Invalid Date Format");
                        }
                    }
                    break;
                case "apartment":
                    location = new Location(informationLocation[0], informationLocation[4], informationLocation[5], Integer.parseInt(informationLocation[6].trim()));
                    property = getPropertyByLocation(location);
                    request = getRequestByProperty(property);
                    announcement = getAnnouncementByRequest(request);
                    if (getDealRepository() != null) {
                        try {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            Date dateOfSale = sdf.parse(information[23]);
                            newDeal = getDealRepository().createDeal(announcement, dateOfSale, agency);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException("Invalid Date Format");
                        }
                    }
                    break;
            }
            return newDeal;
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

        private Announcement getAnnouncementByRequest(Request request){
            return getAnnouncementRepository().getAnnouncementByRequest(request);
        }

        private Agency getAgencyByID(int agencyID){
            return getAgencyRepository().getAgencyByID(agencyID);
        }

    public Optional<Deal> getDeal() {
        return deal;
    }

    public void setDeal(Optional<Deal> deal) {
        this.deal = deal;
    }
}


