import { Component, Injectable } from '@angular/core';
import { UserService } from '../user-service';
import { User } from '../user';

@Component({
    selector: 'app-list-users',
    templateUrl: './list-users.component.html',
    styleUrls: ['./list-users.component.scss']
})

@Injectable()
export class ListUsersComponent {

    users: User[] = [];
    showDetails: Map<number,boolean> = new Map();
    errorMessage: string = ""; 

    constructor(private userService : UserService){
    }

    ngOnInit() { 
        this.getUsers();
    }
   
    getUsers (){
        this.userService.getUsers().subscribe(
            users => (this.users = users),
            err => this.errorMessage = err,
        );
    }

    delete (id: number): void{
        if (this.users.length >0){
            let index = this.users.findIndex( user => user.id === id);
            this.users.splice(index, 1);
            console.info("Deleted user " + id);
        }
    }

    toggleDetails (id: number): void{
        if (!this.showDetails.has(id))
            this.showDetails.set(id,true);
        else
            this.showDetails.set(id,!this.showDetails.get(id));
    }
}
