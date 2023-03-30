# US 001 - To display listed properties (unregistered user) 

## 1. Requirements Engineering


### 1.1. User Story Description


As an unregistered user, I want to display listed properties.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The possible owner can browse available properties in a specific area and get an idea of the market 


>	The owner are able to filter the search results by location, price range, and property type, and view high-quality images and detailed descriptions of each property. He´s also able to save his favorite properties and compare them with others he has seen on the website. Ultimately, the goal is to find something that meets his needs and budget, and then persuade him to register for an account to start the process of buying or renting it 



**From the client clarifications:**

> **Question:** Does the unregistered user need to login or register to see the list of properties?
>  
> **Answer:** No, the unregistered user does not need to login or register to see the property list.


> **Question:** What specific information about the properties will the unregistered user be able to see in the list?
>  
> **Answer:** This will depend on what has been defined as basic property information. This information includes the property type, number of rooms, price, location and a photo. The unregistered user may not have access to more detailed information, such as full descriptions, additional features or seller contact information.

> **Question:** Will there be any information about the availability of properties on the list?
> 
> **Answer:** Normally, the availability of properties is updated in real time, but it may be that the information is not available in the list. The unregistered user may need to click on a specific property to check its updated availability.


### 1.3. Acceptance Criteria


* **AC1:** All required fiels must be filled in.
* **AC2:** Task reference must have at least 5 alphanumeric chars.
* **AC3:** When creating a task with an already existing reference, the system must reject such operation and the user must have the change to modify the typed reference.


### 1.4. Found out Dependencies


* There is a dependency to "US003 Create a task category" since at least a task category must exist to classify the task being created.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* a reference, 
	* a designation, 
	* an informal description
	* a technical description
	* an estimated duration
	* an estimated cost
	
* Selected data:
	* Classifying task category 


**Output Data:**

* List of existing task categories
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram - Alternative One](svg/us006-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.