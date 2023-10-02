package com.tutorial.unittesting.UnitTestingTutorial;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {

    List<String> mockList = mock(List.class);

    @Test
    public void testListSize() {

        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void testListSizeMultipleReturns() {

        when(mockList.size()).thenReturn(5).thenReturn(10); //first time reurn 5, then 10
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    public void returnWithParameters() {
        when(mockList.get(0)).thenReturn("Arg1");
        assertEquals("Arg1", mockList.get(0));
    }

    @Test
    public void returnWithGenericParameters() {
        when(mockList.get(anyInt())).thenReturn("Arg1");
        assertEquals("Arg1", mockList.get(0));
        assertEquals("Arg1", mockList.get(1));
        assertEquals("Arg1", mockList.get(10));
        assertEquals("Arg1", mockList.get(100));
    }
    @Test
    public void verificationOfMethodInvocation() {

        String value = mockList.get(0);

        verify(mockList).get(0);// tests get method had called one time.
        verify(mockList).get(anyInt());// tests get method had called one time.
        verify(mockList, times(1)).get(anyInt());// tests get method had called one time.
        verify(mockList, never()).get(1);// tests get method never called with argument1
//        verify(mockList, atLeast(1)).get(1);// tests get method  called with argument 1 atleast 1 time
    }

    @Test
    public void argumentCapture() {
        mockList.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(captor.capture());

        assertEquals("SomeString", captor.getValue());
    }

    @Test
    public void multipleArgumentCapture() {
        mockList.add("SomeString");
        mockList.add("SomeString");

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());

        assertEquals("SomeString", captor.getAllValues().get(0));
        assertEquals("SomeString", captor.getAllValues().get(1));
    }

    //Mocking vs Spying
    @Test
    public void mocking() {
        ArrayList mockArrayList = mock(ArrayList.class);

        System.out.println(mockArrayList.get(0));//null
        System.out.println(mockArrayList.size());//0
        mockArrayList.add("SomeString");//Adding elements
        mockArrayList.add("SomeString");
        mockArrayList.add("SomeString");
        System.out.println(mockArrayList.get(0));// still null value
        System.out.println(mockArrayList.size());//still size zero
        //the functionality of arraylist is suppressed.
    }

    @Test
    public void spying() {
        ArrayList mockArrayList = spy(ArrayList.class);

        System.out.println(mockArrayList.size());//0
        mockArrayList.add("SomeString");//Adding elements
        mockArrayList.add("SomeString");
        mockArrayList.add("SomeString");
        System.out.println(mockArrayList.size());// size Three
        //the functionality of arraylist is restored and can be overriden.
        when(mockArrayList.size()).thenReturn(1000);//overriding original functionality
        System.out.println(mockArrayList.size());// size 1000
    }


}
