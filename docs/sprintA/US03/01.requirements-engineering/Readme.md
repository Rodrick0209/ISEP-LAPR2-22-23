# US03 - As a system administrator, I want to register a new employee.

## 1. Requirements Engineering

### 1.1. User Story Description

As a system administrator, I want to register a new employee.

### 1.2. Customer Specifications and Clarifications

**From the specifications document:**

> * The company's systems administrator will be responsible for registering all employees (specifying
the name, the citizen's card number, the tax number, the address, the email address, the contact
telephone number and the agency to which it is assigned).
> 
> * All those who wish to use the application must be authenticated with a password of seven alphanumeric characters, including three capital letters and two digits

**From the client clarifications:**

> **Question:** The administrator when registering a new employee will also have to specify the category/office that he will perfom (for example agent, store manager, store network manager)?
>
> **Answer:** The administrator has to specify the role of the employee.

> **Question:** When registering a new employee, will the administrator set the respective employee password?
> 
> **Answer:** The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail

> **Question:** The system administrator cannot add an agent that already exists, the agent has two unique numbers that identify him (Tax number and Citizen's card number) which one should be used to identify the agent?
>
> **Answer:** The tax number.

> **Question:** Must the Tax number and Citizen's card number follow any convention? If so, which?
>
> **Answer:** You should use the tax identification number used for tax purposes in the US.

> **Question:** Does the system administrator select the agency to which the employee is assigned and his role from a list? Or does he just type that data?
>
> **Answer:** The System Administrator should select.

### 1.3. Acceptance Criteria

> AC1: To register an employee it is necessary to specify: name, citizen's card number, tax number, address, email address, contact telephone number, agency to which it is assigned.
> AC2: The administrator has to specify the role of the employee.
> AC3: The password should have eight characters in length and should be generated automatically. The password is sent to the employee by e-mail.
> AC4: The System Administrator should select the agency to which the employee belongs.

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
* List of Typed and selected information.
* Automatic generated password.
* (In)Success of the operation.

### 1.6. System Sequence Diagram (SSD)

![US03-SSD](svg/us03-system-sequence-diagram_SSD.svg)

### 1.7 Other Relevant Remarks

