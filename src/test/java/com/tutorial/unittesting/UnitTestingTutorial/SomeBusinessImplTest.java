package com.tutorial.unittesting.UnitTestingTutorial;

import com.tutorial.unittesting.service.SomeBusinessService;
import com.tutorial.unittesting.service.SomeDataService;
import com.tutorial.unittesting.service.impl.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

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
        // Mocking the data service class
        SomeDataService dataServiceMock = mock(SomeDataService.class);
        // mocking the retrieveSomeData method alone
        when(dataServiceMock.retrieveSomeData()).thenReturn(new int[]{1,2,3});

        int actualResult = someBusinessService.calculateSum(new int[]{});
        int expectedResult =0;
        assertEquals(expectedResult,actualResult);
    }
}
