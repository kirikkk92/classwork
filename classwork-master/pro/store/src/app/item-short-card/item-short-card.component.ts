import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-item-short-card',
  templateUrl: './item-short-card.component.html',
  styleUrls: ['./item-short-card.component.scss']
})
export class ItemShortCardComponent implements OnInit {
  @Input ('item') item;
  @Output ('onRemove')
  onRemoveHandler: EventEmitter<void> = new EventEmitter();
  @Output ('onEdit')
  onEditHandler: EventEmitter<void> = new EventEmitter();

  constructor() { }

  removeItem() {
    this.onRemoveHandler.emit();
  }

  editItem() {
    this.onEditHandler.emit();
  }

  ngOnInit(): void {
  }

}
