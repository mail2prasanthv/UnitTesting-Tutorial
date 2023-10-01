package com.tutorial.unittesting;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl implements SomeBusinessService {



    @Override
    public int calculateSum(int[] data) {
        int sum = 0;

        for (int datum : data) {
            sum = sum + datum;
        }
        return sum;
    }
}
