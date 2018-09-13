import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {RequestOptions, Request, Headers } from '@angular/http';

@Injectable()
export class ReadApiService {

  constructor(private http:HttpClient) { }
  arrData: string[] ;
//'http://localhost:8080/api/patrimoineHistorique'

	findAll(file: string){
		let requestOptions = new RequestOptions({ headers:null, withCredentials: true });
		return this.http.get(file,requestOptions || {} || {});}

}
