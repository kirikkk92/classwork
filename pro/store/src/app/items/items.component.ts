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
        this.selectedCategory = category;
      }
    );
   }

   onItemRemove(item) {
      this.requestService.removeItem(item.id).then(
        () => {
          let index = this.items.indexOf(item);
          this.items.splice(index, 1);
        }
      )
   };

   onItemEdit(item) {
    this.dialog.open(ItemDialogComponent, {
      data: {
        item: {...item},
        categories:this.categories
      },
    }).afterClosed().subscribe((result)=>{
      let index = this.items.indexOf(item);
      this.editItem(result,index);
    });
   };

   onItemAdd() {
     this.dialog.open(ItemDialogComponent, {
       data: {
         item: {
           images:[]
         },
         categories:this.categories
       },
     }).afterClosed().subscribe((result)=>{
       this.addNewItem(result);
     });
   };

  addNewItem(item) {
    if (item == undefined) {
      return;
    }
    this.requestService.addItem(item).then(
      (newItem:any) => {
        if (this.selectedCategory == null) {
          return;
        }
        if (newItem.categoryId == this.selectedCategory.id) {
          this.items.push(newItem);
        }
      }
    );
   }

   editItem(item, index) {
     if (item == undefined) {
       return;
     }
     this.requestService.editItem(item).then(
       () => {
         if (this.selectedCategory.id == item.categoryId) {
           this.items[index] = item;
         } else {
           this.items.splice(index, 1)
         }
       }
     )
   }

  ngOnInit(): void {
  }

}
