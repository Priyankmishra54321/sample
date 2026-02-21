package com.logic;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HelpService implements IntfHelpService{


    @Override
    public List<Integer> getHelpNumbers() {
        return List.of(432432,432414,4124321);
    }
}
