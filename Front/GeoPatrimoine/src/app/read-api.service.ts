import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ReadApiService {

  constructor(private http:HttpClient) { }
  arrData: string[] ;
//'http://localhost:8080/api/patrimoineHistorique'
findAll(file: string){
   return this.http.get(file);}

}
