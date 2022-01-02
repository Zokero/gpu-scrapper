package com.cpuscrp.scrapp.scrappers;

import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.model.PriceFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoreleScrapper implements Scrapper {

    private static final String URL = "https://www.morele.net/kategoria/karty-graficzne-12/";

    private final GpuFactory gpuFactory;
    private final PriceFormatter priceFormatter;

    @Override
    public List<Gpu> getGpuList() {
        Optional<Page> pageOptional = getDocument(URL);
        List<Gpu> gpus = new ArrayList<>();
        if (pageOptional.isPresent()) {
            Page page = pageOptional.get();
            for (int i = 0; i < page.getNumberOfPages(); i++) {
                pageOptional = getDocument(URL + ",,,,,,,,0,,,,/" + i + "/");
                pageOptional.ifPresent(pageIteration -> gpus.addAll(pageIteration.getGpus()));
            }
        }
        return gpus;
    }

    private Optional<Page> getDocument(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            return Optional.of(new Page(document, gpuFactory, priceFormatter));
        } catch (IOException e) {
            log.error("Cannot get document from Morele link: " + url);
            e.printStackTrace();
        }
        return Optional.empty();
    }
    
}
