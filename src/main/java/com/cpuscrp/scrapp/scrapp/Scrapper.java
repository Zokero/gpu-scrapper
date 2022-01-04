package com.cpuscrp.scrapp.scrapp;

import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.model.GpuFactory;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Slf4j
abstract class Scrapper {

    @Autowired
    GpuFactory gpuFactory;

    abstract List<Gpu> getGpuList();

    Optional<Document> getDocument(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return Optional.of(document);
        } catch (IOException e) {
            log.error("Cannot get document from Morele link: " + url);
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
