import { Component, OnInit} from '@angular/core';
import { AuctionService } from '../_service/app.auctionservice';
import { DatePipe } from '@angular/common';

@Component({
    selector: 'liveevent',
    templateUrl: '../_html/app.liveevent.html'
})


export class LiveEvent implements OnInit {
    
    constructor(private auctionService: AuctionService, private datePipe: DatePipe){

    }
    currentDate: any = new Date();
    currentTime:any = new Date().getTime();;
    runningEvent:any;
    particularDate:any;
    givenDate:any;
    eventStatus: string = "Event Status Undefined";
    itemsList: any[];
    dateFormat='dd-MM-yyyy';
    dateEqual:boolean =false;
    bidStatus: boolean=false;

    ngOnInit(){
        this.currentDate= new Date();
        this.particularDate = new Date("11-11-2019");
         this.currentTime= new Date().getTime();
         console.log(this.currentDate+" & "+ this.currentTime);
         this.auctionService.getAllEvents().subscribe((data:any)=>this.checkRunning(data));
    }
    checkRunning(eventsList:any){
        console.log(eventsList);
        eventsList.forEach(event => {
            this.currentDate = this.datePipe.transform(this.currentDate,this.dateFormat);
            this.particularDate = this.datePipe.transform(this.particularDate,this.dateFormat);
            console.log(event.startTime + " : ");
            console.log(event.endTime + " // ");
            
            if(this.currentDate == event.date)
            {
                this.dateEqual=true;
                this.runningEvent = event;
                var currtime= new Date(this.currentDate+event.startTime);
            var eventtime= new Date(this.runningEvent.date+event.endTime);
            if(currtime >= eventtime ){
                this.eventStatus = "Event Not Started";
                alert("Event not started");
            }else{
                this.eventStatus = "Event Started";
                console.log(event);
                this.auctionService.getAllEventItems(event.eventId).subscribe((data:any)=>this.itemsList=data);
                
                  
            }
            }
            
        });
    }

    requestBid(itemId:any){
        this.auctionService.checkBid(itemId).subscribe((bidStatus:boolean)=>this.bidStatus=bidStatus);
        console.log(this.bidStatus);
        //
    }
}