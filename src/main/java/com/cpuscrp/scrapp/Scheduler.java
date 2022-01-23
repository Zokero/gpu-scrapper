package com.cpuscrp.scrapp;


import com.cpuscrp.scrapp.db.GpuRepository;
import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.scrapp.MoreleScrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class Scheduler {

    @Autowired
    private MoreleScrapper moreleScrapper;
    @Autowired
    private GpuRepository mongoRepository;

    @Scheduled(fixedRate = 10000)
    public void scrappServices() {
        List<Gpu> gpuList = moreleScrapper.getGpuList();
        for (Gpu gpu : gpuList) {
            mongoRepository.updateIfDocumentExists(gpu);
        }
    }

}
