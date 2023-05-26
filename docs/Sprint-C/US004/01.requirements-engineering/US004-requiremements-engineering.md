# US 004 - to submit a request

## 1. Requirements Engineering


### 1.1. User Story Description

As an owner, I intend to submit a request for listing a agency sale or rent,
choosing the responsible agent.

### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The owner provides agency characteristics and the requested price and sends the request to an agent

>	The agent sets the commission and publishes the offer in the system. The commission can be a fixed amount or a percentage.


**From the client clarifications:**

> **Question:** If the owner doesn't select any agent in the request, is the agent randomly chosen by the system? 
>  
> **Answer:** Yes, if the owner does not select an agent, the last one is randomly selected by the system.


> **Question:** Does the owner have a limit of requests they can do?
>  
> **Answer:** No, he doesn't.


> **Question:** When renting, does the owner have any space to clarify any prohibitions or obligations with the agency?
>
> **Answer:** No, he doesn't.


> **Question:** In the case of listing a land agency, shall the owner refer if there is a building permit already approved?
>
> **Answer:** No, he doesn't.


### 1.3. Acceptance Criteria


* **AC1:** All required agency's characteristics must be filled in.
* **AC2:** The owner needs to select the type of agency ( house, apartment or land).
* **AC3:** The agent needs to register the information and publish it, so it is visible to all clients that visit and use the application


### 1.4. Found out Dependencies


* There is a dependency to US003 because  US004 needs an agent that is registered by administrator.


### 1.5 Input and Output Data


**Input Data:**

* Typed data:
  * number of bedrooms
  * number ofs bathrooms
  * number of parking spaces
  * existence of central heating
  * existence of air conditioning
  * existence of a basement
  * existence of an inhabitable loft
  * existence of sun exposure
	
* Selected data:
	* land or house or apartment 


**Output Data:**

* List of agency or land that satisfy the requirements
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us004-system-sequence-diagram-alternative-one.svg)

### 1.7 Other Relevant Remarks

* The created task stays in a "not published" state in order to distinguish from "published" tasks.