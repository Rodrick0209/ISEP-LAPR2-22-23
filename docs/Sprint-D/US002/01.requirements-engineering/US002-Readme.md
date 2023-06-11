# US 002 - To publish an announcement 

## 1. Requirements Engineering


### 1.1. User Story Description

As an agent, I can publish any sale announcement on the system, for example received through a phone call.

### 1.2. Customer Specifications and Clarifications 

**From the specifications document:**

>The real estate agent publishes announcements of the owner's  properties.

> As soon as the clients are interested on these properties, the agent schedules a meeting with the future possibility of getting a sale or agency rent.

** From the client clarifications:**  

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
> > **Question:** In this User Story it is requested that "All deals made" are listed. Are these deals just accepted purchase requests, or are declined purchase requests also included?
> 
> **Answer:**  A deal takes place when the proposed purchase/renting is accepted.


### 1.3. Acceptance Criteria 

* **AC1** An SMS notification should be sent to the owner when the listing of the property becomes available.
* **AC2** The notification must include the property identification and the date it became available.
* **AC3** The Notification must include the name and phone number of theresponsible Agent.

### 1.4. Found out Dependencies 

* There is a dependency on US004 and also to the actor : "Owner" in which the owner submits a request for an agency sale or rent, choosing the responsible agent .
* The agent itself also has to communicate with the owner ,sending him a message when the listing of the property becomes avaible ,hence the owner is also has a dependency on the agent .
* The agent works as a bridge between the client and the owner.

### 1.5 Input and Output Data

**Input Data:**

- Id/email
- Password

*After login*
- Type of Commison 
- Comission Value


**Output Data:**

* Announcment data (id, type of commission,commission value,date)d display
* Announcment status dispplayd

### 1.6. System Sequence Diagram (SSD)

![System Sequence Diagram - Alternative One](svg/us002-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* It is important to note that the main objective of the agent is to publish an announcement on the system, as demonstrated in this user story. However, the same actor may have additional requirements or demands in other user stories.