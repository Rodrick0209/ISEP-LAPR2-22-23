# US 005 - To register a store

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Agency class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Agency instance = new Agency(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Agency class with a designation containing more than forty chars - AC1. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC1() {
		
		Agency instance = new Agency("15030", "Store Desgnation Company Made by System Administrator", "Alaska", "Anchorage School", "71 Bourbon Street, EAST Seattle", "abcd@isep.ipp.pt", "457-9384");
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RegisterAgencyController 

```java
public Organization createAgency(int id, String designation, String location, String emailAddress, String phoneNumber) {
        Employee administrator = getAdministratorFromSession();
        Organization organization = getOrganizationRepository().getOrganizationByAdministrator(administrator);

        newAgency = organization.createAgency(id, designation, location, emailAddress, phoneNumber, administrator);

        return newAgency;
        }
```


## Class Organization

```java
public Optional<Agency> createAgency (Integer id, String designation, String location, String emailAddress, String phoneNumber, Employee administrator){
        Agency agency = new Agency(id, designation, location, emailAddress, phoneNumber, administrator);

        addAgency(agency);

        return agency;
        }
```

# 6. Integration and Demo 

* A new option on the Administrator menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

n/a





