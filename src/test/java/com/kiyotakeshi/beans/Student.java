package com.kiyotakeshi.beans;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class Student {
    private final String name;
    private final int score;
}
