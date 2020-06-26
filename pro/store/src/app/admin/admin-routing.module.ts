import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { WorkplaceComponent } from '../workplace/workplace.component';


const routes: Routes = [
  {
    path: "admin",
    component:WorkplaceComponent
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
