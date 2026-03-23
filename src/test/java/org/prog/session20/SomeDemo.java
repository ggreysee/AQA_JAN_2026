package org.prog.session20;

import org.prog.session9.Car;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SomeDemo {

    @Test
    public void test() {
        List<String> demoList = new ArrayList<>();
        demoList.add("hello");
        demoList.add("hello");
        demoList.add("hello");
        demoList.add("world");
        demoList.add("asdoasildg");
        demoList.add("asdoasildgapsd");
        demoList.add("as");
        List<Car> carList = demoList.stream().map(Car::new).toList();
        System.out.println(demoList.stream()
                .filter(s -> s.contains("a"))
                .collect(Collectors.joining(" <--> ")));
        System.out.println(demoList.stream().anyMatch(s -> s.contains("a")));

    }
}
