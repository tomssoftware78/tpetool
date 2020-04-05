package be.pvgroup.tpetool.util.property;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParametersTheftPropertyTest {

    @Test
    public void testParametersProperty() {
        for (int i = 1000; i < 9999; i++) {
            System.out.println("" + i + ": " + ParametersTheftProperty.postCodeClass(String.valueOf(i)));
        }
    }

}