import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import {MaterialModule} from './material/material.module';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { ListComponent } from './list/list.component';
import { DialogComponent } from './dialog/dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    ListComponent,
    DialogComponent
  ],
  imports: [
    BrowserModule,LeafletModule.forRoot(),MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
