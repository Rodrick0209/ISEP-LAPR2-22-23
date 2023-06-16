package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class BublleSort {

    public List<VisitRequest> bubbleSort() {
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
    return  sorted;
    }



}
