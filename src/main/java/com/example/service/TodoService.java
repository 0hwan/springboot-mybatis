package com.example.service;

import com.example.repository.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TodoService {
    @Autowired
    private TodoMapper todoMapper;

    public String getCurrentDataTime() {
        return todoMapper.getCurrentDataTime();
    }
}
