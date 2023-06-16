# US 016 - To respond to the User that scheduled the visit when viewing a booking request.

## 1. Requirements Engineering


### 1.1. User Story Description

As an agent, when viewing a booking request, I want to respond to the user that scheduled the visit

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Each task is characterized by having a unique reference per organization, a designation, an informal and a technical description, an estimated duration and cost as well as the its classifying task category. 


>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 



**From the client clarifications:**

> **Question:** Which is the unit of measurement used to estimate duration?
>  
> **Answer:** Duration is estimated in days.


> **Question:** Monetary data is expressed in any particular currency?
>  
> **Answer:** Monetary data (e.g. estimated cost of a task) is indicated in POTs (virtual currency internal to the platform).


### 1.3. Acceptance Criteria


* **AC1** The response is sent by email.
* **AC2** Different email services can send the message. These services must be configured using a configuration file to enable using different platforms (e.g.:gmail, DEI's email service, etc.)
* **AC3** The response should include the name and phone number of the responsible Agent.

### 1.4. Found out Dependencies


* There is a dependency to "US015 To list all booking requests" since at least a task category must exist to classify the task being created.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* Name of client
    * Phone number of client
	
* Selected data:
	* Visit Request
    
**Output Data:**

* Response of scheduled visit

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram ](svg/us016-system-sequence-diagram.svg)


### 1.7 Other Relevant Remarks

