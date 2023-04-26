package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Administrator;
import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository {

    List<Organization> organizations = new ArrayList<>();

    /**
     *
     * @param administrator administrator of organization
     * @return organization
     */
    public Optional<Organization> getOrganizationByAdministrator(Administrator administrator) {

        Optional<Organization> returnOrganization = Optional.empty();

        for (Organization organization : organizations) {
            if (organization.administrates(administrator)) {
                returnOrganization = Optional.of(organization);
            }
        }

        return returnOrganization;
    }

    public Optional<Organization> getOrganizationByAdministratorEmail(String email) {

        Optional<Organization> returnOrganization = Optional.empty();

        for (Organization organization : organizations) {
            if (organization.administratorHasEmail(email)) {
                returnOrganization = Optional.of(organization);
            }
        }

        return returnOrganization;
    }

    public Optional<Organization> add(Organization organization) {

        Optional<Organization> newOrganization = Optional.empty();
        boolean operationSuccess = false;

        if (validateOrganization(organization)) {
            newOrganization = Optional.of(organization.clone());
            operationSuccess = organizations.add(newOrganization.get());
        }

        if (!operationSuccess) {
            newOrganization = Optional.empty();
        }

        return newOrganization;

    }

    private boolean validateOrganization(Organization organization) {
        return !organizations.contains(organization);
    }
}
