import { Component, OnInit } from '@angular/core';
import { FakeRequestService } from '../services/fake.service';
import { ToolBarService } from '../services/toolbar.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  categories = [];
  items = [];
  isMenuOpened = true;

  showItems(event){
    this.requestService.getItems(event.option.value).then(
      (data: any )=>{
        this.items = data;
      }
    )
  }

  constructor(private requestService: FakeRequestService, private toolbarService:ToolBarService) { 

    this.toolbarService.onMenuButtonClick.subscribe(()=>{
      this.isMenuOpened = !this.isMenuOpened;
    });
    
    this.requestService.getCategories().then(
      (data: any )=> {
        this.categories = data;
      },
      (err)=> {
        console.log(err);
      }
    );
  }

  ngOnInit(): void {
  }

}
