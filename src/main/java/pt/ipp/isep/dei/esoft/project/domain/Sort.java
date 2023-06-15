package pt.ipp.isep.dei.esoft.project.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Sort {

    String sortingAlgorithm;
    public void bubbleSort() {
        List<VisitRequest> sorted = new ArrayList<>();
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).getDate().after(sorted.get(j+1).getDate())) {
                    VisitRequest temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
    }

    public void selectionSort(){
        List<VisitRequest> sorted = new ArrayList<>();
        for (int i = 0; i < sorted.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j).getDate().after(sorted.get(j+1).getDate())) {
                    minIndex = j;
                }
            }
            VisitRequest temp = sorted.get(i);
            sorted.set(i, sorted.get(minIndex));
            sorted.set(minIndex, temp);
        }
    }

    /*public void bubbleSort(List<VisitRequest> unsorted) {
        List<VisitRequest> sorted = new ArrayList<>(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                if (sorted.get(j).getDate().after(sorted.get(j+1).getDate())) {
                    VisitRequest temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
    }

    public void selectionSort(List<VisitRequest> unsorted){
        List<VisitRequest> sorted = new ArrayList<>(unsorted);
        for (int i = 0; i < sorted.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sorted.size(); j++) {
                if (sorted.get(j).getDate().after(sorted.get(j+1).getDate())) {
                    minIndex = j;
                }
            }
            VisitRequest temp = sorted.get(i);
            sorted.set(i, sorted.get(minIndex));
            sorted.set(minIndex, temp);
        }
    }*/

    public Properties getConfigurationFile() {
        Properties properties = new Properties();
        try {
        FileInputStream file = new FileInputStream("src/main/resources/application.properties");
        properties.load(file);
        file.close();
    } catch (
    IOException e) {
        e.printStackTrace();
    }

    String algorithm = properties.getProperty("sorting.algorithms");
    System.out.println("Sorting algorithm: "+ sortingAlgorithm);

    return properties;


    }



}
