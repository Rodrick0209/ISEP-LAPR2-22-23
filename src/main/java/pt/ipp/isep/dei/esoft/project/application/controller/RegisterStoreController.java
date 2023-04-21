package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Administrator;
import pt.ipp.isep.dei.esoft.project.domain.Company;
import pt.ipp.isep.dei.esoft.project.domain.Store;
import pt.ipp.isep.dei.esoft.project.repository.CompanyRepository;

import java.util.Optional;

public class RegisterStoreController {
    private CompanyRepository companyRepository;
    public RegisterStoreController(){
        getCompanyRepository();
    }

    public RegisterStoreController(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public Company<Store> registerStore(int id, String designation, String location, String emailAddress, String phoneNumber) {
        Administrator administrator = getAdministratorFromSession();
        Company company = getCompanyRepository().getCompanyByAdministrator(administrator);

        newStore =
    }

}
