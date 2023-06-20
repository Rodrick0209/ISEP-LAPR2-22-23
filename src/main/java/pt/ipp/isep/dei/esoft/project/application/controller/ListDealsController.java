package pt.ipp.isep.dei.esoft.project.application.controller;

import pt.ipp.isep.dei.esoft.project.domain.Deal;
import pt.ipp.isep.dei.esoft.project.domain.FileReader;
import pt.ipp.isep.dei.esoft.project.repository.DealRepository;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ListDealsController implements FileReader{

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



    public List<Deal> bubbleSortAscending(){
        List<Deal> deals = getDeals();
        List<Deal> deals1 = new ArrayList<>(deals);

        for (int i = 0; i < deals1.size() -1; i++) {  // tb dava para ter size mas ele nao pega no ultimo elemento portanto so economisa
            for (int j = 0; j < deals1.size() - i -1; j++) { //propertyAreas.length
                if(deals1.get(j).getAnnouncement().getRequest().getProperty().getArea() > deals1.get(j+1).getAnnouncement().getRequest().getProperty().getArea()){
                    Deal temp = deals1.get(j); // int temp = propertyAreas[j];
                    deals1.set(j, deals1.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                    deals1.set(j+1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
        return deals1;
    }


    public List<Deal> bubbleSortDescending(){
        List<Deal> deals = getDeals();
        List<Deal> deals1 = new ArrayList<>(deals);
        for (int i = 0; i < deals1.size() -1; i++) {
            for (int j = 0; j < deals1.size() -i-1 ; j++){
                if(deals1.get(j).getAnnouncement().getRequest().getProperty().getArea() < deals1.get(j+1).getAnnouncement().getRequest().getProperty().getArea()){
                    Deal temp = deals1.get(j); // int temp = propertyAreas[j];
                    deals1.set(j, deals1.get(j+1)); // propertyAreas[j] = propertyAreas[j+1];
                    deals1.set(j+1, temp); // propertyAreas[j+1] = temp;
                }
            }
        }
        return deals1;
    }


    public List<Deal> selectionSortAscending() {

        List<Deal> deals = getDeals();
        List<Deal> deals1 = new ArrayList<>(deals);
        for (int i = 0; i < deals1.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < deals1.size(); j++) {
                if (deals1.get(j).getAnnouncement().getRequest().getProperty().getArea() < deals1.get(minIndex).getAnnouncement().getRequest().getProperty().getArea()) {
                    minIndex = j;
                }
            }
            Deal temp = deals1.get(i);
            deals1.set(i, deals1.get(minIndex));
            deals1.set(minIndex, temp);
        }
        return deals1;
    }


    public List<Deal> selectionSortDescending() {
        List<Deal> deals = getDeals();
        List<Deal> deals1 = new ArrayList<>(deals);
        for (int i = 0; i < deals1.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < deals1.size(); j++) {
                if (deals.get(j).getAnnouncement().getRequest().getProperty().getArea() > deals1.get(maxIndex).getAnnouncement().getRequest().getProperty().getArea()) {
                    maxIndex = j;
                }
            }
            Deal temp = deals1.get(i);
            deals1.set(i, deals1.get(maxIndex));
            deals1.set(maxIndex, temp);
        }
        return deals1;
    }

    @Override
    public boolean readFile(File file) {
        return importInformation.readFile(file);
    }

    public List<Deal> getDeals(){
        return getDealRepository().getDeals();
    }
}
