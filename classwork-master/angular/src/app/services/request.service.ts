import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class RequestService {
  addr = "https://www.metaweather.com/api/location/";

  constructor(private http: HttpClient) { }

  search(city) {
    return this.http.get(this.addr + "search/?query=" + city).toPromise();
  }

  getWeather(cityID) {
    return this.http.get(this.addr + cityID).toPromise();
  }
}