import { Component, OnInit } from '@angular/core';
import { ReadApiService } from '../read-api.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers:[ReadApiService]
})
export class ListComponent implements OnInit {
public arrData: string [];
  constructor(private readApi : ReadApiService) { }

  ngOnInit() {
    this.readApi.findAll().subscribe(
      data => {
        this.arrData = data as string [];	 
      }/*,
      (err: HttpErrorResponse) => {
        console.log (err.message);
       
      }*/
    );
  }

}
