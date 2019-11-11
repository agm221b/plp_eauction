import { Component, OnInit} from '@angular/core';
import { AuctionService } from '../_service/app.auctionservice';
import { User } from '../_model/app.user';
import { Router } from '@angular/router';

@Component({
    selector: 'login',
    templateUrl: '../_html/app.login.html'
})


export class LoginComponent implements OnInit {

    model:any;
    invalidLogin:boolean=false;
    user:User;

    ngOnInit(){

    }

    constructor(private auctionService: AuctionService, private router:Router){

    }

    checkCredentials(){
        if(this.auctionService.checkLogin(this.model.username, this.model.pass))

         {
            this.auctionService.getRole(this.model.username).subscribe((data:User)=>{
              this.user=data; 
              this.redirect();
            });
          } else{
            console.log("Invalid Login Credentials.");
            this.invalidLogin = true;
          }
    }
    

    redirect(){
        if(this.user.roles==="ROLE_USER"){
          sessionStorage.setItem('role','user');
          sessionStorage.setItem('userId',String(this.user.userId));
          this.invalidLogin = false;
          this.router.navigate(["/userpanel"]).then(()=>{
            window.location.reload();
          });
        }else if(this.user.roles==="ROLE_ADMIN"){
          sessionStorage.setItem('role','admin');
          sessionStorage.setItem('userId',String(this.user.userId));
          this.invalidLogin = false;
          this.router.navigate(["adminpanel"]).then(()=>{
            window.location.reload();
          }); 
        }
      }
}