# US 003 - Register a Employee

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Employee class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Employee instance = new Employee(null, null, null, null, null, null, null, null);
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RegisterEmployeeController 

```java
public Employee createEmployee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, int AgencyID, String roleName) {

	Agency agency = getAgencyByID(agencyID);
    Role role = getRoleByName(roleName)

	Employee administrator = getEmployeeFromSession();
	Organization organization = getOrganizationRepository().getOrganizationByEmployee(administrator);

	newEmployee = organization.createEmployee(name, email, ccNumber, taxNumber, 
			address, agency, role);
    
	return newEmployee;
}
```


## Class Organization

```java
public Optional<Employee> createEmployee(String name, String email, int ccNumber, int taxNumber, String address, String phoneNumber, Agency agency, Role role)
    
        Employee employee = new Employee(name, email, ccNumber, taxNumber, address, phoneNumber, agent, role);

        addEmployee(employee);
        
        return employee;
    }
```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.

* Some demo purposes some employees are bootstrapped while system starts.


# 7. Observations

n/a





