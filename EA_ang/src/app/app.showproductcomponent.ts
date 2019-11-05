import {Component, OnInit} from '@angular/core'
import {ProductService} from './_service/app.productservice'; 
import {Product} from './_model/app.product';

@Component({
    selector: 'showprod',
    templateUrl:`app.show.html`
})


export class ShowProductComponent{
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

    updateProduct(pro:any):any{
        this.update ={prodId:pro.prodId, prodCost:pro.prodCost, prodName:pro.prodName, prodDescription: pro.prodDescription};
    }

    updateProductInsert():any{
        for(let i = 0; i<this.productsList.length;i++){
            if(this.productsList[i].prodId == this.update.prodId){
                this.productsList[i] = this.update;
            }
        }
        this.update = null;
    }

}