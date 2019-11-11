import { Component, OnInit} from '@angular/core';
import {AuctionService} from '../_service/app.auctionservice'
import { AuctionEvent } from '../_model/app.auctionevent';
import { AuctionItem } from '../_model/app.auctionitem';

@Component({
    selector: 'showitems',
    templateUrl: '../_html/app.showitems.html'
})


export class ShowItems implements OnInit  {
    
    itemsList: AuctionItem[] = [];

    constructor(private auctionService: AuctionService){

    }

    ngOnInit(){
        this.auctionService.getAllItems().subscribe((data:AuctionItem[])=>this.itemsList = data);
    }

    deleteEvent(itemId:any){
        this.auctionService.deleteItem(itemId).subscribe();
    }
}