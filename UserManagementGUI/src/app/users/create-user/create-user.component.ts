import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { User } from '../user';

@Component({
    selector: 'app-create-user',
    templateUrl: './create-user.component.html',
    styleUrls: ['./create-user.component.scss']
})

export class CreateUserComponent {

    statusMessage: string = "";
    statusCode: string = "status-ok";
    user: User = this.getEmptyUser();

    constructor (private formBuilder: FormBuilder){
    }

    create (){
        try {
            this.checkRequiredFields();
        }
        catch (argumentError) {
            this.statusMessage = "" + argumentError;
            this.statusCode = "status-nok";
            return;
        }
        this.statusMessage = "OK";
        this.statusCode = "status-ok";
        this.user = this.getEmptyUser();
    }

    getEmptyUser(): User {
        return {
            id: 0,
            name: '',
            username: '',
            email: '',
            phone: '',
            website: '',
            address: {
                street: '',
                suite: '',
                city: '',
                zipcode: '',
                geo: {
                  lat: 0.0,
                  lng: 0.0
                }
            }
        };
    }

    checkRequiredFields(){
        if ( this.user.name == '' || this.user.username == '')
            throw Error("Missing required values.");
    }
}
