import { Component, OnInit } from '@angular/core';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.scss']
})
export class WeatherComponent implements OnInit {
  city = null;
  cityWeather = null;

  constructor(private requestService: RequestService) { }

  searchCity(city) {
    this.city = null;
    this.requestService.search(city).then(
      (data: any) => {
        if (data.length == 0) {
          return;
        }
        this.city = data[0];
        this.getWeather(this.city.woeid);
      }
    );
  }

  getWeather(cityID) {
    this.requestService.getWeather(cityID).then(
      (data: any) => {
        this.cityWeather = data.consolidated_weather[0];
      }
    );
  }

  ngOnInit() {
  }

}
