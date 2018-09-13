import { Component, OnInit ,Input} from '@angular/core';
import { ReadApiService } from '../read-api.service';

import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers:[ReadApiService]
})
export class ListComponent implements OnInit {
 

  title = 'app';
  arrData: string [];
  arrData2: string [];
url:string;
searchTag:string;
file='http://localhost:8080/api/patrimoineHistorique';
  constructor(private readApi : ReadApiService,private http: HttpClient) { }
 
  ngOnInit() {
   this.reset();
  }

reset(){
  this.readApi.findAll(this.file).subscribe(
    data => {
      this.arrData = data as string [];	 
    }
  );
}
ngDoCheck(){
  console.log(this.searchTag);
}
   
  search(){
    // this.url='http://localhost:8080/api/patrimoineHistoriqueTag/'+this.searchTag
   this.http.get('http://localhost:8080/api/patrimoineHistoriqueTag/'+this.searchTag).subscribe(response=>{
     this.arrData = response as string [];	   
     });
    
  
    
    }

  
   

}
