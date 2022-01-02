package com.cpuscrp.scrapp;

import com.cpuscrp.scrapp.model.GpuFactory;
import com.cpuscrp.scrapp.model.PriceFormatter;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class MoreleScrapperTest {

    @Mock
    GpuFactory factory;

    @Mock
    PriceFormatter priceFormatter;

    @Test
    void shouldCreateListOfGpus() {
//        when(documentService.getDocument(any())).thenReturn(Optional.of(new Document(any())));
//        when(documentService.getNumberOfPages(any())).thenReturn(2);
//        verify(factory, times(1));


    }

}
