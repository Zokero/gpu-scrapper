package com.cpuscrp.scrapp.scrapp.page;

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
public class MorelePage implements Page {

    private final GpuFactory gpuFactory;
    private final Document document;

    public List<Gpu> getGpus() {
        List<Gpu> gpuList = new ArrayList<>();
        Elements productElements = getProductElements();
        for (Element productElement : productElements) {
            Elements featuresElement = getFeaturesFromProductElement(productElement);
            Elements productLinkElement = getProductLinkFromProductElement(productElement);
            Elements priceElement = getPriceFromProductLinkElement(productElement);
            createGpu(priceElement, featuresElement, productLinkElement).ifPresent(gpuList::add);
        }
        return gpuList;
    }

    private Optional<Gpu> createGpu(Elements priceElement, Elements featuresElement, Elements productLinkElement) {
        if (!featuresElement.isEmpty()) {
            String title = productLinkElement.attr("title");
            Optional<String> manufacturerName = getManufacturerFromTitle(title);
            Optional<String> model = getModelFromTitle(title);
            Optional<Double> price = getFormattedPrice(priceElement);
            if (manufacturerName.isPresent() && price.isPresent() && model.isPresent()) {
                String fullGpuName = getFullGpuName(featuresElement);
                String chipsetType = getChipsetTypeFromFullGpuName(fullGpuName);
                String chipsetName = getChipsetName(fullGpuName);
                String gpuLink = productLinkElement.attr("href");
                return gpuFactory.createGpu(chipsetName, chipsetType, price.get(), manufacturerName.get(), gpuLink, model.get());
            }
        }
        return Optional.empty();
    }

    private Optional<String> getModelFromTitle(String title) {
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(title);
            if (matcher.find()) {
                return Optional.of(matcher.group(1).trim());
            }
        return Optional.empty();
    }

    private Elements getProductLinkFromProductElement(Element element) {
        return element.select("a[class=productLink]");
    }

    private Elements getFeaturesFromProductElement(Element element) {
        return element.select("div[class=cat-product-feature]");
    }

    private Elements getProductElements() {
        return document.select("div[class=cat-product-inside]");
    }

    public int getNumberOfPages() {
        return Integer.parseInt(document.select("div[class=pagination-btn-nolink-anchor]").text());
    }

    private Optional<Double> getFormattedPrice(Elements elements) {
        return PriceFormatter.getPriceFromString(elements.get(0).text());
    }

    private Elements getPriceFromProductLinkElement(Element element) {
        return element.select("div[class=price-new]");
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

    private String getChipsetTypeFromFullGpuName(String fullGpuName) {
        return fullGpuName.substring(fullGpuName.indexOf(" ")).trim();
    }

}
