package com.kiyotakeshi.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter(AccessLevel.NONE)
public class Course {
    @ToString.Include(rank = 100)
    private final String name;

    @ToString.Exclude
    private final String category;

    @ToString.Include(rank = 98)
    private final int reviewScore;

    @ToString.Include(rank = 99)
    private final int numberOfStudents;
}
