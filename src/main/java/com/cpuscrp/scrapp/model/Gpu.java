package com.cpuscrp.scrapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("gpus")
@NoArgsConstructor
public class Gpu {

    @Id
    private ObjectId id;
    private String chipsetType;
    private double price;
    private String chipset;
    private String manufacturer;
    private String link;
    private String model;
//    private Date Date lastCheckDate;

    @Override
    public String toString() {
        return "Gpu{" +
                "chipsetType=" + chipsetType +
                ", price=" + price +
                ", chipset=" + chipset +
                ", manufacturer=" + manufacturer +
                ", model=" + model +
                "}";
    }
}
