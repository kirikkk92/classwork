import { Component, OnInit } from '@angular/core';
import { FakeRequestService } from '../services/fake.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  categories = [
    {
      id: "1",
      name: "CPU"
    },
    {
      id: "2",
      name: "GPU"
    },
    {
      id: "3",
      name: "Keyboards"
    }
  ];

  showItems(event){
    console.log(event.option.value);
  }

  constructor(private requestService: FakeRequestService) { 
    this.requestService.getCategories().toPromise().then(
      (data)=> {
        console.log(data);
      },
      (err)=> {
        console.log(err);
      }
    );
  }

  ngOnInit(): void {
  }

}
