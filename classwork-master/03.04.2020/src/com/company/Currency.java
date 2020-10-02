package com.company;

import java.util.HashMap;

public abstract class Currency implements Convertable {
    private float value;
    protected  String name;
    private static HashMap<String, Float> exchangeTable;
    private static HashMap<String,Float> getExchangeTable(){
        if(exchangeTable != null){
            return  exchangeTable;
        }
        exchangeTable = new HashMap<>();
        exchangeTable.put("USD_BYN",2.58f);
        exchangeTable.put("BYN_USD",0.388f);
        return  exchangeTable;
    }
    private static void convert(Currency from,Currency to){
        String key = from.name + "_" + to.name;
        to.value = from.value * getExchangeTable().get(key);
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", this.value, this.name);
    }
    @Override
    public void convertTo(Currency currency) {
        convert(this,currency);
    }
}