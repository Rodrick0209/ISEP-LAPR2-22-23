# US 020 - To accept or reject an appointment request.

# 4. Tests 

**Test 1:** Check that it is not possible to create an instance of the Task class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Task instance = new Task(null, null, null, null, null, null, null);
	}
	

**Test 2:** Check that it is not possible to create an instance of the Response of Appointment Request class when this appointment request is accepted, but the reason is inserted  - AC2. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureReasonMeetsAC3() { 
        Location location = new Location("Power Street", "Porto", "Portugal", 45673)
		Property property = new Property(236, location, 2346)
        Client client = new Client("client@this.app")
        Agent agent = new Agent("Agent Name", "agent@this.app")
        AppointmentRequest appointmentRequest = new AppointmentRequest(property, "02/09/2004", agent)
        boolean acceptAppointment = false;

        if(!acceptAppointment){
		ResponseOfAppointmentRequest instance = new ResponseOfAppointmentRequest(appointmentRequest, acceptAppointment, "reason", client);}

    

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class RespondAppointmentController 

```java
public ResponseOfAppointmentRequest createAcceptResponse(appointmentRequestProperty, acceptAppointment, client) {

	AppointmentRequest appointmentRequest = getAppointmentRequestByProperty(appointmentRequestProperty);

	Client client = getClientFromSession();
        ResponseOfAppointmentRequestRepository responseOfAppointmentRequestRepository = getResponseOfAppointmentRequestRepository()

	newResponse = responseOfAppointmentRequestRepository.createAcceptResponse(appointmentRequest, acceptAppointment, client);
    
	return newResponse;
}

public ResponseOfAppointmentRequest createRejectResponse(appointmentRequestProperty, acceptAppointment, reason, client) {
        AppointmentRequest appointmentRequest = getAppointmentRequestByProperty(appointmentRequestProperty);

        Client client = getClientFromSession();
        ResponseOfAppointmentRequestRepository responseOfAppointmentRequestRepository = getResponseOfAppointmentRequestRepository()

        newResponse = responseOfAppointmentRequestRepository.createAcceptResponse(appointmentRequest, acceptAppointment, reason, client);

        return newResponse;
        }
```


## Class ResponseOfAppointmentRequestRepository

```java
public Optional<ResponseOfAppointmentRequest> createAcceptResponse(appointmentRequest, acceptAppointment, client) {
    
        ResponseOfAppointmentRequest responseOfAppointmentRequest = new ResponseOfAppointmentRequest(appointmentRequest, acceptAppointment, client);

        addResponse(responseOfAppointmentRequest);
        
        return responseOfAppointmentRequest;
    }

public Optional<ResponseOfAppointmentRequest> createRejectResponse() {
        ResponseOfAppointmentRequest responseOfAppointmentRequest = new ResponseOfAppointmentRequest(appointmentRequest, acceptAppointment, reason, client);

        addResponse(responseOfAppointmentRequest);

        return responseOfAppointmentRequest;
        }
```

# 6. Integration and Demo 

* A new option on the Client menu options was added.

* Some appointment requests are bootstrapped while system starts.


# 7. Observations

When the request was accept, the announcement of this property, will be deleted in the application.





