package com.cpuscrp.scrapp.db;

import com.cpuscrp.scrapp.model.Gpu;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import static com.mongodb.client.model.Filters.eq;

public class GpuRepositoryImpl implements CustomGpuRepository {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long updateIfDocumentExists(Gpu gpu) {
        MongoCollection<Document> col = mongoTemplate.getDb().getCollection("gpus");
//        Document query = new Document("chipsetType", gpu.getChipsetType())
//                .append("price", gpu.getPrice())
//                .append("manufacturer", gpu.getManufacturer())
//                .append("model", gpu.getModel());
        Bson eqChipset = Filters.eq("chipsetType", gpu.getChipsetType());
        Bson eqManufacturer = Filters.eq("manufacturer", gpu.getManufacturer());
        Bson eqModel = Filters.eq("model", gpu.getModel());
        Bson eqPrice = Filters.eq("price", gpu.getPrice());

        Document doc = new Document()
                .append("chipsetType", gpu.getChipsetType())
                .append("price", gpu.getPrice())
                .append("chipset", gpu.getChipset())
                .append("manufacturer", gpu.getManufacturer())
                .append("link", gpu.getLink())
                .append("model", gpu.getModel());
        UpdateResult updateResult = col.replaceOne(Filters.and( eqModel, eqPrice), doc, new ReplaceOptions().upsert(true));
        return updateResult.getMatchedCount();
    }
}
