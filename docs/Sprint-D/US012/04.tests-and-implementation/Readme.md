# US 012 - To import information from a legacy System

# 4. Tests 

**Test 1:** Check that it is not possible to read a file with null values. 

	@Test(expected = FileNotFoundException.class)
		public void ensureNullIsNotAllowed() {
		readFile(null)
	}
	

**Test 2:** Check that it is not possible to read a file with the fileName not in the ".csv" format - AC2. 

	@Test(expected = FileNotFoundException.class)
		public void ensureReferenceMeetsAC2() {
		Scanner sc = new Scanner(new File("xxx.txt"))
	}

**Test 3:** Check that it is not possible to read a file with the headLine of the file empty - AC3.

    @Test(expected = FileNotFoundException.class)
		public void ensureReferenceMeetsAC3() {
		Scanner sc = new Scanner(new File("xxx.csv"))
        headLine == null;
        headLine = sc.nextLine();
	}
        
# 5. Construction (Implementation)


## Class ImportInformationController 

```java
public void readFile(String fileName){
        Scanner sc = new Scanner(new File(fileName));
        }
```



# 6. Integration and Demo 

* A new option on the Administrator menu has been added


# 7. Observations

n/a





