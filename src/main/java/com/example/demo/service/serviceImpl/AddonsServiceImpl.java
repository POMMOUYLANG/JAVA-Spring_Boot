package com.example.demo.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Addons;
import com.example.demo.repository.AddonsRepository;
import com.example.demo.service.AddonsService;

@Service
public class AddonsServiceImpl implements AddonsService {
    private AddonsRepository addonsRepository;

    public AddonsServiceImpl(AddonsRepository addonsRepository) {
        super();
        this.addonsRepository = addonsRepository;
    }

    @Override
    public Addons getCream() {
        return addonsRepository.findByName("cream");
    }

    @Override
    public List<Addons> getSugar() {
        return addonsRepository.findMultipleByName("sugar");
    }
    
}
