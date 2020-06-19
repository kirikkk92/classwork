import { Component } from '@angular/core';

import { User, Login } from './models/user.model';
import { TranslateService } from '@ngx-translate/core';
import {environment} from '../environments/environment';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  message = environment.message;

  constructor(private translate: TranslateService) {
    this.translate.setDefaultLang("en")
  }
  setLang(lang){
    this.translate.use(lang);
  }

  userName = "Kolya"

  title = 'Hello';
  user = new User();
  login = new Login();
}
