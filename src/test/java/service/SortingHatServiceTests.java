package service;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import main.java.service.SortingHatService ;

import static org.junit.jupiter.api.Assertions.*;

public class SortingHatServiceTests {

    @Test
    public void TC001_sortAndRegisterStudentSuccessfully() {
        try {
            SortingHatService sortingHatService = new SortingHatService(12);
            sortingHatService.sortAndRegisterStudent(1, "AV");
            sortingHatService.sortAndRegisterStudent(2, "AV");
            sortingHatService.sortAndRegisterStudent(3, "AV");
            sortingHatService.sortAndRegisterStudent(4, "BV");
            sortingHatService.sortAndRegisterStudent(5, "BV");
            sortingHatService.sortAndRegisterStudent(6, "BV");
            sortingHatService.sortAndRegisterStudent(7, "ANV");
            sortingHatService.sortAndRegisterStudent(8, "ANV");
            sortingHatService.sortAndRegisterStudent(9, "ANV");
            sortingHatService.sortAndRegisterStudent(10, "BNV");
            sortingHatService.sortAndRegisterStudent(11, "BNV");
            sortingHatService.sortAndRegisterStudent(12, "BNV");
            sortingHatService.sortAndRegisterStudent(13, "BV");

            assertEquals(3, sortingHatService.getStudentsForHostelType(HostelType.AV).size());
            assertEquals(3, sortingHatService.getStudentsForHostelType(HostelType.ANV).size());
            assertEquals(3, sortingHatService.getStudentsForHostelType(HostelType.BV).size());
            assertEquals(3, sortingHatService.getStudentsForHostelType(HostelType.BNV).size());
            assertEquals(1, sortingHatService.getStudentsForHostelType(HostelType.NA).size());
        } catch (CapacityException e) {
            e.printStackTrace();
        }
    }
}
