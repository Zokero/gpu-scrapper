package com.cpuscrp.scrapp.db;

import com.cpuscrp.scrapp.model.Gpu;

public interface CustomGpuRepository {

    long updateIfDocumentExists(Gpu gpu);
}
