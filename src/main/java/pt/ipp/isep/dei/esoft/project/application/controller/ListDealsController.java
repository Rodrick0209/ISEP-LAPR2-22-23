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


    /**
     * Bubblesort algorithm in ascending order.
     * Compares adjacent elements and swaps them if they are in the wrong order.
     * Sorts by comparing the number with its right neighbor in the list.
     *
     */
    @Override
    public  void bubbleSortAscending(){

        for (int i = 0; i < propertyAreas.size() -1; i++) {  // tb dava para ter size mas ele nao pega no ultimo elemento portanto so economisza
            for (int j = 0; j < propertyAreas.size() - i -1; j++) { //propertyAreas.length
                if(propertyAreas.get(j) > propertyAreas.get(j+1)){
                    int temp = propertyAreas.get(j); // int temp = propertyAreas[j];
                    propertyAreas.set(j, propertyAreas.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                    propertyAreas.set(j+1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }

    }

    /**
     * The exact the process but with descending order
     * Changes if the previous number is smaller than the next.
     */
    @Override
    public  void bubbleSortDescending(){
        for (int i = 0; i < propertyAreas.size() -1; i++) {
            for (int j = 0; j < propertyAreas.size() -i-1 ; j++){
                if(propertyAreas.get(j) < propertyAreas.get(j+1)){
                    int temp = propertyAreas.get(j); // int temp = propertyAreas[j];
                    propertyAreas.set(j, propertyAreas.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                    propertyAreas.set(j+1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
    }

    /**
     *  Selection sort algorithm in ascending order.
     * Finds the minimum element from the unsorted part and places it at the beginning.
     * Does that to the second element and further and until the full list is sorted
     */
    public  void selectionSortAscending() {
        for (int i = 0; i < propertyAreas.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < propertyAreas.size(); j++) {
                if (propertyAreas.get(j) < propertyAreas.get(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = propertyAreas.get(i);
            propertyAreas.set(i, propertyAreas.get(minIndex));
            propertyAreas.set(minIndex, temp);
        }
    }


    /**
     * Exact same process but with  sort algorithm in descending order.
     * Finds the maximum element from the unsorted part and places it at the beginning.
     */
    public  void selectionSortDescending() {
        for (int i = 0; i < propertyAreas.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < propertyAreas.size(); j++) {
                if (propertyAreas.get(j) > propertyAreas.get(maxIndex)) {
                    maxIndex = j;
                }
            }
            int temp = propertyAreas.get(i);
            propertyAreas.set(i, propertyAreas.get(maxIndex));
            propertyAreas.set(maxIndex, temp);
        }
    }

}
