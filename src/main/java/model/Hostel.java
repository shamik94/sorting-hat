package main.java.model;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;

import java.util.HashMap;
import java.util.Map;

public class Hostel {

    private Map<Integer, HostelType> students;
    private static Hostel obj;
    private final int AVCount, BVCount, ANVCount, BNVCount;

    public static Hostel getInstance(Integer capacity) throws CapacityException {
        if (obj==null)
            obj = new Hostel(capacity);
        return obj;
    }

    private Hostel (Integer capacity) throws CapacityException {
        if (capacity%4 != 0) {
            throw new CapacityException("Total Capacity should be divisible by 4");
        }
        students = new HashMap<>();
        AVCount = capacity/4;
        BVCount = capacity/4;
        ANVCount = capacity/4;
        BNVCount = capacity/4;
    }

    public void register (Integer rollNumber, HostelType hostelType) {
        students.put(rollNumber, hostelType);
        System.out.println("Student is successfully registered: " + rollNumber);
    }

    public boolean isRegistered (Integer rollNumber) {
        return students.containsKey(rollNumber);
    }

    public boolean isHostelFullForType(HostelType hostelType) {
        switch (hostelType) {
            case AV:
                return AVCount == 0;
            case BV:
                return BVCount == 0;
            case ANV:
                return ANVCount == 0;
            case BNV:
                return BNVCount == 0;
            default:
                return false;
        }
    }

    public Map<Integer, HostelType> getStudents() {
        return students;
    }
}
