package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.Land;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class LandRepositoryTest {
    @Test
    void getRoleByNameEmptyList(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        assertThrows(IllegalArgumentException.class, () -> propertyRepository.getPropertyByLocation(propertyLocation));
    }

    @Test
    void getRoleByNameNullList() {
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        assertThrows(IllegalArgumentException.class, () -> propertyRepository.getPropertyByLocation(propertyLocation));
    }

    @Test
    void ensureNewRoleSuccessfullyAdded(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);
    }

    @Test
    void ensureGetRoleForExistingRole(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);
        Property land1 = propertyRepository.getPropertyByLocation(propertyLocation);
        assertEquals(land, land1);
    }

    @Test
    void ensureGetRoleFailsForNonExistingRole(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);
        Location propertyLocation1 = new Location("Property Street1", "Property city1", "Property district1", "Property state1", 123456);
        assertThrows(IllegalArgumentException.class, () -> propertyRepository.getPropertyByLocation(propertyLocation1));
    }

    @Test
    void ensureGetRolesReturnsAnImmutableList(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);

        assertThrows(UnsupportedOperationException.class, () -> propertyRepository.getProperties().add(new Land(area, distance, photos)));
    }

    @Test
    void ensureGetRolesReturnsTheCorrectList(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);
        int expectedSize = 1;

        int size = propertyRepository.getProperties().size();

        assertEquals(expectedSize, size);
        assertEquals(land, propertyRepository.getProperties().get(size - 1));
    }

    @Test
    void ensureAddingDuplicateRoleFails(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Land land = new Land(area, distance, photos);
        propertyRepository.add(land);

        Optional<Property> duplicateProperty = propertyRepository.add(land);

        assertTrue(duplicateProperty.isEmpty());
    }

    @Test
    void ensureAddingDifferentRolesWorks(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Land land = new Land(area, distance, photos);
        Land land1 = new Land(area, distance, photos);
        propertyRepository.add(land);

        Optional<Property> result = propertyRepository.add(land1);

        assertEquals(land1, result.get());
    }
}