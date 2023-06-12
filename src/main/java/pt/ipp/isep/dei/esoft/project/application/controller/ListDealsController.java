package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.BubbleSort;
import pt.ipp.isep.dei.esoft.project.domain.Deal;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.domain.SelectionSort;
import pt.ipp.isep.dei.esoft.project.repository.DealRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.util.List;


public class ListDealsController implements FileReader {

    private ImportInformationController importInformation;
    private DealRepository dealRepository;

    public ListDealsController(){
        getDealRepository();
    }

    public ListDealsController(DealRepository dealRepository){
        this.dealRepository = dealRepository;
    }

    public ImportInformationController getImportInformation(){
        return importInformation;
    }

    private DealRepository getDealRepository(){
        if(dealRepository == null){
            Repositories repositories = Repositories.getInstance();
            dealRepository = repositories.getDealRepository();
        }
        return dealRepository;
    }


    /**
     * Bubble sort algorithm in ascending order.
     * Compares adjacent elements and swaps them if they are in the wrong order.
     * Sorts by comparing the number with its right neighbor in the list.
     *
     */

    /**
     * The exact the process but with descending order
     * Changes if the previous number is smaller than the next.
     */

    /**
     *  Selection sort algorithm in ascending order.
     * Finds the minimum element from the unsorted part and places it at the beginning.
     * Does that to the second element and further and until the full list is sorted
     */


    /**
     * Exact same process but with  sort algorithm in descending order.
     * Finds the maximum element from the unsorted part and places it at the beginning.
     */

    @Override
    public boolean readFile(String fileName) {
        return importInformation.readFile(fileName);
    }

    public List<Deal> getDeals(){
        return getDealRepository().getDeals();
    }
}
