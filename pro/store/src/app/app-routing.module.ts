import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StoreComponent } from './store/store.component';
import { MenuComponent } from './menu/menu.component';


const routes: Routes = [
  {
    path: "",
    redirectTo: "/store",
    pathMatch:"full"
  },
  {
    path: "store",
    component:StoreComponent,
    children:[
      {
        path:"",
        pathMatch: "full",
        redirectTo:"menu"
      },
      {
        path:"menu",
        component:MenuComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
