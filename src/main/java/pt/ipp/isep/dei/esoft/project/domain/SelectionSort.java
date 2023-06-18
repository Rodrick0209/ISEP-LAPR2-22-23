package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public List<VisitRequest> selectionSort(List<VisitRequest> newList){
        List<VisitRequest> finalList = new ArrayList<>();
        for (int i = 0; i < newList.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < newList.size(); j++) {
                if (newList.get(j).getDate().after(newList.get(j+1).getDate())) {
                    minIndex = j;
                    finalList.add(newList.get(i));
                }
            }
            VisitRequest temp = newList.get(i);
            newList.set(i, newList.get(minIndex));
            newList.set(minIndex, temp);
        }
        return finalList;
    }

}
