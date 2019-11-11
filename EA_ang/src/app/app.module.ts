import { NgModule, Component }      from '@angular/core'; 
import { BrowserModule } from '@angular/platform-browser';
import { NgxPaginationModule } from 'ngx-pagination';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { AppComponent }  from './app.component';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes} from '@angular/router'
import { aboutUs } from './_component/app.aboutuscomponent';
import { HomeComponent } from './_component/app.homecomponent';
import { AddItem } from './_component/app.additem';
import { ShowEvents } from './_component/app.showevents';
import { AddEvent } from './_component/app.addevent';

const myroutes: Routes=[
    {path : '', component: HomeComponent,pathMatch:'full'},
    {path: 'home', component: HomeComponent},
    {path : 'additem', component: AddItem},
    
    {path : 'addevent', component: AddEvent},
    {path : 'showevents', component: ShowEvents},
    
    {path : 'aboutus', component: aboutUs}
]


@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,
        NgxPaginationModule,
        ConfirmationPopoverModule.forRoot({ confirmButtonType: 'danger' }),
        RouterModule.forRoot(myroutes)
        
    ],
    declarations: [
        AppComponent, HomeComponent, aboutUs, AddItem, ShowEvents, AddEvent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }