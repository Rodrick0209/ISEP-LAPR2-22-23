# US03 - As a system administrator, I want to register a new employee.

## 1. Requirements Engineering

### 1.1. User Story Description

As a system administrator, I want to register a new employee.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

>	

**From the client clarifications:**

> **Question:** The administrator when registering a new employee will also have to specify the category/office that he will perfom (for example agent, store manager, store network manager)?
>
> **Answer:** The administrator has to specify the role of the employee.


### 1.3. Acceptance Criteria

> AC1: To register an employee it is necessary to specify: name, citizen's card number, tax number, address, email address, contact telephone number, agency to which it is assigned.

### 1.4. Found out Dependencies

* There were no dependencies found.

### 1.5 Input and Output Data

**Input Data:**
* Typed data:
  * a name,
  * a citizen's card number,
  * a tax number,
  * an address,
  * an email address,
  * a contact telephone number.

* Selected Data:
    * an agency to which the employee is assigned,
    * a role.

**Output Data:**
* List of existing agencies,
* List of existing roles.
* (In)Success of the operation.

### 1.6. System Sequence Diagram (SSD)

![US03-SSD](svg/us03-system-sequence-diagram_SSD.svg)

### 1.7 Other Relevant Remarks

*Use this section to capture other relevant information that is related with this US such as (i) special requirements ; (ii) data and/or technology variations; (iii) how often this US is held.* 
