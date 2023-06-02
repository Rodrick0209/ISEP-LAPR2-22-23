package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class ListDealsController implements FileReader {

    private List<Integer> propertyAreas;
    private Integer[] propertyAreasArray;

    @Override
    public boolean readFile(String fileName) {
        String file = Files.path + fileName;
        boolean operationSuccess = false;
        try{
            Scanner sc = new Scanner(new File(file));
            String headLine = sc.nextLine();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] information = line.split(";");
                propertyAreas.add(Integer.parseInt(information[7]));
            }
            propertyAreasArray = propertyAreas.toArray(new Integer[0]);
            operationSuccess = true;
        } catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return operationSuccess;
    }
}
