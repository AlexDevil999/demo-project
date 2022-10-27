package com.example.demoproject.service;

import com.example.demoproject.exception.ElementException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.min;

@Service
public class CalculateCapacityWater implements Calculate{

    private static int low = 0;
    private static int high = 32_000;

    @Override
    public int getVolume(List<Integer> datas) throws ElementException {
        //1 step validate data's
        validateData(datas);

        //2 get result
        return getCapacityWater(datas);
    }

    private void validateData(List<Integer> data) throws ElementException {
        if(data.isEmpty()){
            throw new ElementException("array size equals null!");
        } else if(data.size() > high){
            throw new ElementException("array size exceeds limit!");
        }

        for (Integer el : data){
            if(el > high || el < low){
                throw new ElementException("valid value from 0 to 32000");
            }
        }
    }

    private int getCapacityWater(List<Integer> datas){
        int[] leftValues = new int[datas.size()];
        int[] rightValues = new int[datas.size()];

        int amount = 0;
        int startLeftElement = datas.get(0);
        int startRightElement = datas.get(datas.size() - 1);

        for (int i = 0; i < datas.size(); i++) {
            if (startLeftElement < datas.get(i)) {
                leftValues[i] = datas.get(i);
                startLeftElement = datas.get(i);
            } else {
                leftValues[i] = startLeftElement;
            }
            final int j = datas.size() - i - 1;
            if (startRightElement < datas.get(j)) {
                rightValues[j] = datas.get(j);
                startRightElement = datas.get(j);
            } else {
                rightValues[j] = startRightElement;
            }
        }

        for (int i = 0; i < datas.size(); i++) {
            amount += min(leftValues[i], rightValues[i]) - datas.get(i);
        }
        return amount;
    }
}
