package pt.ipp.isep.dei.esoft.project.repository;

import pt.ipp.isep.dei.esoft.project.domain.Agency;
import pt.ipp.isep.dei.esoft.project.domain.Announcement;
import pt.ipp.isep.dei.esoft.project.domain.Deal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DealRepository implements Serializable {

    private final List<Deal> deals = new ArrayList<>();

    public Optional<Deal> createDeal(Announcement announcement, Date dateOfSale, Agency agency){
        Optional<Deal> optionalValue = Optional.empty();

        Deal deal = new Deal(announcement, dateOfSale, agency);
        if(addDeal(deal)){
            optionalValue = Optional.of(deal);
        }
        return optionalValue;
    }

    public boolean addDeal(Deal deal){
        boolean operationSuccess = false;
        if(validateDeal(deal)){
            operationSuccess = deals.add(deal);
        }
        return operationSuccess;
    }

    private boolean validateDeal(Deal deal){return !deals.contains(deal);}

    public List<Deal> getDeals(){return List.copyOf(deals);}
}
