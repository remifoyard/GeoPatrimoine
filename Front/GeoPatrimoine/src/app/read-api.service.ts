import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ReadApiService {

  constructor(private http:HttpClient) { }
  arrData: string[] ;

findAll(){
   return this.http.get('http://localhost:8080/api/patrimoineHistorique');}

}
