import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TestComponent } from './test/test.component';
import { CartComponent } from './cart/cart.component';
import { CartItemComponent } from './cart-item/cart-item.component';
import { Comp1Component } from './comp1/comp1.component';
import { Comp2Component } from './comp2/comp2.component';
import { NotFoundComponent } from './not-found/not-found.component';


import { RequestService } from './services/request.service';
import { WeatherComponent } from './weather/weather.component';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import { UpperPipe } from './pipes/uppercase.pipe';
import { LowerPipe } from './pipes/lowercase.pipe';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http);
}

@NgModule({
  declarations: [
    AppComponent,
    TestComponent,
    CartComponent,
    CartItemComponent,
    Comp1Component,
    Comp2Component,
    NotFoundComponent,
    WeatherComponent,
    UpperPipe,
    LowerPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TranslateModule.forRoot({
      loader: {
          provide: TranslateLoader,
          useFactory: HttpLoaderFactory,
          deps: [HttpClient]
      }
  })
    //MatCheckboxModule,
    //MatSliderModule
  ],
  providers: [RequestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
