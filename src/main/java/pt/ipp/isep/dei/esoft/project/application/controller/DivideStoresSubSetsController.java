package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.AgencyInfo;
import pt.ipp.isep.dei.esoft.project.domain.Deal;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.DealRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;
import pt.ipp.isep.dei.esoft.project.ui.console.utils.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The type Main.
 */
public class DivideStoresSubSetsController {

    private AgencyRepository agencyRepository;


    public DivideStoresSubSetsController(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

     public DivideStoresSubSetsController() {
       getAgencyRepository();
     }

     private AgencyRepository getAgencyRepository(){
        if (agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
     }


    public List <Agency> getAgencies(){
        return getAgencyRepository().getAgencies();
    }


    public int findMinSubsetDifference(List<Agency> agencies, List<AgencyInfo> subset1, List<AgencyInfo> subset2) {
        int n = agencies.size();
        int minDifference = Integer.MAX_VALUE;
        List<AgencyInfo> minSubset1 = new ArrayList<>();
        List<AgencyInfo> minSubset2 = new ArrayList<>();

        for(int i = 1; i < 1 << n; ++i) {
            subset1.clear();
            subset2.clear();

            int difference;
            for(difference = 0; difference < n; ++difference) {
                if ((i & 1 << difference) != 0) {
                    subset1.add(new AgencyInfo(agencies.get(difference).getID(), agencies.get(difference).getPropertyCount()));
                } else {
                    subset2.add(new AgencyInfo(agencies.get(difference).getID(), agencies.get(difference).getPropertyCount()));
                }
            }

            difference = Math.abs(sum(subset1) - sum(subset2));
            if (difference < minDifference) {
                minDifference = difference;
                minSubset1 = new ArrayList<>(subset1);
                minSubset2 = new ArrayList<>(subset2);
            }
        }

        subset1.clear();
        subset1.addAll(minSubset1);
        subset2.clear();
        subset2.addAll(minSubset2);
        return minDifference;
    }

    private int sum(List<AgencyInfo> list) {
        int sum = 0;
        for(AgencyInfo ai : list){
            sum += ai.getNumberOfProperties();
        }
        return sum;
    }

}



