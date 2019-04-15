import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {UserService} from "../../../../../../spring/springAlita/client/src/app/shared/user.service";

@Component({
  selector: 'app-user-input',
  templateUrl: './user-input.component.html',
  styleUrls: ['./user-input.component.css']
})
export class UserInputComponent  {
  user:any={};
  constructor(private router:Router,private userService:UserService) { }

  createUser():void{
    this.userService.add().subscribe(data=>{
      this.user = data;
      alert( "user created");
    })
  }
  save(user):void{
    this.userService.save(user).subscribe()

  }
}
