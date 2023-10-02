package com.tutorial.unittesting.UnitTestingTutorial;

import com.tutorial.unittesting.service.SomeBusinessService;
import com.tutorial.unittesting.service.SomeDataService;
import com.tutorial.unittesting.service.impl.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplTest {

//    @InjectMocks creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
    @InjectMocks
    SomeBusinessImpl someBusinessService ;

    @Mock //-  annotation to inject a mock for an instance variable
    SomeDataService dataServiceMock;

     @Test
    public void calculateSumTestBasic() {
        SomeBusinessService someBusinessService = new SomeBusinessImpl();
        int actualResult = someBusinessService.calculateSum(new int[]{1, 2, 3});
        int expectedResult =6;
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void calculateSumTest() {

        when(dataServiceMock.retrieveSomeData()).thenReturn(new int[]{1,2,3});

        int actualResult = someBusinessService.calculateSumUsingDataService();
        assertEquals(6,actualResult);
    }
    @Test
    public void calculateSumTestEmpty() {

        when(dataServiceMock.retrieveSomeData()).thenReturn(new int[]{});

        int actualResult = someBusinessService.calculateSumUsingDataService();
        assertEquals(0,actualResult);
    }
}
