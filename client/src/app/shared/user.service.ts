import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({providedIn:'root'})
export class UserService{
  public API = 'http://localhost:8081';
  public USET_API = this.API+'/api/user';
  constructor(private http:HttpClient){

  }

    login(loginPayload){
      const headers ={
        'Authorization': 'Basic ' + btoa('devglan-client:devglan-secret'),
        'Content-type': 'application/x-www-form-urlencoded'
      }

      return this.http.post(this.API+ '/oauth/token', loginPayload, {headers});
    }
    add():Observable<any>{
    return this.http.get(this.USET_API+"add");
    }
   getAll():Observable<any>{
    return this.http.get(this.USET_API+"/list");
   }
    get(id:String){
    return this.http.get(this.USET_API+"/"+id);
    }
   save( user:any):Observable<any>{
    let result :Observable<Object>;
    result =this.http.post(this.USET_API+"/save",user);

    return result;
   }

}
