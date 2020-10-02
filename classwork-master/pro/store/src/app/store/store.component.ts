import { Component, OnInit } from '@angular/core';
import { ToolBarService } from '../services/toolbar.service';

@Component({
  selector: 'app-store',
  templateUrl: './store.component.html',
  styleUrls: ['./store.component.scss']
})
export class StoreComponent implements OnInit {

  constructor(private toolbarService: ToolBarService) { }

  ngOnInit(): void {
  }

  toggleMenu() {
    this.toolbarService.emitMenuButtonClick();
  }

}
