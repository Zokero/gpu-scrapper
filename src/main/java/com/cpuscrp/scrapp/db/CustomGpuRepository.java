package com.cpuscrp.scrapp.db;

import com.cpuscrp.scrapp.model.Gpu;

public interface CustomGpuRepository {

    void updateIfDocumentExists(Gpu gpu);
}
