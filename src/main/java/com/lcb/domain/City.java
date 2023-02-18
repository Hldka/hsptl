package com.lcb.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum City {
    ISTANBUL("Istanbul"),
    ANKARA("Ankara"),
    IZMIR("Izmir"),
    BURSA("Bursa"),
    ANTALYA("Antalya");

    private final String displayName;
}