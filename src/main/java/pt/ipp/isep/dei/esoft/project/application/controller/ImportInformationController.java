package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;
import pt.ipp.isep.dei.esoft.project.domain.Property;
import pt.ipp.isep.dei.esoft.project.repository.AuthenticationRepository;
import pt.ipp.isep.dei.esoft.project.repository.OrganizationRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.isep.lei.esoft.auth.domain.model.Email;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ImportInformationController {

    private OrganizationRepository organizationRepository;

    private AuthenticationRepository authenticationRepository;

    public ImportInformationController(){
        getOrganizationRepository();
        getAuthenticationRepository();
    }

    public ImportInformationController(OrganizationRepository organizationRepository, AuthenticationRepository authenticationRepository){
        this.organizationRepository = organizationRepository;
        this.authenticationRepository = authenticationRepository;
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

    public void read(String fileName) {
        try (Scanner sc = new Scanner(new File(fileName));) {
            if (!fileName.contains(".csv")) {
                throw new FileNotFoundException("File is not on the correct format");
            }
            String headLine = sc.nextLine();
            if (headLine == null) {
                throw new FileNotFoundException("File is Empty");
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                List<String> information = List.of(line.split(";"));
                //insertInformationAboutOwner(information);
                insertInformationAboutAgency(information);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }

    public void insertInformationAboutProperty(List<String> information) {
        double squareFeetConverter = 0.0929;
        int systemID = Integer.parseInt(information.get(0));
        String ownerName = information.get(1);
        int ownerCCNumber = Integer.parseInt(information.get(2));
        String ownerTaxNumber = information.get(3);
        String ownerEmailAddress = information.get(4);
        String ownerPhoneNumber = information.get(5);
        String propertyType = information.get(6);
        double propertyArea = Double.parseDouble(information.get(7)) * squareFeetConverter;
        String propertyLocation = information.get(8);
        int propertyDistanceFromCityCenter = Integer.parseInt(information.get(9));
        switch(propertyType){
            case "land":
                Optional<Property> property =
            case "apartment":
            case "house":
                int propertyNumberOfBedrooms = Integer.parseInt(information.get(10));
                int propertyNumberOfBathrooms = Integer.parseInt(information.get(11));
                int propertyNumberParkingSpaces = Integer.parseInt(information.get(12));
        }

    }

    public Optional<Agency> insertInformationAboutAgency(List<String> information){
        int agencyID = Integer.parseInt(information.get(22));
        String agencyName = information.get(23);
        String agencyLocation = information.get(24);
        String agencyPhoneNumber = information.get(25);
        String agencyEmailAddress = information.get(26);
        return createAgency(agencyID, agencyName, agencyLocation, agencyEmailAddress, agencyPhoneNumber);
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
    }
