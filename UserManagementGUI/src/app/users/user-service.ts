import { NgModule } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { User } from './user';

declare var require: any;
var conf = require("../../assets/config.json");

const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      Authorization: 'my-auth-token'
    })
  };

@NgModule({
    providers: [UserService],
})
export class UserService {

    usersAddress = conf.usersAddress;

    newUser: User | undefined;

    constructor(private http: HttpClient) { 
    }

    getUsers(): Observable<User[]>{
        return this.http.get<User[]>(this.usersAddress)
      .pipe(
        retry(1),
        catchError(this.handleError) 
      );
    }

    private handleError(error: HttpErrorResponse) {
        console.error(error.error);
        return throwError(() => new Error('Http error, see log for details.'));
      }

    createUser (user: User){
    }
    
    deleteUser(id: number){
    }
}