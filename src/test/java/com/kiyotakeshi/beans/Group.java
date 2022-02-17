package com.kiyotakeshi.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter(AccessLevel.NONE)
public class Group {

    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }
}
