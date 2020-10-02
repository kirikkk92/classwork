import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StoreComponent } from './store/store.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MenuComponent } from './menu/menu.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import { HttpClientModule } from '@angular/common/http';
import { RequestService } from './services/request.service';
import { FakeRequestService } from './services/fake.service';
import { ItemCardComponent } from './item-card/item-card.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { ToolBarService } from './services/toolbar.service';
import {MatRippleModule} from '@angular/material/core';
import { AdminModule } from './admin/admin.module';




@NgModule({
  declarations: [
    AppComponent,
    StoreComponent,
    MenuComponent,
    ItemCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatRippleModule,
    AdminModule
  ],
  providers: [
    RequestService,
    FakeRequestService,
    ToolBarService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
