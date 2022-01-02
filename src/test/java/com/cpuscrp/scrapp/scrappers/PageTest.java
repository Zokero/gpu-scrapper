package com.cpuscrp.scrapp.scrappers;

import com.cpuscrp.scrapp.model.Gpu;
import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.model.PriceFormatter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PageTest {

    @Mock
    Document document;

    @Mock
    GpuFactory factory;

    @Mock
    PriceFormatter priceFormatter;

    @Test
    void shouldGetNumberOfPages() {
        Page page = new Page(document, factory, priceFormatter);
        Elements element = mock(Elements.class);
        when(document.select("div[class=pagination-btn-nolink-anchor]")).thenReturn(element);
        when(element.text()).thenReturn("5");

        assertEquals(5, page.getNumberOfPages());
    }

    @Test
    void shouldGetGpus() {
        Page page = new Page(document, factory, priceFormatter);
        Elements elements = mock(Elements.class);
        Element element = mock(Element.class);

        when(document.select("div[class=cat-product-inside]")).thenReturn(elements);
        //Mock ForEach iteration
        Iterator<Element> elementIterator = mock(Iterator.class);
        doCallRealMethod().when(elements).forEach(any(Consumer.class));
        when(elements.iterator()).thenReturn(elementIterator);
        when(elementIterator.hasNext()).thenReturn(true, false);
        when(elementIterator.next()).thenReturn(element);
        //Mock features
        when(element.select("div[class=cat-product-feature]")).thenReturn(elements);
        when(elements.isEmpty()).thenReturn(false);
        //Mock productLink
        when(element.select("a[class=productLink]")).thenReturn(elements);
        //Mock title
        when(elements.attr("title")).thenReturn("Karta graficzna MSI GeForce RTX 3060 Ventus x2 OC 12GB GDDR6 (RTX 3060 VENTUS 2X 12G OC)");
        //Mock price
        when(element.select("div[class=price-new]")).thenReturn(elements);
        when(element.select("div[class=price-new]").get(0)).thenReturn(element);
        when(element.select("div[class=price-new]").get(0).text()).thenReturn("65465,08 zł");
        //Mock fullGpuName
        when(elements.get(2)).thenReturn(element);
        when(elements.get(2).attr("title")).thenReturn("GeForce RTX 3060");
        //Mock gpuLink
        when(element.attr("href")).thenReturn("link");
        when(factory.createGpu(any(), any(), anyDouble(), any(), any())).thenReturn(Optional.of(new Gpu()));

        assertEquals(1, page.getGpus().size());
    }

    @Test
    void shouldGetGpusEmptyList() {
        Page page = new Page(document, factory, priceFormatter);
        Elements elements = new Elements();
        elements.addAll(List.of(new Element(Tag.valueOf("tag"), "uri")));

        when(document.select("div[class=cat-product-inside]")).thenReturn(elements);

        assertEquals(new ArrayList<>(), page.getGpus());
    }

}