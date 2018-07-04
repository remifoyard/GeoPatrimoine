import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import {MaterialModule} from './material/material.module';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { ListComponent } from './list/list.component';
import { DialogComponent, DialogOverviewExampleDialog } from './dialog/dialog.component';
import {MatInputModule} from '@angular/material';
import { AppRoutingModule } from './app-routing/app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    ListComponent,
    DialogComponent,
    DialogOverviewExampleDialog
  ],
  imports: [
    BrowserModule,LeafletModule.forRoot(),MaterialModule,BrowserAnimationsModule,FormsModule,MatInputModule, AppRoutingModule
  ],
  providers: [DialogOverviewExampleDialog],
  entryComponents:[DialogOverviewExampleDialog],
  bootstrap: [AppComponent]
})
export class AppModule { }
