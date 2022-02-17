package com.kiyotakeshi.examples.mockdata;


import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.kiyotakeshi.examples.beans.Car;
import com.kiyotakeshi.examples.beans.Person;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SampleData {

    public static List<Person> getPersons() throws IOException {
        InputStream inputStream = Resources.getResource("persons.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Person>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Car> getCars() throws IOException {
        InputStream inputStream = Resources.getResource("cars.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Car>>() {
        }.getType();
        return new Gson().fromJson(json, listType);
    }
}
