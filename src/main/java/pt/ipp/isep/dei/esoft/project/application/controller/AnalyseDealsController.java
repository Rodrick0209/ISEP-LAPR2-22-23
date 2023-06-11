package pt.ipp.isep.dei.esoft.project.application.controller;

import org.apache.commons.math4.legacy.stat.regression.OLSMultipleLinearRegression;
import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.domain.RegressionResults;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The type Analyse deals controller.
 */
public class AnalyseDealsController implements FileReader {

    private Double[] salePrices;
    private Double[] propertiesArea;
    private Double[] propertiesDistanceFromCityCentre;
    private Double[] propertiesNumberOfBedrooms;
    private Double[] propertiesNumberOfBathrooms;
    private Double[] propertiesNumberOfParkingSpaces;

    @Override
    public boolean readFile(String fileName){
        String file = Files.pathCSV + fileName;
        double squareFeetConverter = 0.0929;
        List<Double> salePrices = new ArrayList<>();
        List<Double> propertiesArea = new ArrayList<>();
        List<Double> propertiesDistanceFromCityCentre = new ArrayList<>();
        List<Double> propertiesNumberOfBedrooms = new ArrayList<>();
        List<Double> propertiesNumberOfBathrooms = new ArrayList<>();
        List<Double> propertiesNumberOfParkingSpaces = new ArrayList<>();
        boolean operationSuccess = false;
        try{
            Scanner sc = new Scanner(new File(file));
            String headLine = sc.nextLine();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] information = line.split(";");
                if (information[24].equalsIgnoreCase("sale")) {
                    if(information[6].equalsIgnoreCase("house") || information[6].equalsIgnoreCase("apartment")){
                        salePrices.add(Double.parseDouble(information[19]));
                        propertiesArea.add(Double.parseDouble(information[7]) * squareFeetConverter);
                        propertiesDistanceFromCityCentre.add(Double.parseDouble(information[8]));
                        propertiesNumberOfBedrooms.add(Double.parseDouble(information[9]));
                        propertiesNumberOfBathrooms.add(Double.parseDouble(information[10]));
                        propertiesNumberOfParkingSpaces.add(Double.parseDouble(information[11]));
                    }
                }
            }
            this.salePrices = salePrices.toArray(new Double[0]);
            this.propertiesArea = propertiesArea.toArray(new Double[0]);
            this.propertiesDistanceFromCityCentre = propertiesDistanceFromCityCentre.toArray(new Double[0]);
            this.propertiesNumberOfBedrooms = propertiesNumberOfBedrooms.toArray(new Double[0]);
            this.propertiesNumberOfBathrooms = propertiesNumberOfBathrooms.toArray(new Double[0]);
            this.propertiesNumberOfParkingSpaces = propertiesNumberOfParkingSpaces.toArray(new Double[0]);
            operationSuccess = true;
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } return operationSuccess;
    }

    public RegressionResults simpleRegressionPropertyArea(){
        Double[][] dataArray = { propertiesArea, salePrices};
        double[][] data = new double[propertiesArea.length][salePrices.length];
        for (int i = 0; i < propertiesArea.length; i++) {
            for (int j = 0; j < salePrices.length ; j++) {
                data[i][j] = dataArray[i][j];
            }
        }
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        return new RegressionResults(slope, intercept);
    }

    public RegressionResults simpleRegressionPropertyDistance(){
        Double[][] dataArray = { propertiesDistanceFromCityCentre, salePrices};
        double[][] data = new double[propertiesDistanceFromCityCentre.length][salePrices.length];
        for (int i = 0; i < propertiesDistanceFromCityCentre.length; i++) {
            for (int j = 0; j < salePrices.length; j++) {
                data[i][j] = dataArray[i][j];
            }
        }
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        return new RegressionResults(slope, intercept);
    }

    public RegressionResults simpleRegressionPropertyNumberBedrooms(){
        Double[][] dataArray = {propertiesNumberOfBedrooms, salePrices};
        double[][] data = new double[propertiesNumberOfBedrooms.length][salePrices.length];
        for (int i = 0; i < propertiesNumberOfBedrooms.length; i++) {
            for (int j = 0; j < salePrices.length; j++) {
                data[i][j] = dataArray[i][j];
            }
        }
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        return new RegressionResults(slope, intercept);
    }

    public RegressionResults simpleRegressionPropertyNumberBathrooms(){
        Double[][] dataArray = {propertiesNumberOfBathrooms, salePrices};
        double[][] data = new double[propertiesNumberOfBathrooms.length][salePrices.length];
        for (int i = 0; i < propertiesNumberOfBathrooms.length; i++) {
            for (int j = 0; j < salePrices.length; j++) {
                data[i][j] = dataArray[i][j];
            }
        }
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        return new RegressionResults(slope, intercept);
    }

    public RegressionResults simpleRegressionNumberOfParkingSpaces(){
        Double[][] dataArray = {propertiesNumberOfParkingSpaces, salePrices};
        double[][] data = new double[propertiesNumberOfParkingSpaces.length][salePrices.length];
        for (int i = 0; i < propertiesNumberOfParkingSpaces.length; i++) {
            for (int j = 0; j < salePrices.length; j++) {
                data[i][j] = dataArray[i][j];
            }
        }
        SimpleRegression regression = new SimpleRegression();
        regression.addData(data);
        double intercept = regression.getIntercept();
        double slope = regression.getSlope();
        return new RegressionResults(slope, intercept);
    }

    public RegressionResults multiRegression(){
        double[] salePrices = new double[this.salePrices.length];
        for (int i = 0; i < salePrices.length; i++) {
            this.salePrices[i] = salePrices[i];
        }
        double[][] propertiesData = new double[this.salePrices.length][5];
        for (int i = 0; i < propertiesArea.length ; i++) {
            propertiesData[i][0] = propertiesArea[i];
        }
        for (int i = 0; i < propertiesDistanceFromCityCentre.length; i++) {
            propertiesData[i][1] = propertiesDistanceFromCityCentre[i];
        }
        for (int i = 0; i < propertiesNumberOfBedrooms.length; i++) {
            propertiesData[i][2] = propertiesNumberOfBedrooms[i];
        }
        for (int i = 0; i < propertiesNumberOfBathrooms.length ; i++) {
            propertiesData[i][3] = propertiesNumberOfBathrooms[i];
        }
        for (int i = 0; i < propertiesNumberOfParkingSpaces.length; i++) {
            propertiesData[i][4] = propertiesNumberOfParkingSpaces[i];
        }
        OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
        regression.newSampleData(salePrices, propertiesData);
        double[] parameters = regression.estimateRegressionParameters();
        return new RegressionResults(parameters);
    }

    public double getEstimatedSalePriceForSimpleRegression(RegressionResults regressionResults, double propertyValue){
        return regressionResults.getSlope() * propertyValue + regressionResults.getIntercept();
    }

    public double[] getEstimatedSalePriceForMultiRegression(RegressionResults regressionResults, double[] propertyValues) {
        double[] salePrices = new double[regressionResults.getParameters().length];
        for (int i = 0; i < salePrices.length; i++) {
            salePrices[i] = regressionResults.getParameters()[i] * propertyValues[i];
        }
        return salePrices;
    }
}
