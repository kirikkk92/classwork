import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Comp1Component } from './comp1/comp1.component';
import { Comp2Component } from './comp2/comp2.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { CartComponent } from './cart/cart.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/c2",
    pathMatch: "full"
  },

  {
    path: "c1",
    component: Comp1Component,
    children: [
      {
        path: "",
        redirectTo: "cart",
        pathMatch: "full"
      },
      {
        path: "cart",
        component: CartComponent
      }
    ]
  },

  {
    path: "c2",
    component: Comp2Component
  },
  {
    path: "**", // ** - путь не найден
    component: NotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
