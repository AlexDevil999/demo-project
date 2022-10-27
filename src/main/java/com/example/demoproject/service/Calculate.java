package com.example.demoproject.service;



import com.example.demoproject.exception.ElementException;

import java.util.List;

public interface Calculate {
    int getVolume(List<Integer> datas) throws ElementException;
}
