package com.company;

public class Main {

    public static void main(String[] args) {
	USDConverter usd = new USDConverter();
	RUBConverter rub = new RUBConverter();
	System.out.println(usd.convert(100));
	System.out.println(usd.convert(100));

	USD cUSD = new USD();
	cUSD.setValue(200.30f);
	BYN cBYN = new BYN();
	cUSD.convertTo(cBYN);
	System.out.println(cBYN);
	cBYN.convertTo(cUSD);
	System.out.println(cUSD);


   /* String s = "asdasdasfdfdfasdfadfsdfdfsanf";
	String [] arr = s.split("");
		int i=0;
	while(arr.length != 0){
		for( i=0;i >arr.length;i++){

		}*/
	}
}
