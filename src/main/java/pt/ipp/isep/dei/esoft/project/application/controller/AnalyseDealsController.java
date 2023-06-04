package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnalyseDealsController implements FileReader {

    private Double[] salePrices;
    private Double[] propertiesArea;
    private Double[] propertiesDistanceFromCityCentre;
    private Double[] propertiesNumberOfBedrooms;
    private Double[] propertiesNumberOfBathrooms;
    private Double[] propertiesNumberOfParkingSpaces;

    @Override
    public boolean readFile(String fileName) {
        String file = Files.path + fileName;
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
}
