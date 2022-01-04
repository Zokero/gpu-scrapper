package com.cpuscrp.scrapp.scrapp;

import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.scrapp.page.MorelePage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoreleScrapper extends Scrapper {

    @Autowired
    GpuFactory gpuFactory;

    private static final String URL = "https://www.morele.net/kategoria/karty-graficzne-12/";

    @Override
    public List<Gpu> getGpuList() {
        Optional<Document> documentForFetchPagesAmount = getDocument(URL);
        List<Gpu> gpus = new ArrayList<>();
        if (documentForFetchPagesAmount.isPresent()) {
            MorelePage page = new MorelePage(gpuFactory, documentForFetchPagesAmount.get());
            populateGpuList(page.getNumberOfPages(), gpus);
        }
        return gpus;
    }

    private void populateGpuList(int numberOfPages, List<Gpu> gpus) {
        Optional<Document> document;
        for (int i = 0; i < numberOfPages; i++) {
            document = getDocument(URL + ",,,,,,,,0,,,,/" + i + "/");
            document.ifPresent(value -> gpus.addAll(new MorelePage(gpuFactory, value).getGpus()));
        }
    }

}
