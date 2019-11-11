import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuctionService } from '../_service/app.auctionservice';
import {AuctionItem} from '../_model/app.auctionitem';
import { AuctionEvent } from '../_model/app.auctionevent';


@Component({
    selector: 'additem',
    templateUrl: '../_html/app.additem.html'
})


export class AddItem  implements OnInit{

    model:any ={itemName:"", initPrice:""};
    events: any[] = [];
    
    nameStatus: boolean=false;
    priceStatus: boolean=false;

    ngOnInit(){
        this.auctionService.getAllEvents().subscribe((data:any[])=>this.events=data);
        console.log(this.events);
    }

    constructor(private router: Router, private auctionService: AuctionService) {
   
     }

     addItem(): any{
         
         console.log(this.model+": model");
        this.auctionService.addItem(this.model).subscribe((data:AuctionItem)=>console.log(data));
        alert("Item Added Successfully");
        this.router.navigate(['/home']);
     }

     validate(){
        // console.log('entered in validation')
        // if(this.model.itemName.match("[a-zA-Z\\s]")&&this.model.itemName.length>=4){
        //     console.log("name correctly entered")
        //     this.nameStatus=true;
        // }
        // else{
        //     console.log("false block busName")
        //     this.nameStatus=false;
        //     return true;
        // }
        // if(this.model.initPrice>0 && this.model.initPrice<10000){
        //     this.priceStatus=true;
        //     console.log("Price entered correctly");
        // }
        // else{
        //     console.log("false block price")
        //     this.priceStatus=false;
        //     return true;
        // }
     }
    
}