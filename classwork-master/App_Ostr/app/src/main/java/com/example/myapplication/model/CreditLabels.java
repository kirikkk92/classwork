package com.example.myapplication.model;

public enum CreditLabels {
    FOOD("Питание"),
    TRANSPORT("Транспорт"),
    ENTERTAINMEMT("Развлечения"),
    OTHER("Другое");

    private String label;
    CreditLabels(String label){
        this.label = label;
    }

    public String get_label(){
        return this.label;
    }
}
