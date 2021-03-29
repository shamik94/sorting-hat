package main.java.service;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;
import main.java.model.Hostel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingHatService {

    private Hostel hostel;

    public SortingHatService (Integer capacity) throws CapacityException {
        hostel = Hostel.getInstance(capacity);
    }

    public void sortAndRegisterStudent(Integer rollNumber, String HostelTypeString) {
        if (hostel.isRegistered(rollNumber)) {
            System.out.println("Student is already registered: " + rollNumber);
            return;
        }

        HostelType hostelType = hostelTypeMapper(HostelTypeString);

        if (hostel.isHostelFullForType(hostelType)) {
            System.out.println(hostelType.name() + " Hostel is full. Can not register " + rollNumber);
            hostelType = HostelType.NA;
        }
        hostel.register(rollNumber, hostelType);
    }

    public List<Integer> getStudentsForHostelType(HostelType hostelType) {
        return hostel
                .getStudents()
                .entrySet()
                .stream()
                .filter(student -> student.getValue().equals(hostelType))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private HostelType hostelTypeMapper (String hostelTypeString) {
        return HostelType.valueOf(hostelTypeString);
    }
}
