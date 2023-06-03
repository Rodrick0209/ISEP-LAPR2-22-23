package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListDealsController implements FileReader, BubbleSort {

    private Integer[] propertyAreas;

    @Override
    public boolean readFile(String fileName) {
        String file = Files.path + fileName;
        List<Integer> propertyAreasList = new ArrayList<>();
        boolean operationSuccess = false;
        try{
            Scanner sc = new Scanner(new File(file));
            String headLine = sc.nextLine();
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] information = line.split(";");
                propertyAreasList.add(Integer.parseInt(information[7]));
            }
            propertyAreas = propertyAreasList.toArray(new Integer[0]);
            operationSuccess = true;
        } catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return operationSuccess;
    }

    public void bubbleSortAscending(){
        for (int i = 0; i < propertyAreas.length - 1; i++) {
            for (int j = 0; j < propertyAreas.length - i - i ; j++) {
                if(propertyAreas[j] > propertyAreas[j+1]){
                    int temp = propertyAreas[j];
                    propertyAreas[j] = propertyAreas[j+1];
                    propertyAreas[j+1] = temp;
                }
            }
        }
    }
    public void bubbleSortDescending(){
        for (int i = 0; i < propertyAreas.length; i++) {
           for (int j = 0; j < propertyAreas.length - i - i ; j++){
               if(propertyAreas[j] < propertyAreas[j+1]){
                   int temp = propertyAreas[j];
                   propertyAreas[j] = propertyAreas[j+1];
                   propertyAreas[j+1] = temp;
               }
           }
        }
    }

}
