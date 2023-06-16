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
import java.util.List;
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
    public AnnouncementRepository getAnnouncementRepository() {
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

    public DealRepository getDealRepository() {
        if (dealRepository == null) {
            Repositories repositories = Repositories.getInstance();
            dealRepository = repositories.getDealRepository();
        }
        return dealRepository;
    }

    public boolean receiveFile(String fileName) {
        boolean operationSuccess = false;
        try {
            if (!fileName.contains(".csv")) {
                throw new FileNotFoundException("File is not on the correct format");
            }
            File file = new File(Files.pathCSV + fileName);
            operationSuccess = readFile(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return operationSuccess;
    }

    public boolean readFile(File file) {
        boolean operationSuccess = false;
        try {
            Scanner sc = new Scanner(file);
            String headLine = sc.nextLine();
            if (headLine == null) {
                throw new FileNotFoundException("File is Empty");
            } else {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] information = line.split(";");
                    createOwner(information);
                    createProperty(information);
                    createAgency(information);
                    createRequest(information);
                    createAnnouncement(information);
                    createDeal(information);
                }
            }
            sc.close();
            operationSuccess = true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
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
    public Optional<Agency> createAgency(String[] information) {
        Employee administrator = getAdministratorFromSession();
        Optional<Agency> newAgency = Optional.empty();
        if (getAgencyRepository() != null) {
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
        switch (information[6]) {
            case "land":
                if (getPropertyRepository() != null) {
                    newProperty = getPropertyRepository().createLand(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, information[8], Double.parseDouble(information[9]), owner);
                }
                break;
            case "apartment":
                if (getPropertyRepository() != null) {
                    boolean centralHeating = information[13].equalsIgnoreCase("Y");
                    boolean airConditioning = information[14].equalsIgnoreCase("Y");
                    newProperty = getPropertyRepository().createApartment(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, information[8], Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, owner);
                }
                break;
            case "house":
                if (getPropertyRepository() != null) {
                    boolean centralHeating = information[13].equalsIgnoreCase("Y");
                    boolean airConditioning = information[14].equalsIgnoreCase("Y");
                    boolean existenceOfAnBasement = information[15].equalsIgnoreCase("Y");
                    boolean inhabitableLoft = information[16].equalsIgnoreCase("Y");
                    newProperty = getPropertyRepository().createHouse(propertyType, Double.parseDouble(information[7]) * squareFeetConverter, information[8], Double.parseDouble(information[9]), Integer.parseInt(information[10]), Integer.parseInt(information[11]), Integer.parseInt(information[12]), centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, information[17], owner);
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
        TypeBusiness typeBusiness = getTypeBusinessByName(information[24]);
        Property property = getPropertyByLocation(information[8]);
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
        return newRequest;
    }

    /**
     * Create announcement optional.
     *
     * @param information the information
     * @return the optional
     */
    public Optional<Announcement> createAnnouncement(String[] information) {
        Optional<Announcement> newAnnouncement = Optional.empty();
        Property property = getPropertyByLocation(information[8]);
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
        return newAnnouncement;
    }

    public Optional<Deal> createDeal(String[] information) {
        Optional<Deal> newDeal = Optional.empty();
        Agency agency = getAgencyByID(Integer.parseInt(information[25]));
        Property property = getPropertyByLocation(information[8]);
        Request request = getRequestByProperty(property);
        Announcement announcement = getAnnouncementByRequest(request);
        if (getDealRepository() != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date dateOfSale = sdf.parse(information[23]);
                newDeal = getDealRepository().createDeal(announcement, dateOfSale, agency);
                removeProperty(property);
                removeRequest(request);
                removeAnnouncement(announcement);
                addPropertyToAgency(agency, property);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Invalid Date Format");
            }
        }
        return newDeal;
    }


    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    private Owner getOwnerByEmail(String ownerEmailAddress) {
        return getOwnerRepository().getOwnerByEmail(ownerEmailAddress);
    }

    private Property getPropertyByLocation(String location) {
        return getPropertyRepository().getPropertyByLocation(location);
    }

    private Request getRequestByProperty(Property property) {
        return getRequestRepository().getRequestByProperty(property);
    }

    private PropertyType getPropertyTypeByName(String propertyTypeName) {
        return getPropertyTypeRepository().getPropertyTypeByName(propertyTypeName);
    }

    private TypeBusiness getTypeBusinessByName(String typeBusinessName) {
        return getTypeOfBusinessRepository().getTypeBusinessbyName(typeBusinessName);
    }

    private Announcement getAnnouncementByRequest(Request request) {
        return getAnnouncementRepository().getAnnouncementByRequest(request);
    }

    private Agency getAgencyByID(int agencyID) {
        return getAgencyRepository().getAgencyByID(agencyID);
    }

    private void addPropertyToAgency(Agency agency, Property property) {
        agency.addProperty(property);
    }

    private boolean removeRequest(Request request) {
        return getRequestRepository().removeRequest(request);
    }

    private boolean removeAnnouncement(Announcement announcement) {
        return getAnnouncementRepository().removeAnnouncement(announcement);
    }

    private boolean removeProperty(Property property) {
        return getPropertyRepository().removeProperty(property);
    }


}


