package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public List<VisitRequest> selectionSort(){
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
        return sorted;
    }

}
