import { Component } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  arrData: string [];
  arrData2: string [];
url:string;

searchTag="four";
  constructor(private http: HttpClient){

  }
  

  ngOnInit(){
    this.http.get('http://localhost:8080/api/patrimoineHistorique').subscribe(response=>{
      this.arrData = response as string [];	   
    console.log(response[0].nom)});

  }


  





}
