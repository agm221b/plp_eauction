import { NgModule, Component }      from '@angular/core'; 
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router'
import { aboutUs } from './_component/app,aboutuscomponent';
import { HomeComponent } from './_component/app.homecomponent';
import { AddItem } from './_component/app.additem';

const myroutes: Routes=[
    {path : '', component: HomeComponent,pathMatch:'full'},
    {path: 'home', component: HomeComponent},
    {path : 'additem', component: AddItem},
    {path : 'aboutus', component: aboutUs}
]


@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,
        RouterModule.forRoot(myroutes)
        
    ],
    declarations: [
        AppComponent, HomeComponent, aboutUs, AddItem
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }