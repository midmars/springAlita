import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BaseballGroupListComponent} from "./baseball-group-list/baseball-group-list.component";
import {OktaCallbackComponent} from "@okta/okta-angular";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {
    path:'group-list',
    component:BaseballGroupListComponent
  },
  {
  path: 'implicit/callback',
  component: OktaCallbackComponent
},
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
