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
    private String model;
    private double price;
    private Chipset chipset;
    private String manufacturer;
    private String link;

    public void setChipset(String chipsetName) {
        this.chipset = Chipset.fromString(chipsetName);
    }

    @Override
    public String toString() {
        return "Gpu{" +
                "model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", chipset=" + chipset +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
