package com.cpuscrp.scrapp.db;

import com.cpuscrp.scrapp.model.Gpu;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.ReplaceOptions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class GpuRepositoryImpl implements CustomGpuRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateIfDocumentExists(Gpu gpu) {
        MongoCollection<Document> col = mongoTemplate.getDb().getCollection("gpus");
        Document query = new Document("chipsetType", gpu.getChipsetType())
                .append("manufacturer", gpu.getManufacturer())
                .append("model", gpu.getModel());
        System.out.println(gpu);
        Document doc = new Document()
                .append("chipsetType", gpu.getChipsetType())
                .append("price", gpu.getPrice())
                .append("chipset", gpu.getChipset().label)
                .append("manufacturer", gpu.getManufacturer())
                .append("link", gpu.getLink())
                .append("model", gpu.getModel());
        col.replaceOne(query, doc, new ReplaceOptions().upsert(true));
    }
}
