package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * The interface Selection sort.
 */
public interface SelectionSort {
    /**
     * Selection sort ascending.
     *
     * @return
     */

    void selectionSortAscending();

    void selectionSortDescending();
    /*@Override
    public List<Deal> sortAscending(List<Deal> unsorted) {
        List<Deal> deals = new ArrayList<>(unsorted);
        for (int i = 0; i < deals.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < deals.size(); j++) {
                if (deals.get(j).getAnnouncement().getRequest().getProperty().getArea() < deals.get(minIndex).getAnnouncement().getRequest().getProperty().getArea()) {
                    minIndex = j;
                }
            }
            Deal temp = deals.get(i);
            deals.set(i, deals.get(minIndex));
            deals.set(minIndex, temp);
        }
        return deals;
    }*/
    /**
     * Selection sort descending.
     *
     * @return
     */
    /*@Override
    public List<Deal> sortDescending(List<Deal> unsorted) {
        List<Deal> deals = new ArrayList<>(unsorted);
        for (int i = 0; i < deals.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < deals.size(); j++) {
                if (deals.get(j).getAnnouncement().getRequest().getProperty().getArea() > deals.get(maxIndex).getAnnouncement().getRequest().getProperty().getArea()) {
                    maxIndex = j;
                }
            }
            Deal temp = deals.get(i);
            deals.set(i, deals.get(maxIndex));
            deals.set(maxIndex, temp);
        }
        return deals;
    }*/
}
