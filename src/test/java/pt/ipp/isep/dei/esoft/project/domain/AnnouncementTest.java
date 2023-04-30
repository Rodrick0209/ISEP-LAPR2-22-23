package pt.ipp.isep.dei.esoft.project.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnnouncementTest {

    @Test
    void ensureCreateAnnouncementWorks(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
    }

    @Test
    void testEqualsSameObject(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        assertEquals(announcement, announcement);
    }

    @Test
    void testEqualsDifferentClass(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        assertNotEquals(announcement, new Object());
    }

    @Test
    void testEqualsNull(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        assertNotEquals(announcement, null);
    }

    @Test
    void testEqualsDifferentObject(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        Announcement announcement1 = new Announcement(property, "Announcement description1", 12345, agent);
        assertNotEquals(announcement, announcement1);
    }

    @Test
    void testEqualsSameObjectDifferentDescription(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        Announcement announcement1 = new Announcement(property, "Announcement description1", 1234, agent);
        assertNotEquals(announcement, announcement1);
    }

    @Test
    void testEqualsSameObjectSameDescription(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        Announcement announcement1 = new Announcement(property, "Announcement description", 1234, agent);
        assertEquals(announcement, announcement1);
    }

    @Test
    void testHashCodeSameObject(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        assertEquals(announcement.hashCode(), announcement.hashCode());
    }

    @Test
    void testHashCodeDifferentObject(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        Announcement announcement1 = new Announcement(property, "Announcement description1", 12345, agent);
        assertNotEquals(announcement.hashCode(), announcement1.hashCode());
    }
    @Test
    void ensureCloneWorks(){
        Employee agent = new Employee("agent@this.app");
        List<String> photos = new ArrayList<>();
        photos.add("abc");
        Location location = new Location("Property Street", "Property city", "Property district", "Property state", 12345);
        Property property = new Property(123, location, 12, photos);

        Announcement announcement = new Announcement(property, "Announcement description", 1234, agent);
        Announcement clone = announcement.clone();
        assertEquals(announcement, clone);
    }
}