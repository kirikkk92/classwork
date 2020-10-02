import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {
  items = [
    {
      name: "Socks",
      price: 100
    },
    {
      name: "Jacket",
      price: 1000
    },
    {
      name: "Bracelet",
      price: 50.67
    }
  ];
  cart = [];

  addToCart(item) {
    // находим индекс удаляемого элемента.
    let index = this.items.indexOf(item);
    // удаляем элемент по индексу.
    this.items.splice(index, 1);
    // добавляем удаленный элемент в корзину.
    this.cart.push(item);
  }

  removeFromCart(item) {
    let index = this.cart.indexOf(item);
    this.cart.splice(index, 1);
    this.items.push(item);
  }

  constructor() { }

  ngOnInit() {
  }

}
