package com.tutorial.unittesting.service.impl;

import com.tutorial.unittesting.service.SomeBusinessService;
import com.tutorial.unittesting.service.SomeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl implements SomeBusinessService {

    @Autowired
    SomeDataService dataService;

    @Override
    public int calculateSum(int[] data) {
        int sum = 0;

        for (int datum : data) {
            sum = sum + datum;
        }
        return sum;
    }
    @Override
    public int calculateSumUsingDataService() {
        int[] data = dataService.retrieveSomeData();
        int sum = 0;
        for (int datum : data) {
            sum = sum + datum;
        }
        return sum;
    }
}
