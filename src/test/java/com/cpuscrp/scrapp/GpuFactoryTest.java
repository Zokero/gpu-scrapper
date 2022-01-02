package com.cpuscrp.scrapp;

import com.cpuscrp.scrapp.model.GpuFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class GpuFactoryTest {

    @Autowired
    GpuFactory gpuFactory;

    @Test
    void shouldGetManufacturerFromTitle() {
        String title1 = "Karta graficzna Manli GeForce RTX 3070 Ti 8GB GDDR6 (M3514+N651-03)";
        String title2 = "Karta graficzna  Power Color  Radeon RX 580 Red Dragon 8GB GDDR5 (AXRX 580 8GBD5-DHDV2";
        String title3 = "Karta graficzna - Power Color Radeon RX 580 Red Dragon 8GB GDDR5 (AXRX 580 8GBD5-DHDV2";
        String title4 = "";

    }

}
