import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-cart-item',
  templateUrl: './cart-item.component.html',
  styleUrls: ['./cart-item.component.scss']
})
export class CartItemComponent implements OnInit {
  @Input('item')
  cartItem = null; // => [item]
  @Input('inCart')
  inCart: boolean = false; // => [inCart]
  @Output('cartAdd')
  cartAdd: EventEmitter<void> = new EventEmitter(); // => (cartAdd)
  @Output('cartRemove')
  cartRemove: EventEmitter<void> = new EventEmitter(); // => (cartRemove)

  emitCartAdd() {
    // emit() сообщает через компонент о наступлении события cartAdd
    this.cartAdd.emit();
  }

  emitCartRemove() {
    this.cartRemove.emit();
  }

  constructor() { }

  ngOnInit() {
  }

}
