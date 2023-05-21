package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ImportInformationController implements FileReader {

    private OrganizationRepository organizationRepository;

    private AuthenticationRepository authenticationRepository;

    private PropertyTypeRepository propertyTypeRepository;

    private OwnerRepository ownerRepository;

    public ImportInformationController(){
        getOrganizationRepository();
        getAuthenticationRepository();
        getPropertyTypeRepository();
        getOwnerRepository();
    }

    public ImportInformationController(OrganizationRepository organizationRepository, AuthenticationRepository authenticationRepository, PropertyTypeRepository propertyTypeRepository, OwnerRepository ownerRepository){
        this.organizationRepository = organizationRepository;
        this.authenticationRepository = authenticationRepository;
        this.propertyTypeRepository = propertyTypeRepository;
        this.ownerRepository = ownerRepository;
    }

    private OrganizationRepository getOrganizationRepository(){
        if(organizationRepository == null){
            Repositories repositories = Repositories.getInstance();
            organizationRepository = repositories.getOrganizationRepository();
        }
        return organizationRepository;
    }

    private AuthenticationRepository getAuthenticationRepository() {
        if (authenticationRepository == null) {
            Repositories repositories = Repositories.getInstance();
            authenticationRepository = repositories.getAuthenticationRepository();
        }
        return authenticationRepository;
    }

    private PropertyTypeRepository getPropertyTypeRepository(){
        if(propertyTypeRepository == null) {
            Repositories repositories = Repositories.getInstance();
            propertyTypeRepository = repositories.getPropertyTypeRepository();
        }
        return propertyTypeRepository;
    }

    private OwnerRepository getOwnerRepository(){
        if(ownerRepository == null) {
            Repositories repositories = Repositories.getInstance();
            ownerRepository = repositories.getOwnerRepository();
        }
        return ownerRepository;
    }

    public boolean readFile(String fileName) {
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
                insertInformationAboutAgency(information);
            }
        }
            sc.close();
            operationSuccess = true;
        }
        catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
        return operationSuccess;
    }

    public void insertInformationAboutProperty(String[] information) {
        double squareFeetConverter = 0.0929;
        String ownerEmailAddress = information[4];
        String propertyTypeName = information[6];
        double propertyArea = Double.parseDouble(information[7]) * squareFeetConverter;
        String propertyLocation = information[8];
        int propertyDistanceFromCityCenter = Integer.parseInt(information[9]);
        switch(propertyTypeName){
            case "land":
                createLand(propertyTypeName, propertyArea, propertyLocation, propertyDistanceFromCityCenter, ownerEmailAddress);
            case "apartment":
                int apartmentNumberOfBedrooms = Integer.parseInt(information[10]);
                int apartmentNumberOfBathrooms = Integer.parseInt(information[11]);
                int apartmentNumberParkingSpaces = Integer.parseInt(information[12]);
                String apartmentCentralHeatingChar = information[13];
                boolean apartmentCentralHeating = apartmentCentralHeatingChar.equalsIgnoreCase("Y");
                String apartmentAirConditioningChar = information[14];
                boolean apartmentAirConditioning = apartmentAirConditioningChar.equalsIgnoreCase("Y");
                createApartment(propertyTypeName, propertyArea, propertyLocation, propertyDistanceFromCityCenter, apartmentNumberOfBedrooms, apartmentNumberOfBathrooms, apartmentNumberParkingSpaces, apartmentCentralHeating, apartmentAirConditioning, ownerEmailAddress);
            case "house":
                int houseNumberOfBedrooms = Integer.parseInt(information[10]);
                int houseNumberOfBathrooms = Integer.parseInt(information[11]);
                int houseNumberParkingSpaces = Integer.parseInt(information[12]);
                String houseCentralHeatingChar = information[13];
                boolean houseCentralHeating = houseCentralHeatingChar.equalsIgnoreCase("Y");
                String houseAirConditioningChar = information[14];
                boolean houseAirConditioning = houseAirConditioningChar.equalsIgnoreCase("Y");
                String houseExistenceOfAnBasementChar = information[15];
                boolean houseExistenceOfAnBasement = houseExistenceOfAnBasementChar.equalsIgnoreCase("Y");
                String houseInhabitableLoftChar = information[16];
                boolean houseInhabitableLoft = houseInhabitableLoftChar.equalsIgnoreCase("Y");
                String houseSunExposure = information[17];
                createHouse(propertyTypeName, propertyArea, propertyLocation, propertyDistanceFromCityCenter, houseNumberOfBedrooms, houseNumberOfBathrooms, houseNumberParkingSpaces, houseCentralHeating, houseAirConditioning, houseExistenceOfAnBasement, houseInhabitableLoft, houseSunExposure, ownerEmailAddress);
        }
    }

    public Owner insertInformationAboutOwner(String[] information) {
        String ownerName = information[1];
        int ownerCCNumber = Integer.parseInt(information[2]);
        String ownerTaxNumber = information[3];
        String ownerEmailAddress = information[4];
        String ownerPhoneNumber = information[5];
        return new Owner(ownerName, ownerCCNumber, ownerTaxNumber, ownerEmailAddress, ownerPhoneNumber););
    }


    public Optional<Property> createLand(String typeName, double area, String location, int distanceFromCityCentre, String ownerEmailAddress){
        Owner owner = getOwnerRepository().getOwnerByEmail(ownerEmailAddress);
        return Optional.of(new Property(typeName, area, location, distanceFromCityCentre, owner));
    }

    public Optional<House> createHouse(String typeName, double area, String location, int distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms, int numberParkingSpaces, boolean centralHeating, boolean airConditioning, boolean existenceOfAnBasement, boolean inhabitableLoft, String sunExposure, String ownerEmailAddress){
        Owner owner = getOwnerRepository().getOwnerByEmail(ownerEmailAddress);
        return Optional.of(new House(typeName, area, location, distanceFromCityCentre, owner, numberOfBedrooms, numberOfBathrooms, numberParkingSpaces, centralHeating, airConditioning, existenceOfAnBasement, inhabitableLoft, sunExposure));
    }

    public Optional<Apartment> createApartment(String typeName, double area, String location, int distanceFromCityCentre, int numberOfBedrooms, int numberOfBathrooms, int numberParkingSpaces, boolean centralHeating, boolean airConditioning, String ownerEmailAddress){
        Owner owner = getOwnerRepository().getOwnerByEmail(ownerEmailAddress);
        return Optional.of(new Apartment(typeName, area, location, distanceFromCityCentre, owner, numberOfBedrooms, numberOfBathrooms, numberParkingSpaces, centralHeating, airConditioning));
    }

    public Optional<Announcement> insertInformationAboutAnnouncement(String[] information){
        String announcementDescription = information[]
    }
    public void insertInformationAboutAgency(String[] information){
        int agencyID = Integer.parseInt(information[22]);
        String agencyName = information[23];
        String agencyLocation = information[24];
        String agencyPhoneNumber = information[25];
        String agencyEmailAddress = information[26];
        createAgency(agencyID, agencyName, agencyLocation, agencyEmailAddress, agencyPhoneNumber);
    }

    public void insertInformationAboutAnnouncement(String[] information){

    }

    public Optional<Agency> createAgency(int id, String designation, String location, String emailAddress, String phoneNumber){

        Employee administrator = getAdministratorFromSession();
        Optional<Organization> organization = getOrganizationRepository().getOrganizationByEmployee(administrator);
        Optional<Agency> newAgency = Optional.empty();
        if(organization.isPresent()){
            newAgency = organization.get().createAgency(id, designation, location, emailAddress, phoneNumber, administrator);
        }
        return newAgency;
    }

    private Employee getAdministratorFromSession() {
        Email email = getAuthenticationRepository().getCurrentUserSession().getUserId();
        return new Employee(email.getEmail());
    }

    private Owner getOwnerByEmail(String ownerEmailAddress) {
        OwnerRepository ownerRepository = getOwnerRepository();
        return ownerRepository.getOwnerByEmail(ownerEmailAddress);
    }
    }
