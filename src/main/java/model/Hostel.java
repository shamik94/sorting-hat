package main.java.model;

import main.java.enums.HostelType;

import java.util.HashMap;
import java.util.Map;

public class Hostel {

    private Map<Integer, HostelType> students;
    private static Hostel obj;

    public static Hostel getInstance()
    {
        if (obj==null)
            obj = new Hostel();
        return obj;
    }

    private Hostel () {
        students = new HashMap<>();
    }

    public void register(Integer rollNumber, HostelType hostelType) {
        if (students.containsKey(rollNumber)) {
            System.out.println( "Student is already registered: " + rollNumber);
            return;
        }
        students.put(rollNumber, hostelType);
        System.out.println( "Student is successfully registered: " + rollNumber);
    }
}
