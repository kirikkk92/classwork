import { Component, OnInit } from '@angular/core';
import { FakeRequestService } from '../services/fake.service';
import { MatDialog } from '@angular/material/dialog';
import { ItemDialogComponent } from '../item-dialog/item-dialog.component';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {
  selectedCategory = null;
  categories = [];
  items = [];
  constructor(
    private requestService: FakeRequestService,
    private dialog: MatDialog) { }

   update() {
    this.requestService.getCategories().then(
      (data:any)=>{
        this.categories = data;
      }
    );
   }

   getItems(category) {
    this.requestService.getItems(category.id).then(
      (data:any)=>{
        this.items = data;
      }
    );
   }

   onItemRemove(item) {
    
   };

   onItemEdit(ite) {

   };

   onItemAdd() {
     this.dialog.open(ItemDialogComponent, {
       data: {
         item: {},
         categories:this.categories
       },
     }).afterClosed().subscribe((result)=>{
       this.addNewItem(result);
     });
   };

   addNewItem(item) {

   }


  ngOnInit(): void {
  }

}
