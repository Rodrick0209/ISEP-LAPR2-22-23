# US 005 - To register a store

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Store class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Store instance = new Store(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Store class with a designation containing more than forty chars - AC1. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC1() {
		
		Store instance = new Store("15030", "Store Desgnation Company Made by System Administrator", "Alaska", "Anchorage School", "71 Bourbon Street, EAST Seattle", "abcd@isep.ipp.pt", "457-9384");
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RegisterStoreController 

```java
public Company registerStore(int id, String designation, String location, String emailAddress, String phoneNumber) {
        Administrator administrator = getAdministratorFromSession();
        Company company = getCompanyRepository().getCompanyByAdministrator(administrator);

        newStore = company.registerStore(id, designation, location, emailAddress, phoneNumber, administrator);

        return newStore;
        }
```


## Class Company

```java
public Optional<Store> registerStore (Integer id, String designation, String location, String emailAddress, String phoneNumber, Administrator administrator){
        Store store = new Store(id, designation, location, emailAddress, phoneNumber, administrator);

        addStore(store);

        return store;
        }
```

# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





