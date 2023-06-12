package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public interface BubbleSort {
    void bubbleSortAscending();
    void bubbleSortDescending();



    /*@Override
    public List<Deal> sortAscending(List<Deal> unsorted) {
        List<Deal> deals = new ArrayList<>(unsorted);
        for (int i = 0; i < deals.size() - 1; i++) {  // tb dava para ter size mas ele nao pega no ultimo elemento portanto so economisza
            for (int j = 0; j < deals.size() - i - 1; j++) { //propertyAreas.length
                if (deals.get(j).getAnnouncement().getRequest().getProperty().getArea() > deals.get(j + 1).getAnnouncement().getRequest().getProperty().getArea()) {
                    Deal temp = deals.get(j); // int temp = propertyAreas[j];
                    deals.set(j, deals.get(j + 1)); // propertyAreas[j] = propertyAreas[j+1];
                    deals.set(j + 1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
        return deals;
    }*/

    /*@Override
    public List<Deal> sortDescending(List<Deal> unsorted) {
        List<Deal> deals = new ArrayList<>(unsorted);
        for (int i = 0; i < deals.size() - 1; i++) {
            for (int j = 0; j < deals.size() - i - 1; j++) {
                if (deals.get(j).getAnnouncement().getRequest().getProperty().getArea() < deals.get(j + 1).getAnnouncement().getRequest().getProperty().getArea()) {
                    Deal temp = deals.get(j); // int temp = propertyAreas[j];
                    deals.set(j, deals.get(j + 1)); // propertyAreas[j] = propertyAreas[j+1];
                    deals.set(j + 1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
        return deals;
    }*/
}
