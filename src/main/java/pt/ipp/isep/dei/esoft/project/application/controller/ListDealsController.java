package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.domain.SelectionSort;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListDealsController implements FileReader, BubbleSort, SelectionSort {

    private List<Integer> propertyAreas;

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
            operationSuccess = true;
        } catch (FileNotFoundException e){
            System.out.println("File not Found");
        }
        return operationSuccess;
    }

    @Override
    public void bubbleSortAscending(){
        for (int i = 0; i < propertyAreas.size() - 1; i++) {
            for (int j = 0; j < propertyAreas.size() - i - 1; j++) {
                if(propertyAreas.get(j) > propertyAreas.get(j+1)){
                    int temp = propertyAreas.get(j); // int temp = propertyAreas[j];
                    propertyAreas.set(j, propertyAreas.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                    propertyAreas.set(j+1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
    }
    @Override
    public void bubbleSortDescending(){
        for (int i = 0; i < propertyAreas.size() - 1; i++) {
           for (int j = 0; j < propertyAreas.size() - i - 1; j++){
               if(propertyAreas.get(j) < propertyAreas.get(j+1)){
                   int temp = propertyAreas.get(j); // int temp = propertyAreas[j];
                   propertyAreas.set(j, propertyAreas.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                   propertyAreas.set(j+1, temp); // propertyAreas[j+1] = temp;
               }
           }
        }
    }

    @Override
    public void selectionSortAscending() {
        for (int i = 0; i < propertyAreas.size()-1; i++) {
            int minIndex = i;
            for (int j = 0; j < propertyAreas.size(); j++) {
                if(propertyAreas.get(j) < propertyAreas.get(j+1)){
                    minIndex = j;
                }
            }
            int temp = propertyAreas.get(i); // int temp = propertyAreas[i]
            propertyAreas.set(i, propertyAreas.get(minIndex)); // propertyAreas[i] = propertyAreas[minIndex]
            propertyAreas.set(minIndex, temp); // propertyAreas[minIndex] = temp
        }
    }
    @Override
    public void selectionSortDescending() {
        for (int i = 0; i < propertyAreas.size()-1; i++) {
            int maxIndex = i;
            for (int j = 0; j < propertyAreas.size(); j++) {
                if(propertyAreas.get(j) > propertyAreas.get(j+1)){
                    maxIndex = j;
                }
            }
            int temp = propertyAreas.get(i); // int temp = propertyAreas[i]
            propertyAreas.set(i, propertyAreas.get(maxIndex)); // propertyAreas[i] = propertyAreas[minIndex]
            propertyAreas.set(maxIndex, temp); // propertyAreas[minIndex] = temp
        }
    }
}
