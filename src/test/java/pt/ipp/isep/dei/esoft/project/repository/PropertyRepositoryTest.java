package pt.ipp.isep.dei.esoft.project.repository;

import org.junit.jupiter.api.Test;
import pt.ipp.isep.dei.esoft.project.domain.Location;
import pt.ipp.isep.dei.esoft.project.domain.Property;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PropertyRepositoryTest {
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
        Property property = new Property(propertyLocation);
        propertyRepository.add(property);
    }

    @Test
    void ensureGetRoleForExistingRole(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(propertyLocation);
        propertyRepository.add(property);
        Property property1 = propertyRepository.getPropertyByLocation(propertyLocation);
        assertEquals(property, property1);
    }

    @Test
    void ensureGetRoleFailsForNonExistingRole(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(propertyLocation);
        propertyRepository.add(property);
        Location propertyLocation1 = new Location("Property Street1", "Property city1", "Property district1", "Property state1", 123456);
        assertThrows(IllegalArgumentException.class, () -> propertyRepository.getPropertyByLocation(propertyLocation1));
    }

    @Test
    void ensureGetRolesReturnsAnImmutableList(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(propertyLocation);
        propertyRepository.add(property);

        assertThrows(UnsupportedOperationException.class, () -> propertyRepository.getProperties().add(new Property(new Location("Property Street1", "Property city1", "Property district1", "Property state1", 123456))));
    }

    @Test
    void ensureGetRolesReturnsTheCorrectList(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Location propertyLocation = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(propertyLocation);
        propertyRepository.add(property);
        int expectedSize = 1;

        int size = propertyRepository.getProperties().size();

        assertEquals(expectedSize, size);
        assertEquals(property, propertyRepository.getProperties().get(size - 1));
    }

    @Test
    void ensureAddingDuplicateRoleFails(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Property property = new Property(new Location("Property Street", "Property city", "Property district", "Property state", 12345));
        propertyRepository.add(property);

        Optional<Property> duplicateProperty = propertyRepository.add(property);

        assertTrue(duplicateProperty.isEmpty());
    }

    @Test
    void ensureAddingDifferentRolesWorks(){
        PropertyRepository propertyRepository = new PropertyRepository();
        Property property = new Property(new Location("Property Street", "Property city", "Property district", "Property state", 12345));
        Property property1 = new Property(new Location("Property Street1", "Property city1", "Property district1", "Property state1", 123456));
        propertyRepository.add(property);

        Optional<Property> result = propertyRepository.add(property1);

        assertEquals(property1, result.get());
    }
}