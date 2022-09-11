package com.example.demo.service;

import com.example.demo.repository.MacbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MacbookService {

    @Autowired
    private MacbookRepository macbookRepository;


}
