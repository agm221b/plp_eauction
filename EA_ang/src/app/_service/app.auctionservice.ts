import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { AuctionItem } from '../_model/app.auctionitem';
import { User} from "../_model/app.user";


@Injectable({
    providedIn: 'root'
})

export class AuctionService {
    constructor(private myhttp: HttpClient) {}

   
   

    addItem(item:any, aucEventId:any): any{
        console.log(item);
        //return this.myhttp.post("http://"+window.location.hostname+":9021/ea/additem",data);
        return this.myhttp.post("http://"+window.location.hostname+":9021/ea/additem?eventId="+aucEventId,item);
    }

    deleteItem(itemId:any){
        console.log(itemId);
        return this.myhttp.delete("http://"+window.location.hostname+":9021/ea/removeitem?itemId="+itemId);
    }

    getAllItems(){
        
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallitems");
    }

    getEvent(eventId){
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewanevent?eventId="+eventId);
    }


    addEvent(aucEvent:any){
        return this.myhttp.post("http://"+window.location.hostname+":9021/ea/addevent",aucEvent);
    }

    deleteEvent(eventId:any){
        console.log(eventId);
        return this.myhttp.delete("http://"+window.location.hostname+":9021/ea/removeevent?eventId="+eventId);

    }

    getAllEvents(){
        //return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallevents");
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewallevents");
    }

    checkLiveEvent(){
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/checkliveevent");
    }

    getAllEventItems(eventId:any){
        console.log(eventId);
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/viewalleventitems?eventId="+eventId);
    }

    checkBid(itemId){
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/checkbid?itemId="+itemId);
    }

    checkLogin(username, pass){
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/checklogin?username="+username+"&pass="+pass);
    }

    getRole(username){
        return this.myhttp.get("http://"+window.location.hostname+":9021/ea/getrole?username="+username);
    }

    addUser(user){
        return this.myhttp.post("http://"+window.location.hostname+":9021/ea/adduser",user);
    }

}