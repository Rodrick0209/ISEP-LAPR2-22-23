package pt.ipp.isep.dei.esoft.project.application.controller;
import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Deal;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.repository.AgencyRepository;
import pt.ipp.isep.dei.esoft.project.repository.DealRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Main.
 */
public class DivideStoresSubSetsController implements FileReader {

    private DealRepository dealRepository ;
    private ImportInformationController importInformationController;
    private AgencyRepository agencyRepository;


    public DivideStoresSubSetsController(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }
     public DivideStoresSubSetsController() {
       getDealRepository();
     }
     private AgencyRepository getAgencyRepository(){
        if (agencyRepository == null){
            Repositories repositories = Repositories.getInstance();
            agencyRepository = repositories.getAgencyRepository();
        }
        return agencyRepository;
     }


    private DealRepository getDealRepository(){
        if (dealRepository == null){
            Repositories repositories = Repositories.getInstance();
            dealRepository = repositories.getDealRepository();
        }
        return dealRepository;
    }

    public List<Integer> countProperties() {             // each Deals is linked to  a property
        List<Deal> deals = getDeals();
        List<Integer> properties = new ArrayList<>();
        for (Deal d : deals) {
            Agency agency = d.getAgency();
            int index = getAgencies().indexOf(agency);
            if(index != -1){
                int count = properties.get(index);
                properties.set(index,count+1);
            }else {
               properties.add(1);
            }

        }
         return properties;
    }

    private List <Deal> getDeals(){
        return getDealRepository().getDeals();
    }
    private List <Agency> getAgencies(){
        return getAgencyRepository().getAgencies();
    }




    public  int findMinSubsetDifference(List<Integer> properties) {
        List <Integer> subset1 = new ArrayList<>();
        List <Integer> subset2 = new ArrayList<>();

        int n = properties.size();  // n = PropertiesSize = stores = 3

        int minDifference = Integer.MAX_VALUE;
        List<Integer> minSubset1 = new ArrayList<>();
        List<Integer> minSubset2 = new ArrayList<>();

        // Generate all possible binary combinations  from 1 to 2^n - 1


        for (int i = 1; i < (1 << n); i++) {   // 2^n-1 permutations
            subset1.clear();
            subset2.clear();

            //Assign properties to subsets based on binary representation


            for (int j = 0; j < n; j++) { //   This loop processes each bit position in the binary representation of i.
                if ((i & (1 << j)) != 0) {
                    subset1.add(properties.get(j));
                } else {
                    subset2.add(properties.get(j));
                }
            }

            int difference = Math.abs(sum(subset1) - sum(subset2));
            if (difference < minDifference) {   //saves the minimum diference and the subsets linked to the minimum difference
                minDifference = difference;
                minSubset1 = new ArrayList<>(subset1);
                minSubset2 = new ArrayList<>(subset2);
            }


        }

        //  Equals the subsets to get the subsets with minimum difference

        subset1.clear();
        subset1.addAll(minSubset1); //subset1 = minsubset1
        subset2.clear();
        subset2.addAll(minSubset2); //subset2 = minsubset2
        return minDifference;
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum;
    }


    @Override
    public boolean readFile(File file) {
        return importInformationController.readFile(file);
    }

}



