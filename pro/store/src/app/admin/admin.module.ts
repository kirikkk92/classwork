import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTabsModule} from '@angular/material/tabs';
import { WorkplaceComponent } from '../workplace/workplace.component';
import { AdminRoutingModule } from './admin-routing.module';
import { CategoriesComponent } from '../categories/categories.component';
import {MatChipsModule} from '@angular/material/chips';
import { RequestService } from '../services/request.service';
import { FakeRequestService } from '../services/fake.service';
import {MatDialogModule} from '@angular/material/dialog';
import { CategoryDialogComponent } from '../category-dialog/category-dialog.component';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';
import {MatIconModule} from '@angular/material/icon';









@NgModule({
  declarations: [WorkplaceComponent, CategoriesComponent, CategoryDialogComponent],
  imports: [
    CommonModule,
    MatTabsModule,
    AdminRoutingModule,
    MatChipsModule,
    MatDialogModule,
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule
  ],
  providers:[
    RequestService,
    FakeRequestService
  ]
})
export class AdminModule { }
