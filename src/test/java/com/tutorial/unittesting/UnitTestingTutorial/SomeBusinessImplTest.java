package com.tutorial.unittesting.UnitTestingTutorial;

import com.tutorial.unittesting.SomeBusinessImpl;
import com.tutorial.unittesting.SomeBusinessService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplTest {


    @Test
    public void calculateSumTestBasic() {
        SomeBusinessService someBusinessService = new SomeBusinessImpl();
        int actualResult = someBusinessService.calculateSum(new int[]{1, 2, 3});
        int expectedResult =6;
        assertEquals(expectedResult,actualResult);
    }

    public void calculateSumTestEmpty() {
        SomeBusinessService someBusinessService = new SomeBusinessImpl();
        int actualResult = someBusinessService.calculateSum(new int[]{});
        int expectedResult =0;
        assertEquals(expectedResult,actualResult);
    }
}
