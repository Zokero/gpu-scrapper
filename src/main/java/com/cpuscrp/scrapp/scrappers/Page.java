package com.cpuscrp.scrapp.scrappers;

import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.model.PriceFormatter;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
final class Page {

    private final Document document;
    private final GpuFactory gpuFactory;
    private final PriceFormatter priceFormatter;

    public List<Gpu> getGpus() {
        List<Gpu> gpuList = new ArrayList<>();
        Elements pageElements = document.select("div[class=cat-product-inside]");
        for (Element element : pageElements) {
            Elements features = element.select("div[class=cat-product-feature]");
            Elements productLink = element.select("a[class=productLink]");
            createGpu(element, features, productLink).ifPresent(gpuList::add);
        }
        return gpuList;
    }

    public int getNumberOfPages() {
        return Integer.parseInt(document.select("div[class=pagination-btn-nolink-anchor]").text());
    }

    //Move it to GpuFactory
    private Optional<Gpu> createGpu(Element element, Elements features, Elements productLink) {
        if (!features.isEmpty()) {
            String title = productLink.attr("title");
            Optional<String> manufacturerName = getManufacturerFromTitle(title);
            Optional<Double> price = priceFormatter.getPriceFromString(getRawPrice(element));
            if (manufacturerName.isPresent() && price.isPresent()) {
                String fullGpuName = getFullGpuName(features);
                String model = getModelFromFullGpuName(fullGpuName);
                String chipsetName = getChipsetName(fullGpuName);
                String gpuLink = productLink.attr("href");
                return gpuFactory.createGpu(chipsetName, model, price.get(), manufacturerName.get(), gpuLink);
            }
        }
        return Optional.empty();
    }

    private String getRawPrice(Element element) {
        return element.select("div[class=price-new]").get(0).text();
    }

    private Optional<String> getManufacturerFromTitle(String title) {
        boolean isTitleValid = title.contains("Karta graficzna");
        if (isTitleValid) {
            Pattern pattern = Pattern.compile("(?<=graficzna)\\s+(.*?)\\s+(?=(GeForce|Radeon))");
            Matcher matcher = pattern.matcher(title);
            if (matcher.find()) {
                return Optional.of(matcher.group(1).trim());
            }
        }
        return Optional.empty();
    }

    private String getChipsetName(String fullGpuName) {
        return fullGpuName.split(" ")[0];
    }

    private String getFullGpuName(Elements features) {
        return features.get(2).attr("title");
    }

    private String getModelFromFullGpuName(String fullGpuName) {
        return fullGpuName.substring(fullGpuName.indexOf(" ")).trim();
    }

}
