import { NgModule, Component }      from '@angular/core'; 
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { ProductComponent } from './app.productcomponent';
import { ShowProductComponent} from './app.showproductcomponent';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router'
import { aboutUs } from './app,aboutuscomponent';

const myroutes: Routes=[
    {path : '', component: aboutUs,pathMatch:'full'},
    {path : 'aboutus', component: aboutUs},
    {path : 'show', component: ShowProductComponent},
    {path : 'add', component: ProductComponent}
]


@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,
        RouterModule.forRoot(myroutes)
        
    ],
    declarations: [
        AppComponent, ProductComponent, ShowProductComponent, aboutUs
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }