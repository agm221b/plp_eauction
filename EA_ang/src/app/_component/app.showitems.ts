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

    public popoverTitle:string='Delete Confirmation';
    public popoverMessage:string="Do you really want to delete the item?";
    public confirmClicked:boolean=false;
    public cancelClicked:boolean=false;

    constructor(private auctionService: AuctionService){

    }

    ngOnInit(){
        this.auctionService.getAllItems().subscribe((data:AuctionItem[])=>this.itemsList = data);
        this.itemsList.sort((val1, val2)=>
        val2.itemId-val1.itemId);
    }

    deleteItem(itemId:any){
        this.auctionService.deleteItem(itemId).subscribe();
        location.reload();
    }

    sortByName(){
        this.itemsList.sort((val1, val2)=>
        val1.itemName.localeCompare(val2.itemName));
    }
}