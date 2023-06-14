# US 002 - To publish an announcement

# 4. Tests 
**Test 1:**  Check if an SMS notification is sent to the owner .

    @Test
    boolean isSMSSent = NotificationService.sendSMS(owner.getPhoneNumber(), "Your property listing is now available.");
    assertTrue(isSMSSent);
    
**Test 2:** Check if the SMS notification content matches the expected content.
   
     @Test           
    String actualContent = NotificationService.getNotificationContent();
    public class    assertEquals(expectedContent, actualContent); MessageController testSMSNotificationContent() {
}
**Test 3:** Check if the SMS notification content contains the agent information.
                       
        @Test
        String actualContent = NotificationService.getNotificationContent();
        assertTrue(actualContent.contains(expectedContent))

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)
**Test 1**: An SMS notification should be sent to the owner when the listing of the
        property becomes available.
## Class MessageController
``` java



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

**Test 2:** The SMS notification includes the property identification and the date it became available.  

## Class MessageController
```java
public class MessageController() {
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
```

**Test 3:** The SMS notification includes the name and phone number of the responsible Agent.   
## Class MessageController
``` java
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
```

# 6. Integration and Demo

- A new option, "Publish Announcement," has been added to the Agent menu options. This option allows agents to publish sale announcements received through various channels, such as phone calls.

- As part of the system demonstration, a set of sample announcements are bootstrapped when the system starts. These announcements serve the purpose of showcasing the system's functionality and can be used for testing or demonstration purposes. The bootstrapped announcements may include properties with different attributes and serve as initial examples for agents to work with.


# 7. Observations

n/a





