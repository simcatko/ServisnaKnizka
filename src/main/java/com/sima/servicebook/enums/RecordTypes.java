package com.sima.servicebook.enums;

import java.util.HashMap;
import java.util.Map;

public enum RecordTypes {
    VYMENA_OLEJA(1, "Vymena oleja"),
    PREMAZANIE_PODVOZKU(2, "Premazanie podvozdku"),
    VYMENA_OLEJOVEHO_FILTRA(3, "Vymena olejoveho filtra"),
    VYMENA_VZDUCHOVEHO_FILTRA(4, "Vymena vzduchoveho filtra"),
    VYMENA_PREVODOVKOVEHO_OLEJA(5, "Vymena prevodoveho oleja"),
    CISTENIE_KLIMATIZACIE(6, "Cistenie klimatizacie"),
    PRIDANIE_NEMRZNUCEJ_ZMESI(7, "Pridanie nemrznucej zmesi"),
    GEOMETRIA_KOLIES(8, "Geometria kolies"),
    VZAJOMNA_VYMENA_PNEUMATIK(9, "Vzajomna vymena pneumatik"),
    NAHRADA_PNEUMATIK(10, "Nahrada pneumatik"),
    UPRAVA_BRZD(11, "Uprava brzd"),
    NASTAVENIE_MOTORA(12, "Nastavenie motora"),
    INY_SERVIS(13, "Iny servis");

    private final int value;
    private final String meno;

    private RecordTypes(int value, String meno){
        this.value = value;
        this.meno = meno;
    }

    public int getValue() {
        return value;
    }

    public String getMeno() {
        return meno;
    }

    public static Map<Integer, String> getNumberMenoMap() {
        Map<Integer, String> map = new HashMap<>();
        for (RecordTypes type: RecordTypes.values()) {
            map.put(type.getValue(), type.getMeno());
        }
        return map;
    }
}
