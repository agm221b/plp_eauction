import {AuctionItem} from './app.auctionitem';

export class AuctionEvent{
    eventId:number;
    eventName: string;
    venue: string;
    date: string;
    startTime: string;
    endTime: string;
    itemsList: AuctionItem[];
    
}