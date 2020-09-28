import { Component } from '@angular/core';

import { User, Login } from './models/user.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Hello';
  user = new User();
  login = new Login();
}
