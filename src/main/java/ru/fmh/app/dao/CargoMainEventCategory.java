package ru.fmh.app.dao;

import lombok.Getter;

@Getter
public enum CargoMainEventCategory {
    ACCIDENT("ДТП"),
    ROAD_HAZARD("Опасность на дороге"),
    INFRASTRUCTURE("Инфраструктура");

    private final String title;

    CargoMainEventCategory(String title) {
        this.title = title;
    }

}