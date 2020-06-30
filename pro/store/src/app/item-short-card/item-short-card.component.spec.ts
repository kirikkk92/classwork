import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemShortCardComponent } from './item-short-card.component';

describe('ItemShortCardComponent', () => {
  let component: ItemShortCardComponent;
  let fixture: ComponentFixture<ItemShortCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItemShortCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItemShortCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
