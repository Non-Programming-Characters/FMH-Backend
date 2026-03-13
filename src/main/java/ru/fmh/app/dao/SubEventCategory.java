package ru.fmh.app.dao;

import lombok.Getter;

@Getter
public enum SubEventCategory {
    COLLISION_VEHICLE("Столкновение ТС"),
    COLLISION_STATIC("Наезд на препятствие"),
    ROLLOVER("Переворот ТС"),
    PEDESTRIAN("Наезд на пешехода"),
    PASSENGER_FALL("Падение пассажира"),
    FIRE("Возгорание ТС"),
    CARGO_LOSS("Падение груза"),
    FALLEN_TREE("Упавшее дерево"),
    LANDSLIDE("Оползень/обвал"),
    POWER_LINE_DOWN("Обрыв ЛЭП");

    private final String title;

    SubEventCategory(String title) {
        this.title = title;
    }

}
