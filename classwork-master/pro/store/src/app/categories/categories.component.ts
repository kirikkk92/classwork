import { Component, OnInit } from '@angular/core';
import { FakeRequestService } from '../services/fake.service';
import { MatDialog } from '@angular/material/dialog';
import { CategoryDialogComponent } from '../category-dialog/category-dialog.component';


@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {
  categories = [];
  constructor(private requestService: FakeRequestService, private dialog: MatDialog) { 
    this.requestService.getCategories().then(
      (data: any)=>{
        this.categories = data;
      }
    );
  }

  add() {
    this.dialog.open(CategoryDialogComponent, {
      data: {
        category: ''
      }
    }).afterClosed().subscribe(result => {
      this.addNewCategory(result);
    });
  }

  addNewCategory(category) {
    if (category == undefined) {
      return
    }
    this.requestService.addNewCategory(category).then(
      (data)=> {
        this.categories.push(data);
      }
    );
  }

  edit(category) { 
    this.dialog.open(CategoryDialogComponent, {
      data: {
        category: category.name
      }
    }).afterClosed().subscribe(result => {
      this.editCategory(category, result);
    });
  }

  editCategory(category,newName) {
    if (newName == undefined) {
      return
    }
    this.requestService.editCategory({
      name:newName,
      id: category.id
    }).then(()=> {
        let index = this.categories.indexOf(category);
        if (index >= 0) {
          this.categories[index].name = newName;
        }
      });
  }

  remove(category) { 
    this.requestService.removeCategory(category.id).then(()=>{
      let index = this.categories.indexOf(category);
        if (index >= 0) {
          this.categories.splice(index,1);
        }
    });
  }

  ngOnInit(): void {
  }

}
