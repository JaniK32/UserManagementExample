import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { CreateUserComponent } from './users/create-user/create-user.component';
import { ListUsersComponent } from './users/list-users/list-users.component';
import { UserService } from './users/user-service';

@NgModule({
  declarations: [
    AppComponent,
    CreateUserComponent,
    ListUsersComponent
  ],
  imports: [
    BrowserModule, 
    FormsModule,
    HttpClientModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
