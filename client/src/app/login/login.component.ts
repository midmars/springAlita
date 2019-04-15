import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../../../../springAlita/springAltia/client/src/app/shared/user.service";
import {Router} from "@angular/router";
import {HttpParams} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  invalidForm: boolean=false;
  constructor(private formBuilder:FormBuilder,private router:Router,private userService:UserService) {
    this.creatForm();
  }


  ngOnInit() {
    window.sessionStorage.removeItem('token');
    this.creatForm();

  }

  creatForm(){
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required])],
      password: ['',Validators.required]
    })
  }

  onSubmit(){
    if(this.loginForm.invalid){

      return;
    }
    const body = new HttpParams()
      .set('username',this.loginForm.controls.username.value)
      .set('password',this.loginForm.controls.password.value)
      .set('grant_type','password');

    this.userService.login(body.toString()).subscribe(data=>{
      window.sessionStorage.setItem('token', JSON.stringify(data));
      console.log(window.sessionStorage.getItem('token'));
      this.router.navigate(['user-list']);
    }, error => {
      alert(error.error.error_description)
    });
  }
}
