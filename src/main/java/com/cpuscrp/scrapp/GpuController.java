package com.cpuscrp.scrapp;


import com.cpuscrp.scrapp.db.GpuRepository;
import com.cpuscrp.scrapp.model.Gpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:8080")
public class GpuController {
    @Autowired
    GpuRepository gpuRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("gpus")
    public List<Gpu> getAllGpus() {
        return gpuRepository.findAll();
    }

}
