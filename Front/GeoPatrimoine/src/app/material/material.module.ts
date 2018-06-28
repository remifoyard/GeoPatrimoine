import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';

@NgModule({
  imports: [
    CommonModule,MatToolbarModule,MatListModule
  ],
  declarations: [],
  exports:[MatToolbarModule,MatListModule]
})
export class MaterialModule { }
