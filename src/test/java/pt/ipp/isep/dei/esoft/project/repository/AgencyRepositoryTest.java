package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Agency;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AgencyRepositoryTest {

    @Test
    void getAgencyByIDEmptyList(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        assertThrows(IllegalArgumentException.class, () -> agencyRepository.getAgencyByID(agencyID));
    }

    @Test
    void getAgencyByIDNullList() {
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        assertThrows(IllegalArgumentException.class, () -> agencyRepository.getAgencyByID(agencyID));
    }

  /*  @Test
    void ensureNewAgencySuccessfullyAdded(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        Agency agency = new Agency(agencyID, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);
    }

    @Test
    void ensureGetAgencyForExistingAgency(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        Agency agency = new Agency(agencyID, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);
        Agency agency1 = agencyRepository.getAgencyByID(agencyID);
        assertEquals(agency, agency1);
    }

    @Test
    void ensureGetAgencyFailsForNonExistingAgency(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        Agency agency = new Agency(agencyID, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);
        int agencyID1 = 1234;
        assertThrows(IllegalArgumentException.class, () -> agencyRepository.getAgencyByID(agencyID1));
    }

    @Test
    void ensureGetAgenciesReturnsAnImmutableList(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        Agency agency = new Agency(agencyID, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);

        assertThrows(UnsupportedOperationException.class, () -> agencyRepository.getAgencies().add(new Agency(1234, "Agency Name", "Power Street, F")));
    }

    @Test
    void ensureGetAgenciesReturnsTheCorrectList(){
        AgencyRepository agencyRepository = new AgencyRepository();
        int agencyID = 123;
        Agency agency = new Agency(agencyID, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);
        int expectedSize = 1;

        int size = agencyRepository.getAgencies().size();

        assertEquals(expectedSize, size);
        assertEquals(agency, agencyRepository.getAgencies().get(size - 1));
    }

    @Test
    void ensureAddingDuplicateAgencyFails(){
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency(123, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);

        Optional<Agency> duplicateAgency = agencyRepository.add(agency);

        assertTrue(duplicateAgency.isEmpty());
    }

    @Test
    void ensureAddingDifferentAgenciesWorks(){
        AgencyRepository agencyRepository = new AgencyRepository();
        Agency agency = new Agency(123, "Agency Name", "Power Street, F");
        Agency agency1 = new Agency(1234, "Agency Name", "Power Street, F");
        agencyRepository.add(agency);

        Optional<Agency> result = agencyRepository.add(agency1);

        assertEquals(agency1, result.get());
    }

   */
}