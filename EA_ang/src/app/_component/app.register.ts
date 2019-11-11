import { Component, OnInit} from '@angular/core';
import { AuctionService } from '../_service/app.auctionservice';
import { Router } from '@angular/router';

@Component({
    selector: 'register',
    templateUrl: '../_html/app.register.html'
})


export class RegisterComponent implements OnInit {

    model:any={username:"",pass:"",mobileNo:"",userType:"",gender:"",email:""};

    ngOnInit(){

    }

    constructor(private auctionService: AuctionService, private router: Router){

    }

    registerUser(){
        this.auctionService.addUser(this.model).subscribe((data:any)=>this.router.navigate(['/login']));
    }

    validate(){

    }
    
}