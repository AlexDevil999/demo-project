package com.example.demoproject;

import com.example.demoproject.exception.ElementException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demoproject.service.CalculateCapacityWater;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DemoProjectApplicationTests {

    @Test
    void testElements() throws ElementException {

        List<Integer> elements = new ArrayList<>();

        elements.add(5);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(4);
        elements.add(0);
        elements.add(3);
        elements.add(1);

        int res = new CalculateCapacityWater().getVolume(elements);

        assertEquals(9, res);
    }

    @Test
    void testElement() throws ElementException {

        List<Integer> elements = new ArrayList<>();

        elements.add(1);


        int res = new CalculateCapacityWater().getVolume(elements);

        assertEquals(0, res);
    }

    @Test
    void testZeroElement() throws ElementException {

        List<Integer> elements = new ArrayList<>();

        elements.add(0);
        elements.add(0);
        elements.add(0);


        int res = new CalculateCapacityWater().getVolume(elements);

        assertEquals(0, res);
    }

    @Test
    void testWithException() {

        List<Integer> elements = new ArrayList<>();

        elements.add(4);
        elements.add(5);
        elements.add(90000);
        elements.add(8);


        assertThrows(ElementException.class, () -> new CalculateCapacityWater().getVolume(elements));
    }
}
