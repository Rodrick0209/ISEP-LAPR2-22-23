# US 006 - To create a Task 

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Store instance = new Store(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Task class with a reference containing less than five chars - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReferenceMeetsAC2() {
		
		Store instance = new Store("15030", "Store Designation", "Alaska", "Anchorage School", "Anchorage", 294, 56729, "457-9384");
	}


*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RegisterStoreController 

```java
public Store registerStore(int id, String designation, String location, String emailAddress,
                            String telephoneNumber, Organization organization)	        
        {
    
	Organization organization = getOrganizationRepository().getOrganizationByDescription(description);

	newStore = organization.register(id, designation, location, emailAddress, telephoneNumber, organization)
    
	return newStore;
}
```


## Class Organization

```java
public Optional<Task> createTask(String reference, String description, String informalDescription,
                                     String technicalDescription, Integer duration, Double cost,
                                     TaskCategory taskCategory, Employee employee) {
    
        Task task = new Task(reference, description, informalDescription, technicalDescription, duration, cost,
                taskCategory, employee);

        addTask(task);
        
        return task;
    }
```

# 6. Integration and Demo 

* A new option on the Employee menu options was added.

* Some demo purposes some tasks are bootstrapped while system starts.


# 7. Observations

Platform and Organization classes are getting too many responsibilities due to IE pattern and, therefore, they are becoming huge and harder to maintain. 

Is there any way to avoid this to happen?





