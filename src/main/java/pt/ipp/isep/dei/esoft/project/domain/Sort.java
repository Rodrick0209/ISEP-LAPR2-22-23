package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

public interface Sort {

    List<Deal> sortAscending(List<Deal> unsorted);

    List<Deal> sortDescending(List<Deal> unsorted);
}
