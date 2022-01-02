package com.cpuscrp.scrapp.scrappers;

import com.cpuscrp.scrapp.model.Gpu;

import java.util.List;

interface Scrapper {

    List<Gpu> getGpuList();
}
