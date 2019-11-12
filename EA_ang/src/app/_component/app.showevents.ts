import { Component, OnInit} from '@angular/core';
import {AuctionService} from '../_service/app.auctionservice'
import { AuctionEvent } from '../_model/app.auctionevent';

@Component({
    selector: 'showevents',
    templateUrl: '../_html/app.showevents.html'
})


export class ShowEvents implements OnInit  {
    
    eventsList: AuctionEvent[] = [];

    public popoverTitle:string='Delete Confirmation';
    public popoverMessage:string="Do you really want to delete the event?";
    public confirmClicked:boolean=false;
    public cancelClicked:boolean=false;

    constructor(private auctionService: AuctionService){

    }

    ngOnInit(){
        this.auctionService.getAllEvents().subscribe((data:AuctionEvent[])=>this.eventsList = data);
    }

    deleteEvent(eventId:any){
        this.auctionService.deleteEvent(eventId).subscribe();
        location.reload();
    }

    sortByName(){
        this.eventsList.sort((val1, val2)=>
        val1.eventName.localeCompare(val2.eventName));
    }
}