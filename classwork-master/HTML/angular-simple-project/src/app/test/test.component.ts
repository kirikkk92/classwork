import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit {
  value = 123456;
  url = "https://www.google.com";
  count = 0;
  name = "Vasya";
  users = [
    {
      name: "Vasya",
      email: "vasya@mail.ru"
    },
    {
      name: "Kolya",
      email: "kolya@mail.ru"
    },
    {
      name: "Igor",
      email: "igor@mail.ru"
    }
  ];

  constructor() {
    setInterval(() => {
      this.value++;
    }, 1000);
  }

  ngOnInit() {
  }

  addValue() {
    this.count++;
  }

}
