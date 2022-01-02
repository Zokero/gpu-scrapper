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
        Document query = new Document("model", gpu.getModel()).append("manufacturer", gpu.getManufacturer());
        System.out.println(gpu);
        Document doc = new Document()
                .append("model", gpu.getModel())
                .append("price", gpu.getPrice())
                .append("chipset", gpu.getChipset().label)
                .append("manufacturer", gpu.getManufacturer())
                .append("link", gpu.getLink());
        col.replaceOne(query, doc, new ReplaceOptions().upsert(true));
    }
}
