package com.cpuscrp.scrapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Manufacturer {
    GIGABYTE("Gigabyte"),
    ZOTAC("Zotac"),
    MSI("MSI"),
    INNO3D("Inno3d"),
    PALIT("Palit"),
    ASUS("Asus"),
    ASROCK("ASRock"),
    GAINWARD("Gainward"),
    XFX("XFX"),
    SAPPHIRE("Sapphire"),
    NVIDIA("NVIDIA"),
    AMD("AMD"),
    PNY("PNY"),
    EVGA("EVGA"),
    POWER_COLOR("Power Color");
//    BIOSTAR("Biostar"),
//    MANLI("Manli"),
//    LENOVO("Lenovo"),
//    HP("HP"),
//    KFA2("KFA2"),
//    AFOX("AFOX"),
//    ZELOX("Zelox"),
//    ARKTEK("Arktek"),
//    FUJITSU("Fujitsu"),
//    MATROX("Matrox");

    @Getter
    public final String label;

    public static Manufacturer fromString(String text) {
        for (Manufacturer m : Manufacturer.values()) {
            if (m.label.equalsIgnoreCase(text)) {
                return m;
            }
        }
        throw new IllegalArgumentException("No manufacturer " + text + " found");
    }

}
