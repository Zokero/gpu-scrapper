package com.cpuscrp.scrapp.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class GpuFactory {

    public Optional<Gpu> createGpu(String chipsetName, String chipsetType, double price, String manufacturerName, String productLink, String model) {
        Gpu gpu = new Gpu();
        gpu.setChipset(chipsetName);
        gpu.setChipsetType(chipsetType);
        gpu.setPrice(price);
        gpu.setManufacturer(manufacturerName);
        gpu.setLink(productLink);
        gpu.setModel(model);
        return Optional.of(gpu);
    }

}
