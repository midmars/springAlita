import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { BaseballGroupListComponent } from './baseball-group-list/baseball-group-list.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {OktaAuthModule} from "@okta/okta-angular";
import { HomeComponent } from './home/home.component';


const config={
  issuer: 'https://dev-189678.okta.com/oauth2/default',
  redirectUri: 'http://localhost:4200/implicit/callback',
  clientId: '0oac471c2iq43VmXV356'
}
@NgModule({
  declarations: [
    AppComponent,
    BaseballGroupListComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    OktaAuthModule.initAuth(config)

  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
