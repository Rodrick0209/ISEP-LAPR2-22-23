# US 006 - To register a store

## 1. Requirements Engineering


### 1.1. User Story Description


As a system administrator, I want to register a store.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>   The system administrator registers a store, specifying the designation, location, the e-mail address and contact telephone number.

**From the client clarifications:**

> **Question:** Does a store designation have to be detailed? If so, will the system administrator have to register the name, email, phone number or anything else? Does the location of a store have to be detailed as well? If yes, will the system administrator have to record the address, postcode or something else? To register the store manager, does the system administrator only register the manager's name? If not, will the system administrator have to register the manager as if he were an employee (except the agent he is assigned to)?
>  
> **Answer:** When registering a store, the System Administrator should introduce the following information: an ID, a designation/name, a location, a phone number and an e-mail address. The ID is an integer number. An example of the store location is: 71 ST. NICHOLAS DRIVE, NORTH POLE, FAIRBANKS NORTH STAR, AK, 99705. An example phone number is (907) 488-6419.

> **Question:** Could you please share how will the designation of new stores be made, is there a pattern perhaps?
>
> **Answer:** There is no pattern. The System Administrator can introduce any designation/name. The designation/name should have at most forty characters.

> **Question:** When a System Administrator (admin) makes a request to register a new employee or a new network branch (or any other alteration), does the System ask for the admin credentials (login, password)?
> 
> **Answer:** The System Administrator should be logged in the application.


### 1.3. Acceptance Criteria


* **AC1:** The System Administrator must be logged in the application.
* **AC2:** The credentials of the Store must be valid.
* **AC3:** All required fields must be filled in.


### 1.4. Found out Dependencies


* There is a dependency to "US003 To register a new employee" as a store cannot be registered if it does not have an employee in it.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* an ID, 
	* a designation,
	* a location,
	* a phone number,
	* an e-mail address.

**Output Data:**

* The store information
* (In)Validation of the Credentials

### 1.6. System Sequence Diagram (SSD)


![System Sequence Diagram](svg/us005-system-sequence-diagram.svg)


### 1.7 Other Relevant Remarks

* The ID is an integral number.