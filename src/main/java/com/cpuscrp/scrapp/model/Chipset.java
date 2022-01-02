package com.cpuscrp.scrapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Chipset {
    GEFORCE("GeForce"),
    RADEON("Radeon");

    @Getter
    public final String label;

    public static Chipset fromString(String text) {
        for (Chipset m : Chipset.values()) {
            if (m.label.equalsIgnoreCase(text)) {
                return m;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found");
    }
}
