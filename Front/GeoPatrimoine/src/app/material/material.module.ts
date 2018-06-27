import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatToolbarModule} from '@angular/material/toolbar';

@NgModule({
  imports: [
    CommonModule,MatToolbarModule
  ],
  declarations: [],
  exports:[MatToolbarModule]
})
export class MaterialModule { }
