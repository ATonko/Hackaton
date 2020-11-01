package com.example.hackaton

internal data class EventInfoItem(
    //Возрастная категория
    val ageCategory: String,
    //Возрастной ценз участников мероприятия
    val ageCens: String,
    //Время начала мероприятия
    val startTime: String,
    //Время окончания мероприятия
    val endTime: String,
    //Дата начала мероприятия
    val startDate: String,
    //Дата окончания мероприятия
    val endDate: String,
    //Доступность мероприятия для лиц с ОВЗ
    val OVZAvailability: String,
    //Краткое описание
    val shortDescription: String,
    //Мероприятие относится к ежегодным праздникам и общегородским мероприятиям
    val eventFestiveType: String,
    //Место проведения
    val eventPlace: String,
    //Название мероприятия
    val eventName: String,
    //Наименование праздника или события
    val festiveName: String,
    //Наименование учреждения
    val officeName: String,
    //Направленность мероприятия
    val eventDirection: String,
    //Округ
    val district: String,
    //Подразделение
    val unit: String,
    //Проводится онлайн
    val isOnline: String,
    //Район
    val area: String,
    //Статус
    val status: String,
    //Стоимость (полная)
    val cost: String,
    //Тип ОВЗ
    val OVZType: String,
    //Тип мероприятия
    val eventType: String,
    //Тип учреждения
    val unitType: String,
    //Целевая аудитория
    val targetAudience: String,
    val id: String
)