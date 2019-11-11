import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { AuctionItem } from '../_model/app.auctionitem';


@Injectable({
    providedIn: 'root'
})

export class AuctionService {
    constructor(private myhttp: HttpClient) {}

   
   

    addItem(item:any): any{
        console.log(item);
        //return this.myhttp.post("http://"+window.location.hostname+":9021/ea/additem",data);
        return this.myhttp.post("http://"+window.location.hostname+":9021/ea/additem",item);
    }

    deleteItem(itemId:any){
        console.log(itemId);
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/removeitem?itemId="+itemId);
    }

    getAllItems(){
        
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallitems");
    }


    addEvent(aucEvent:any){
        return this.myhttp.post("http://"+window.location.hostname+":9021/ea/addevent",aucEvent);
    }

    deleteEvent(eventId:any){
        console.log(eventId);
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/removeevent?eventId="+eventId);

    }

    getAllEvents(){
        //return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallevents");
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallevents");
    }

}