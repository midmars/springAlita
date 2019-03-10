import {Component, OnInit} from '@angular/core';
import {OktaAuthService} from "@okta/okta-angular";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'MLB';
  isAuthenticated: boolean;

  constructor(public okraAuth: OktaAuthService){

  }
  async ngOnInit(){
    this.isAuthenticated = await  this.okraAuth.isAuthenticated();

    this.okraAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean) => this.isAuthenticated=isAuthenticated
    );
  }
}
