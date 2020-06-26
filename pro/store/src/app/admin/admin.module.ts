import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatTabsModule} from '@angular/material/tabs';
import { WorkplaceComponent } from '../workplace/workplace.component';
import { AdminRoutingModule } from './admin-routing.module';




@NgModule({
  declarations: [WorkplaceComponent],
  imports: [
    CommonModule,
    MatTabsModule,
    AdminRoutingModule
  ]
})
export class AdminModule { }
