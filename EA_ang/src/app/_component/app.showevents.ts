import { Component, OnInit} from '@angular/core';
import {AuctionService} from '../_service/app.auctionservice'
import { AuctionEvent } from '../_model/app.auctionevent';

@Component({
    selector: 'showevents',
    templateUrl: '../_html/app.showevents.html'
})


export class ShowEvents implements OnInit  {
    
    eventsList: AuctionEvent[] = [];

    constructor(private auctionService: AuctionService){

    }

    ngOnInit(){
        this.auctionService.getAllEvents().subscribe((data:AuctionEvent[])=>this.eventsList = data);
    }

    deleteEvent(eventId:any){
        this.auctionService.deleteEvent(eventId).subscribe();
    }
}