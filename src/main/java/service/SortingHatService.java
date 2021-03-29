package main.java.service;

import main.java.exception.CapacityException;

public class SortingHatService {

    private int AVCount, BVCount, ANVCount, BNVCount, capacity;

    public SortingHatService(Integer capacity) throws CapacityException {
        if (capacity%4 != 0) {
            throw new CapacityException("Total Capacity should be divisible by 4");
        }
        this.capacity = capacity;
        AVCount = capacity/4;
        BVCount = capacity/4;
        ANVCount = capacity/4;
        BNVCount = capacity/4;
    }

    public void registerStudent(Integer rollNumber, String HostelType) {

    }
}
