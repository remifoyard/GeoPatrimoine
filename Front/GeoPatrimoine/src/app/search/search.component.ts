import { Component, OnInit } from '@angular/core';
import { ReadApiService } from '../read-api.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  providers:[ReadApiService]
})
export class SearchComponent  {

tag="basi";
  constructor(private readApi : ReadApiService) { }

  
}
