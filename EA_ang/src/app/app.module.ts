import { NgModule, Component } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgxPaginationModule } from 'ngx-pagination';
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { DatePipe } from '@angular/common'
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router'
import { aboutUs } from './_component/app.aboutuscomponent';
import { HomeComponent } from './_component/app.homecomponent';
import { AddItem } from './_component/app.additem';
import { ShowEvents } from './_component/app.showevents';
import { AddEvent } from './_component/app.addevent';
import { ShowItems } from './_component/app.showitems';
import { AdminHome } from './_component/app.adminhome';
import { CustomerHome } from './_component/app.customerhome';
import { LiveEvent } from './_component/app.liveevent';
import { LoginComponent } from './_component/app.login';
import { RegisterComponent } from './_component/app.register';


const myroutes: Routes = [
    { path: '', component: HomeComponent, pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'admin', component: AdminHome },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'customer', component: CustomerHome },
    { path: 'additem', component: AddItem },
    { path: 'showitems', component: ShowItems },
    { path: 'addevent', component: AddEvent },
    { path: 'showevents', component: ShowEvents },
    { path: 'liveevent', component: LiveEvent },
    { path: 'aboutus', component: aboutUs }
]


@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,
        NgxPaginationModule,
        ConfirmationPopoverModule.forRoot({ confirmButtonType: 'danger' }),
        RouterModule.forRoot(myroutes)

    ],
    declarations: [
        AppComponent, HomeComponent, aboutUs, AddItem, ShowItems, ShowEvents, AddEvent, AdminHome, CustomerHome, LiveEvent, LoginComponent, RegisterComponent
    ],
    providers: [DatePipe],
    bootstrap: [AppComponent]
})

export class AppModule { }