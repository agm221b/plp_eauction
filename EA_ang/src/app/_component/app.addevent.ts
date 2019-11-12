import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuctionService } from '../_service/app.auctionservice';
import {AuctionItem} from '../_model/app.auctionitem';
import { AuctionEvent } from '../_model/app.auctionevent';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'addevent',
    templateUrl: '../_html/app.addevent.html'
})

export class AddEvent  implements OnInit{


    model:any ={eventName:"", venue:"", date:"", startTime:"", endTime:""};
    minDate:any;
    maxDate:any;
    dateFormat='dd-MM-yyyy';

    ngOnInit(){}

    constructor(private router: Router, private auctionService: AuctionService,private datepipe:DatePipe) {
        this.minDate=new Date();
        this.maxDate=new Date();
        this.maxDate.setMonth(this.maxDate.getMonth()+1);
    }

    addEvent():any{
        
        this.model.date=this.datepipe.transform(this.model.date,this.dateFormat);
        console.log(this.model);
        this.auctionService.addEvent(this.model).subscribe((data:any)=>location.reload());
        alert("Event added");
        this.router.navigate(['/showevents']);
    }

    validate(){

    }
} 