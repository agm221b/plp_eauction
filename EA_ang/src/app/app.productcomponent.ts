import {Component, OnInit} from '@angular/core'
import {ProductService} from './_service/app.productservice'; 
import {Product} from './_model/app.product';

@Component({
     selector: 'prod',
     templateUrl:`app.product.html` 
 })

export class ProductComponent implements OnInit{

model:any={};
prodId: number;
prodName:string;
prodCost:number;
prodDescription: string;
update:any;

productsList:Product[]=[];
constructor(private service:ProductService){
    console.log("In constructor");
}


ngOnInit(){
    console.log("In Init");
    this.service.getAllData()
    .subscribe((data:Product[]) => this.productsList = data);

}

addProduct():any{
    //alert("hi");
    console.log(this.model);
    //this.productsList.push(this.model);
    this.service.addProduct(this.model)
    .subscribe((data)=>console.log(data));


};


deleteProduct(productId):any{
    //this.model=productId;
    this.service.deleteProduct(productId)
    .subscribe();
//this.productsList.splice(pro,1);
}

// addProduct():any{
    //     this.products.push({prodId: this.prodId, prodName:this.prodName, prodCost:this.prodCost});
    // }

    
    // deleteProduct(prod:any):any{
    //     this.products.splice(this.products.indexOf(prod), 1);
    // }


}