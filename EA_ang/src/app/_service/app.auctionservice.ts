import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'


@Injectable({
    providedIn: 'root'
})

export class AuctionService {
    constructor(private myhttp: HttpClient) {}

    getAllItems(){
        
        return this.myhttp.get("");
    }

    getAllEvents(){
        return this.myhttp.get("");
    }


}