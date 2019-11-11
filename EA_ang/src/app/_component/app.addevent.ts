import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AuctionService } from '../_service/app.auctionservice';
import {AuctionItem} from '../_model/app.auctionitem';
import { AuctionEvent } from '../_model/app.auctionevent';

@Component({
    selector: 'addevent',
    templateUrl: '../_html/app.addevent.html'
})

export class AddEvent  implements OnInit{


    model:any;
    minDate:any;
    maxDate:any;
    ngOnInit(){}

    constructor(private router: Router, private auctionService: AuctionService) {
        this.minDate=new Date();
        this.maxDate=new Date();
        this.maxDate.setMonth(this.maxDate.getMonth()+1);
    }

    addEvent():any{
        this.auctionService.addEvent(this.model);
    }
} 