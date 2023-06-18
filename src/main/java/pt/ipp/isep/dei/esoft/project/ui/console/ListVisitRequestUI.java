package pt.ipp.isep.dei.esoft.project.ui.console;

import pt.ipp.isep.dei.esoft.project.application.controller.ListVisitRequestController;
import pt.ipp.isep.dei.esoft.project.domain.Sort;
import pt.ipp.isep.dei.esoft.project.domain.VisitRequest;
import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * The type List visit request ui.
 */
public class ListVisitRequestUI implements Runnable {

    /**
     * The Controller.
     */
    ListVisitRequestController controller = new ListVisitRequestController();
    private Sort sortingAlgorithm;

    private Date visitDate;

    private static LocalDate begin;
    private LocalDate end;





        @Override
        public void run () {
            //requestAgentList();
            //visitListUnsorted();
            try {
                visitListSorted();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }

        /*private void visitListUnsorted () {

            controller.getUnsortedVisitRequestList( visitList, begin, end);
        }*/

        private void visitListSorted () throws IOException {
            Repositories.getInstance().getVisitRepository().getVisitList();
            System.out.println(controller.getSortedVisitRequestList());
        }


        /*private List<VisitRequest> requestAgentList () {
            return controller.AgentVisitRequest();
        }
*/
        /*private void configurationFile () {
            System.out.println(controller.getConfigurationFile());
        }*/

    }



