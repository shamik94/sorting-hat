package main.java.service;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;
import main.java.model.Hostel;

public class SortingHatService {

    private final int AVCount, BVCount, ANVCount, BNVCount;

    public SortingHatService (Integer capacity) throws CapacityException {
        if (capacity%4 != 0) {
            throw new CapacityException("Total Capacity should be divisible by 4");
        }
        AVCount = capacity/4;
        BVCount = capacity/4;
        ANVCount = capacity/4;
        BNVCount = capacity/4;
    }

    public void registerStudent(Integer rollNumber, String HostelTypeString) {
        Hostel hostel = Hostel.getInstance();
        if (hostel.isRegistered(rollNumber)) {
            System.out.println("Student is already registered: " + rollNumber);
            return;
        }
        HostelType hostelType = hostelTypeMapper(HostelTypeString);
        if (isHostelFullForType(hostelType)) {
            System.out.println(hostelType.name() + " Hostel is full. Can not register " + rollNumber);
            hostelType = HostelType.NA;
        }
        hostel.register(rollNumber, hostelType);
    }

    private boolean isHostelFullForType(HostelType hostelType) {
        switch (hostelType) {
            case AV:
                return AVCount > 0;
            case BV:
                return BVCount > 0;
            case ANV:
                return ANVCount > 0;
            case BNV:
                return BNVCount > 0;
            default:
                return false;
        }
    }

    private HostelType hostelTypeMapper (String hostelTypeString) {
        return HostelType.valueOf(hostelTypeString);
    }
}
