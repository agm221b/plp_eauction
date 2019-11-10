import { User } from "./app.user";
import { AuctionEvent } from "./app.auctionevent";

export class AuctionItem{
    itemId: number;
    itemName: string;
    initPrice: number;
    currentPrice: number;
    currentBidder: User;
    finalPrice: number;
    finalOwner: User;
    soldFlag: number;
    paymentType: string;
    auctionEvent: AuctionEvent;
}