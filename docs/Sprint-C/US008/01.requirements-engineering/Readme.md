# US 008 - To see the announcment requests and select a request in order to than publish an announcment.

## 1. Requirements Engineering


### 1.1. User Story Description

As an agent, I intend to see the list of property announcement requests made to myself,
so that I can post the announcement.


### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

> The real estate agent reviews property requests submitted by owner and selects one to accept. 

> As soon as the request is accepted he can publish the announcment linked to the request. 


**From the client clarifications:** //so falta isto + 1.7

> **Question:** How does the agent determine whether it is a fixed commission or a percentage commission?
>
> **Answer:** The agent should choose the type of commission and enter the value.

> **Question:** Is the phone call the only way the agent can receive the sale announcement? Or he can receive them via e-mail/letter/etc
>
> **Answer:** For now this is the only way.

> **Question:** Can an Agent work in more than 1 store (Multiple stores)?
>
> **Answer:** No.

> **Question:** According to the Project Description, the agent when selling a agency can charge a flat price comission or a percentage of the sale value, my question here is wether there is a minimum and/or a maximum to each of these types of comissions?
>
> **Answer:** There is no maximum and the minimum is 0.


### 1.3. Acceptance Criteria

* **AC1:** The list of property announcement request should be sorted by the date they were created, with the most recent requests appearing first.
* **AC2:** An announcement is posted when a request is accepted. The list of requests should be refreshed, and that request should not be shown ag


### 1.4. Found out Dependencies


* There is a dependency to US004 since the agent receives a request from the owner trhough a
 phone call, or the application itself. Once he receives that request ,he than can validate the data, choose and announce it.

### 1.5 Input and Output Data


**Input Data:**

- Id/email
- Password

*After login*
- Selection of display request option
- Selection and acception of request



**Output Data:**

* Agent request list
* Announcment dispplay
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

![us008-system-sequence-diagram-alternative-one.puml](svg/us008-system-sequence-diagram-alternative-one.svg)


### 1.7 Other Relevant Remarks

* -