package com.tutorial.unittesting.service.impl;

import com.tutorial.unittesting.service.SomeDataService;
import org.springframework.stereotype.Service;

@Service
public class SomeDataServiceImpl implements SomeDataService {
    @Override
    public int[] retrieveSomeData() {
        return new int[]{0,1,2,3,4};
    }
}
