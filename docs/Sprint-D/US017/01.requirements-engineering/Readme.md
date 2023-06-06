# US 017 - List all deals made.

## 1. Requirements Engineering


### 1.1. User Story Description


As a network manager, I want to list all deals made.



### 1.2. Customer Specifications and Clarifications 


**From the specifications document:**

>	The manager of the network intends to analyse the performance of each of the branches and the
global behaviour of the network on a daily basis.

**From the client clarifications:**

>According to the project description "The manager of the network intends to analyze the performance of each of the branches and the global behavior of the network daily." With this sentence, it is implied that the Network manager has access to all data regarding the deals made in each agency.
>
>Now, in the requirements document that was provided the US017's description is "As a network manager, I want to list all deals made.".
>
> **Question :** Can you confirm that we are analyzing the deals made in all the branches all together?
>
> **Answer :** Yes, we are analyzing the deals made in all the branches all together.

> **Question :** In this User Story it is requested that "All deals made" are listed. Are these deals just accepted purchase requests, or are declined purchase requests also included?
>
> **Answer :** A deal takes place when the proposed purchase/renting is accepted.

> **Question :** What should be the default order of the deals when displaying them to the network manager?
>
> **Answer :** The default is to sort deals from the most recent ones to the oldest ones.

### 1.3. Acceptance Criteria
* **AC1 :** The actor should be able to sort all properties by property area (square feet)
in descending/ascending order.
* **AC2 :** Two sorting algorithms should be implemented (to be chosen manually by
the network manager).
* **AC3 :** Worst-case time complexity of each algorithm should be documented in the
application user manual that must be delivered with the application (in the
annexes, where algorithms should be written in pseudocode).

### 1.4. Found out Dependencies
* US11: As an agent, I want to list real estate purchase orders to accept or decline a
purchase order for a property... - It is necessary to have deals to list them. 

### 1.5 Input and Output Data


**Input Data:**

* Typed data:
	* none
	
* Selected data:
	* Menu option to list all deals made in all branches


**Output Data:**

* List of all deals made in all branches of the network, sorted chronologically 
* (In)Success of the operation

### 1.6. System Sequence Diagram (SSD)

**Other alternatives might exist.**

#### Alternative One

![System Sequence Diagram](svg/us006-system-sequence-diagram.svg)

### 1.7 Other Relevant Remarks

* none