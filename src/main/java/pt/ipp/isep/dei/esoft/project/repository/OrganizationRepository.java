package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Employee;
import pt.ipp.isep.dei.esoft.project.domain.Organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganizationRepository {

    List<Organization> organizations = new ArrayList<>();


    /**
     *
     * @param employee the employee registered/added
     * @return the organization where this employee has
     */
    public Optional<Organization> getOrganizationByEmployee(Employee employee) {

        Optional<Organization> returnOrganization = Optional.empty();

        for (Organization organization : organizations) {
            if (organization.employs(employee)) {
                returnOrganization = Optional.of(organization);
            }
        }

        return returnOrganization;
    }

    /**
     *
     * @param email the employee email
     * @return the organization where this employee email is registered/added
     */
    public Optional<Organization> getOrganizationByEmployeeEmail(String email) {

        Optional<Organization> returnOrganization = Optional.empty();

        for (Organization organization : organizations) {
            if (organization.employeeHasEmail(email)) {
                returnOrganization = Optional.of(organization);
            }
        }

        return returnOrganization;
    }

    /**
     *
     * @param organization the organization registered/added
     * @return list of organization added
     */
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

    /**
     *
     * @param organization the organization registered/added
     * @return if the organization is already contained on the organization list
     */
    private boolean validateOrganization(Organization organization) {
        return !organizations.contains(organization);
    }
}
