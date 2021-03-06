package main.java.model;

import main.java.enums.HostelType;
import main.java.exception.CapacityException;

import java.util.HashMap;
import java.util.Map;

public class Hostel {

    private Map<Integer, HostelType> students;
    private static Hostel obj;
    private int AVCount, BVCount, ANVCount, BNVCount;

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
        decreaseCount(hostelType);
        System.out.println("Student is successfully registered: " + rollNumber);
    }

    public void deRegister (Integer rollNumber) {
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            System.out.println("Student is successfully deRegistered: " + rollNumber);
        }
        System.out.println("Student is not registered, hence can not deregister: " + rollNumber);
    }

    public boolean isRegistered (Integer rollNumber) {
        return students.containsKey(rollNumber);
    }

    private void decreaseCount(HostelType hostelType) {
        switch (hostelType) {
            case AV:
                AVCount--;
                break;
            case BV:
                BVCount--;
                break;
            case ANV:
                ANVCount--;
                break;
            case BNV:
                BNVCount--;
                break;
        }
    }

    public boolean isHostelFullForType(HostelType hostelType) {
        switch (hostelType) {
            case AV:
                return AVCount <= 0;
            case BV:
                return BVCount <= 0;
            case ANV:
                return ANVCount <= 0;
            case BNV:
                return BNVCount <= 0;
            default:
                return false;
        }
    }

    public Map<Integer, HostelType> getStudents() {
        return students;
    }

    public void setStudents(Map<Integer, HostelType> students) {
        this.students = students;
    }

    public int getAVCount() {
        return AVCount;
    }

    public void setAVCount(int AVCount) {
        this.AVCount = AVCount;
    }

    public int getBVCount() {
        return BVCount;
    }

    public void setBVCount(int BVCount) {
        this.BVCount = BVCount;
    }

    public int getANVCount() {
        return ANVCount;
    }

    public void setANVCount(int ANVCount) {
        this.ANVCount = ANVCount;
    }

    public int getBNVCount() {
        return BNVCount;
    }

    public void setBNVCount(int BNVCount) {
        this.BNVCount = BNVCount;
    }
}
