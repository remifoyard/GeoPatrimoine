

import {HttpClient} from '@angular/common/http';


import { Component, OnInit } from '@angular/core';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { latLng, LatLng, tileLayer, circle, polygon, marker, icon } from 'leaflet';
import 'leaflet/dist/images/marker-shadow.png';
import 'leaflet/dist/images/marker-icon.png';
import { ReadApiService } from '../read-api.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
  providers:[ReadApiService]
})
export class ListComponent implements OnInit {
 

  latilong:string[];
  longi:string[];
  coord:string;
  layer:any;
  options:any;
  markers:any = [];
  fileSub:string[];
fileId:string;
  title = 'app';
  arrData: string [];
  arrData2: string [];
url:string;
searchTag:string;
file='http://localhost:8080/api/patrimoineHistorique';
  constructor(private readApi : ReadApiService,private http: HttpClient) {

    this.options = {
      layers: [
        tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { maxZoom: 18, attribution: '...' })
      ],
      zoom: 12.5,
      center: latLng(45.759012, 4.8351189)
    };
   }
 
  ngOnInit() {
   this.reset();
   this.readApi.findAll(this.file).subscribe(
    data => {
      /*this.arrData = data as string [];	*/
      this.donneesChargees(data);
    }/*,
    (err: HttpErrorResponse) => {
      le.log (err.message);

    }*/
  );
  }

reset(){
  this.readApi.findAll(this.file).subscribe(
    data => {
      this.arrData = data as string [];	 
    }
  );
}

  search(){
    // this.url='http://localhost:8080/api/patrimoineHistoriqueTag/'+this.searchTag
   this.http.get('http://localhost:8080/api/patrimoineHistoriqueTag/'+this.searchTag).subscribe(response=>{
     this.arrData = response as string [];	   
     });
    
  
    
    }


    
  donneesChargees(data){
   
       let obj =data;
    
    
        for (let i of obj) {
    
          for (let obj2 in i) {
            if (obj2 == 'geoTag') {
              let longitude:any = i[obj2].split(',')[1];
              let latitude:any = i[obj2].split(',')[0];
              let nom:any = i['nom'];
              let id:any=i['id'];
              let description:any = i['description'];
              let lienImage:any = i['lienImage'];
              let horaires:any = i['horaires'];
              let adresse:any = i['adresse'];
              let codePostal:any = i['codePostal'];
              let commune:any = i['commune'];
              let telephone:any = i['telephone'];
              let tarif:any = i['tarif'];
              let lienAudio:any = i['lienAudio'];
    
              let textNom = '';
    
              if (nom != null && nom !== 0) {
                textNom = '<b>' + nom + '</b>';
              }


              
              let idM = '';
    
              if (nom != null && nom !== 0) {
                idM = id ;
              }

              
    
              let textDescription = '';
    
              if (nom != null && nom !== 0) {
                textDescription = '<br><br>' + description;
              }
    
              let textHoraires = '';
    
              if (horaires != null && horaires !== 0) {
                textHoraires = '<br><br>' + horaires;
              }
    
              let textTelephone = '';
    
              if (telephone != null && telephone !== 0) {
                textTelephone = '<br>0' + telephone;
              }
    
              let textTarif = '';
    
              if (tarif != null && tarif !== 0 && tarif !== 'Gratuit') {
                textTarif = '<br><b>Tarif : </b>' + tarif + '€';
              } else if (tarif === 'Gratuit') {
                textTarif = '<br><b>Tarif : </b>' + tarif;
              }
    
              let adresseComplete ='<br>';
    
              if (adresse != null && adresse !== 0) {
                adresseComplete += adresse;
              }
    
              if (codePostal != null && codePostal !== 0) {
                adresseComplete += ' ' + codePostal;
              }
    
              if (commune != null && commune !== 0) {
                adresseComplete += ' ' + commune;
              }
    
              let image = '';
    
              if (lienImage != null && lienImage !== 0) {
                image = '<br><br><div style="float: left; width: 120px; height:80px;"><img src="./assets/' + lienImage + '" width="100px" /></div><div>' + textTelephone + textTarif + adresseComplete + '</div><div style="clear: both;"></div>';
              }
    
              let textAudio = '';
    
              if (lienAudio != null && lienAudio !== 0) {
                textAudio = '<br><audio id="t-rex-roar" controls src="./assets/' + lienAudio + '"> Your browser does not support the <code>audio</code> element.</audio>';
              }
    
            
    
              this.markers.push(
                marker([longitude, latitude], {
                  icon: icon({
                    iconSize: [40, 41],
                   
                    iconAnchor: [0, 0],
                    popupAnchor: [20, 10],
                    iconUrl: 'assets/Logo-GeoPatrimoine.svg',
                    shadowUrl: 'assets/marker-shadow.png'
                  })
                }).bindPopup(idM+' '+textNom + textDescription + image  + textAudio).openPopup()
              );
            }
          }
        }
    
        if (this.markers != null) {
          this.layer = this.markers;
        }
      }
  
   show(id){
   let i=0;
     console.log(this.markers);
    console.log(this.markers[0]._popup._content);

    
     console.log(id.srcElement.textContent);
     this.fileSub=id.srcElement.textContent.split([";"]);
     console.log(this.fileSub[0]);
  
this.coord =this.fileSub[0];
this.latilong=this.coord.split(",");
   console.log(this.latilong);
   
 

   this.markers.forEach(element => {
     console.log(this.latilong[1]);
   
if(element._latlng.lat==this.latilong[1]  ){
  if(element._latlng.lng==this.latilong[0] ){
console.log("ça marche "+element._latlng.lng+ " "+this.latilong[1]);
console.log("ça marche "+element._latlng.lat+ " "+this.latilong[0]);
//this.markers[this.i].openPopup();
this.markers[i].openPopup();
console.log(i);

  }
 
}
i++;
console.log(i);
     console.log(element._latlng.lat);
     console.log(element._latlng.lng);
     
   });
   }

  

}
