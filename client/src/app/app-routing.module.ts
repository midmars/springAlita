import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {OktaCallbackComponent} from "@okta/okta-angular";
import {BaseballGroupListComponent} from "./baseball-group-list/baseball-group-list.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  {path: '', redirectTo: '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  {
  path: 'implicit/callback',
  component: OktaCallbackComponent
}
,{path:'',redirectTo:'/group-list',pathMatch:'full'}
,{
  path: 'group-list',
  component: BaseballGroupListComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
