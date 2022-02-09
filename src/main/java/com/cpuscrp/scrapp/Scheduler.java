package com.cpuscrp.scrapp;


import com.cpuscrp.scrapp.db.GpuRepository;
import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.scrapp.MoreleScrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
class Scheduler {

    AtomicLong moreleRecordsModified = new AtomicLong(0L);
    @Autowired
    private MoreleScrapper moreleScrapper;
    @Autowired
    private GpuRepository mongoRepository;

    @Scheduled(fixedRate = 20000)
    public void scrappServices() {
        List<Gpu> gpuList = moreleScrapper.getGpuList();
        log.info("Scrapped " + gpuList.size() + " gpus from Morele");
        for (Gpu gpu : gpuList) {
            moreleRecordsModified.addAndGet(mongoRepository.updateIfDocumentExists(gpu));
        }
        log.info("Morele scrapper found " + moreleRecordsModified.getAndSet(0L) + " new changes");
    }

}
