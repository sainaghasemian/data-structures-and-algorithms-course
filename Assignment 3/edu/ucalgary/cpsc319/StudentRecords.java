//@author Saina Ghasemian-Roudsari
//UCID:30113011
package edu.ucalgary.cpsc319;

import java.io.*;
import java.util.*;

public class StudentRecords {
    public StudentRecords() {
    }

    private String value = "";
    private String studentLastName = "";

    public String getRecord() {
        return this.value;
    }
    public String findStudentLast() {
        return this.studentLastName;
    }
    public void setUpRecords(String value) {
        this.value = value;
    }
    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }
}