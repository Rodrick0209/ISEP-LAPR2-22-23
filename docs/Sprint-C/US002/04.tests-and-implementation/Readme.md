# US 006 - To create a Task 

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Announcement instance = new Announcement(null, null, null, null)
	}



*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class CreateTaskController 

```java
public class Announcement createAnnouncement(String propertyLocation, String description, double comission)

	Property location = getPropertyByLocation(propertyLocation);

	Employee agent = getEmployeeFromSession();
	Organization organization = getOrganizationRepository().getOrganizationByEmployee(agent);

	newAnnouncement = organization.createAnnouncement(agency, description, commission, agent);
    
	return newAnnouncement;
}
```


## Class Organization

```java
public Optional<Task> createAnnouncement(Property agency, String description, double commission, Employee agent) {
    
        Announcement announcement = new Announcement(agency, description, dommission, agent)

        addAnnouncement(announcement);
        
        return announcement;
    }
```

# 6. Integration and Demo 

* A new option on the Agent menu options was added.

* Some demo purposes some announcements are bootstrapped while system starts.


# 7. Observations

n/a





