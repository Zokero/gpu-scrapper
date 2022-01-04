package com.cpuscrp.scrapp.scrapp;

import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.scrapp.page.MorelePage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class PageTest {

    @Mock
    Document document;

    @Autowired
    GpuFactory factory;

    MorelePage page;

    @BeforeEach
    void beforeEach() {
        page = new MorelePage(factory, document);
    }

    @Test
    void shouldGetNumberOfPages() {
        //Given
        Elements element = mock(Elements.class);
        //When
        when(document.select("div[class=pagination-btn-nolink-anchor]")).thenReturn(element);
        when(element.text()).thenReturn("5");
        //Then
        assertEquals(5, page.getNumberOfPages());
    }

    @Test
    void shouldGetGpusEmptyList() {
        //Given
        Elements elements = new Elements();
        elements.addAll(List.of(new Element(Tag.valueOf("tag"), "uri")));
        //When
        when(document.select("div[class=cat-product-inside]")).thenReturn(elements);
        //Then
        assertEquals(new ArrayList<>(), page.getGpus());
    }

    @Test
    void shouldGetGpus() throws IOException {
        //Given
        String fileName = "htmlWebsiteParts/morele.html";
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream(fileName);
        String text = new String(is.readAllBytes(), StandardCharsets.UTF_8);
        Elements doc = Jsoup.parse(text).select("div[class=cat-product-inside]");
        //When
        when(document.select("div[class=cat-product-inside]")).thenReturn(doc);
        //Then
        assertEquals(1, page.getGpus().size());
    }

}