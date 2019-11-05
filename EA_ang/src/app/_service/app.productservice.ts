import { Injectable } from '@angular/core'
import { HttpClient } from '@angular/common/http'
import { Product } from '../_model/app.product';

@Injectable({
    providedIn: 'root'
})

export class ProductService {
    constructor(private myhttp: HttpClient) {}

    getAllData(){
        return this.myhttp.get("http://localhost:9081/product/getall");
    }

    addProduct(data:any){
        console.log(data);
        let form = new FormData();
        form.append("prodId",data.prodId);
        form.append("prodName",data.prodName);
        form.append("prodCost",data.prodCost);
        form.append("prodDescription",data.prodDescription);
        return this.myhttp.post("http://localhost:9081/product/add", form);
    }

    deleteProduct(productId:any){
        console.log(productId);
        return this.myhttp.delete("http://localhost:9081/product/delete?"+"productId="+productId);

    }
}