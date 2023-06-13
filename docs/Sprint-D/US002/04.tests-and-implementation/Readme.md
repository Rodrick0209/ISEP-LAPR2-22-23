#US 002 - To publish an announcement

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


## Class MessageController
``` java
@Test
Test 1: An SMS notification is sent to the owner when the listing of the property becomes available.

public class MessageController testSMSNotificationContent() {
// Create a new property

Property property = new Property("123 ABC Street");

    // Create a new owner
    Owner owner = new Owner("John Doe", "johndoe@example.com", "555-1234");

    // Create a mock announcement
    Announcement announcement = new Announcement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Set the owner for the announcement
    announcement.setOwner(owner);

    // Call the method to create the announcement
    Announcement createdAnnouncement = organization.createAnnouncement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Check if the SMS notification is sent to the owner
    boolean isSMSSent = NotificationService.sendSMS(owner.getPhoneNumber(), "Your property listing is now available. Property ID: " + property.getId() + ". Contact Agent1 at " + announcement.getAgent().getPhoneNumber());

    assertTrue(isSMSSent);
}
```
## Class

Test 2: The SMS notification includes the property identification and the date it became available.
@Test
public class message() {
// Create a new  property
Property property = new Property("123 ABC Street");

    // Create a new owner
    Owner owner = new Owner("John Doe", "johndoe@example.com", "555-1234");

    // Create a new announcement
    Announcement announcement = new Announcement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Set the owner for the announcement
    announcement.setOwner(owner);

    // Call the method to create the announcement
    Announcement createdAnnouncement = organization.createAnnouncement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Get the expected SMS notification content
    String expectedContent = "Your property listing is now available. Property ID: " + property.getId() + ". Date: " + createdAnnouncement.getDate();

    // Check if the SMS notification content matches the expected content
    String actualContent = NotificationService.getNotificationContent();
    assertEquals(expectedContent, actualContent);
}
````

## Class

Test 3: The SMS notification includes the name and phone number of the responsible Agent.
@Test
public void testSMSNotificationContainsAgentInfo() {
// Create a new property
Property property = new Property("123 ABC Street");

    // Create a new owner
    Owner owner = new Owner("John Doe", "johndoe@example.com", "555-1234");

    // Create a mock announcement
    Announcement announcement = new Announcement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Set the owner for the announcement
    announcement.setOwner(owner);

    // Call the method to create the announcement
    Announcement createdAnnouncement = organization.createAnnouncement(property, "Spacious house for sale", 10.0, new Employee("Agent1"));

    // Get the expected SMS notification content
    String expectedContent = "Your property listing is now available. Property ID: " + property.getId() + ". Contact Agent1 at " + announcement.getAgent().getPhoneNumber();

    // Check if the SMS notification content contains the agent information
    String actualContent = NotificationService.getNotificationContent();
    assertTrue(actualContent.contains(expectedContent));
}






# 6. Integration and Demo 

* A new option on the Agent menu options was added.

* Some demo purposes some announcements are bootstrapped while system starts.


# 7. Observations

n/a





