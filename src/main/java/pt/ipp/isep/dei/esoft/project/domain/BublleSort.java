package pt.ipp.isep.dei.esoft.project.domain;

import java.util.ArrayList;
import java.util.List;

public class BublleSort {

    /*public List<VisitRequest> bubbleSort(List<VisitRequest> newList) {
        List<VisitRequest> finalList = new ArrayList<>();
        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = 0; true; j++) {
                if (newList.get(j).getDate().after(newList.get(j+1).getDate())) {
                    finalList.add(newList.get(i));
                    /*VisitRequest temp = finalList.get(j);
                    finalList.set(j, finalList.get(j + 1));
                    finalList.set(j + 1, temp);*/
//}
            //}
        //}
    //return  finalList;
    //}

    public List<VisitRequest> bubbleSort(List<VisitRequest> newList) {
        List<VisitRequest> finalList = new ArrayList<>(newList);

        int n = finalList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (finalList.get(j).getDate().after(finalList.get(j + 1).getDate())) {
                    VisitRequest temp = finalList.get(j);
                    finalList.set(j, finalList.get(j + 1));
                    finalList.set(j + 1, temp);
                }
            }
        }

        return finalList;
    }


}
