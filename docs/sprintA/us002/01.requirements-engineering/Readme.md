# US 002 - To create a Task 

## 1. Requirements Engineering


### 1.1. User Story Description

As an agent, I can publish any sale announcement on the system, for example received through a phone call.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	Each task is characterized by having a unique reference per organization, a designation, an informal and a technical description, an estimated duration and cost as well as the its classifying task category. 


>	As long as it is not published, access to the task is exclusive to the employees of the respective organization. 



**From the client clarifications:**  // perguntas mais importantes do forum de us2
// eu, agente , pergunto ao cliente:

> **Question:** Does a store designation have to be detailed? If so, will the system administrator have to register the name, email, phone number or anything else?
>  
> **Answer:** 


> **Question:** Does the location of a store have to be detailed as well? If yes, will the system administrator have to record the address, postcode or something else?
>  
> **Answer:** 

> **Question:**
> 
> **Answer:**
 
> **Question:**
> 
> **Answer:**

### 1.3. Acceptance Criteria // o que é necessario 


* **AC1:** All required fiels must be filled in.
* **AC2:** Task reference must have at least 5 alphanumeric chars.
* **AC3:** When creating a task with an already existing reference, the system must reject such operation and the user must have the change to modify the typed reference.


### 1.4. Found out Dependencies // dependencia de outro user story


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

#### Alternative Two

![System Sequence Diagram - Alternative Two](svg/us006-system-sequence-diagram-alternative-two.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.