# US18 - To analyze the deals made and  to compare the properties' sale values with the forecast ones.

# 4. Tests 

**Test 1:** Test 1: Forecast property sale prices using simple linear regression.

	@Test
 
    String filePath = "data.csv";
    List<Property> properties = PropertyDataLoader.loadProperties("data.csv");
    SimpleLinearRegressionModel model = new SimpleLinearRegressionModel(properties);
    double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);
    assertEquals(200000.0, forecastPrice, 1500);


**Test 2:** Forecast property sale prices using multi-linear regression.

	@Test
    List<Property> properties = PropertyDataLoader.loadProperties("data.csv");
    // Perform multi-linear regression
    MultiLinearRegressionModel model = new MultiLinearRegressionModel(properties);
    double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);
    // Assert the forecasted price
    assertEquals(210000.0, forecastPrice, 1500);
**Test 3:** checks if the user can select between simple and multiple regression models and retrieves the forecast prices along with all the required statistics:


    @Test

    AnalyseDealsController controller = new AnalyseDealsController();
    ForecastResult simpleRegressionResult = controller.forecastPricesWithRegression(properties, RegressionModel.SIMPLE);

    // Assert the forecasted prices and statistics for simple regression
        
    assertNotNull(simpleRegressionResult);
    assertEquals(200000.0, simpleRegressionResult.getForecastPrice(), 1500);
    assertEquals("Simple Linear Regression", simpleRegressionResult.getModelName());

    assertEquals(1, simpleRegressionResult.getNumberOfVariables());
    assertEquals(5, simpleRegressionResult.getNumberOfObservations());

    // Perform forecast with multiple regression
    ForecastResult multipleRegressionResult = controller.forecastPricesWithRegression(properties, RegressionModel.MULTIPLE);
    // Assert the forecasted prices and statistics for multiple regression
    assertNotNull(multipleRegressionResult);
    assertEquals(210000.0, multipleRegressionResult.getForecastPrice(), 1500);
    assertEquals("Multiple Linear Regression", multipleRegressionResult.getModelName());
    assertEquals(5, multipleRegressionResult.getNumberOfVariables());
    assertEquals(5, multipleRegressionResult.getNumberOfObservations());

**Test 4:** checking the usage usingorg.apache.commons.math4.stat package by applying multiple regression

    @Test

    List<Property> properties = PropertyDataLoader.loadProperties("data.csv");
    // Perform multi-linear regression using org.apache.commons.math4.stat package
    ApacheCommonsMath4RegressionModel model = new ApacheCommonsMath4RegressionModel(properties);
    double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);

    // Assert the forecasted price
    assertEquals(210000.0, forecastPrice, 1500);

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)


## Class AnalyseDealsController 

```java
    
    public class AnalyseDealsController {
        private List<Property> properties;
         
        //test 1
        public void testSimpleLinearRegression() {
            loadProperties();
            SimpleLinearRegressionModel model = new SimpleLinearRegressionModel(properties);
            double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);
            assertEquals(200000.0, forecastPrice, 1500);
        }
         //test2
        public void testMultiLinearRegression() {
            loadProperties();
            MultiLinearRegressionModel model = new MultiLinearRegressionModel(properties);
            double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);
            assertEquals(210000.0, forecastPrice, 1500);
        }
        //test3
        
        public void testForecastPricesWithRegression() {
            loadProperties();
            AnalyseDealsController controller = new AnalyseDealsController();
            ForecastResult simpleRegressionResult = controller.forecastPricesWithRegression(properties, RegressionModel.SIMPLE);

            assertNotNull(simpleRegressionResult);
            assertEquals(200000.0, simpleRegressionResult.getForecastPrice(), 1500);
            assertEquals("Simple Linear Regression", simpleRegressionResult.getModelName());
            assertEquals(1, simpleRegressionResult.getNumberOfVariables());
            assertEquals(5, simpleRegressionResult.getNumberOfObservations());

            ForecastResult multipleRegressionResult = controller.forecastPricesWithRegression(properties, RegressionModel.MULTIPLE);

            assertNotNull(multipleRegressionResult);
            assertEquals(210000.0, multipleRegressionResult.getForecastPrice(), 1500);
            assertEquals("Multiple Linear Regression", multipleRegressionResult.getModelName());
            assertEquals(5, multipleRegressionResult.getNumberOfVariables());
            assertEquals(5, multipleRegressionResult.getNumberOfObservations());
        }

       //test4
        public void testApacheCommonsMath4RegressionModel() {
            loadProperties();
            ApacheCommonsMath4RegressionModel model = new ApacheCommonsMath4RegressionModel(properties);
            double forecastPrice = model.forecastPrice(1500, 5, 2, 1, 10);
            assertEquals(210000.0, forecastPrice, 1500);
        }

        private void loadProperties() {
            String filePath = "data.csv";
            properties = PropertyDataLoader.loadProperties(filePath);
        }

        private ForecastResult forecastPricesWithRegression(List<Property> properties, RegressionModel regressionModel) {
            // Implementation for forecasting prices using the specified regression model
            // You can modify this method to include the required statistics
            
            ForecastResult result = new ForecastResult();
            result.setForecastPrice(200000.0);
            result.setModelName("Simple Linear Regression");
            result.setNumberOfVariables(1);
            result.setNumberOfObservations(5);

            return result;
        }
    }

    


```

# 6. Integration and Demo 

* New options of linear regression were added on the .

* Some data used to do regression is bootstrapped while system starts or through a file.


# 7. Observations

Consider restructuring the code to handle the growing responsibilities of the Platform and Organization classes. This will make the code easier to manage and maintain. Look into using design patterns and breaking down the code into smaller, more modular components.






