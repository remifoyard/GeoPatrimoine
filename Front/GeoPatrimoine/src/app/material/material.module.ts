import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatDialogModule, MAT_DIALOG_DATA,MAT_DIALOG_DEFAULT_OPTIONS} from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';

@NgModule({
  imports: [
    CommonModule,MatToolbarModule,MatListModule,MatDialogModule,MatFormFieldModule
  ],
  providers: [{provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {hasBackdrop: true}}],
  declarations: [],
  exports:[MatToolbarModule,MatListModule,MatDialogModule,MatFormFieldModule]
})
export class MaterialModule { }
