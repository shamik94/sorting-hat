package model;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import main.java.model.Hostel;

import static org.junit.jupiter.api.Assertions.*;


public class HostelTests {

    @Test
    @Order(1)
    public void TC001_isHostelFullReturnsFalse() {
        try {
            Hostel hostel = Hostel.getInstance(12);
            assertFalse(hostel.isHostelFullForType(HostelType.AV));
            assertFalse(hostel.isHostelFullForType(HostelType.BV));
            assertFalse(hostel.isHostelFullForType(HostelType.ANV));
            assertFalse(hostel.isHostelFullForType(HostelType.BNV));
        } catch (CapacityException e) {
            e.printStackTrace();
        }
    }
}
