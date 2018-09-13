import { Component, OnInit } from '@angular/core';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { latLng, LatLng, tileLayer, circle, polygon, marker, icon } from 'leaflet';
import 'leaflet/dist/images/marker-shadow.png';
import 'leaflet/dist/images/marker-icon.png';
import { ReadApiService } from '../read-api.service';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css'],
  providers: [ReadApiService]
})
export class MapComponent implements OnInit {

  //json:any = '[{"id":1,"nom":"Opéra de Lyon","description":"Le Grand Théâtre fut construit en 1756 par Jacques-Germain Soufflot (1713-1780 qui fit également à Paris le Panthéon, l’église Ste Geneviève, etc) et reconstruit de 1827 à 1831 par les architectes Chenavard et Pollet, il fut alors appelé Opéra.","horaires":"Samedi","telephone":472004500,"adresse":"1 Place de la Comédie","codePostal":"69001","commune":"Lyon","tarif":"13","tarifMin":"200","tarifMax":"13","geoTag":"4.836610,45.767793","lienImage":"opera_lyon.jpg","lienAudio":"opera.mp3"},{"id":2,"nom":"Basilique de Fourvière","description":"Cet édifice au style éclectique surplombe Lyon, forteresse mariale à l\'extérieur, ornée à l\'intérieur de mosaïques, vitraux et marbres. De l\'esplanade, la vue panoramique est imprenable. Visite insolite des toits incluse dans la Lyon City Card.","horaires":"Ouvert tous les jours. Basilique et crypte : de 8h à 19h. Chapelle : de 7h à 19h. Esplanade : de 6h à 21h30.","telephone":478251301,"adresse":"place de Fourvière","codePostal":"69005","commune":"Lyon","tarif":"Gratuit","tarifMin":"0","tarifMax":"0","geoTag":"4.822626,45.762293","lienImage":"basilique_fourviere_lyon.jpg","lienAudio":"basilique_fourviere_lyon.mp3"},{"id":3,"nom":"La Place Bellecour","description":"3ème plus grande place de France (après la Concorde à Paris et les Quinconces à Bordeaux), elle tire son nom de Bella Curia et renommée successivement place Louis-le-Grand, Place de la Fédération, place Bonaparte et enfin Place Bellecour en 1850.","horaires":"24h/24 7j/7","telephone":472776969,"adresse":"Place Bellecour","codePostal":"69002","commune":"Lyon","tarif":"Gratuit","tarifMin":"0","tarifMax":"0","geoTag":"4.832316,45.757796","lienImage":"place_bellecour.jpg","lienAudio":"place_bellecour.mp3"}]';
  layer:any;
  options:any;
  markers:any = [];



  public arrData: string [];
  constructor(private readApi : ReadApiService) {
    this.options = {
      layers: [
        tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { maxZoom: 18, attribution: '...' })
      ],
      zoom: 12.5,
      center: latLng(45.759012, 4.8351189)
    };
  }
  file='http://localhost:8080/api/patrimoineHistorique';
  ngOnInit() {

    this.readApi.findAll(this.file).subscribe(
      data => {
        /*this.arrData = data as string [];	*/
        this.donneesChargees(data);
      }/*,
      (err: HttpErrorResponse) => {
        console.log (err.message);

      }*/
    );
  }

  donneesChargees(data){
console.log(data);
   let obj =data;
console.log(obj);

    for (let i of obj) {

      for (let obj2 in i) {
        if (obj2 == 'geoTag') {
          let longitude:any = i[obj2].split(',')[1];
          let latitude:any = i[obj2].split(',')[0];
          let nom:any = i['nom'];
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

          console.log(nom);

          this.markers.push(
            marker([longitude, latitude], {
              icon: icon({
                iconSize: [40, 41],
                iconAnchor: [0, 0],
                popupAnchor: [20, 10],
                iconUrl: 'assets/Logo-GeoPatrimoine.svg',
                shadowUrl: 'assets/marker-shadow.png'
              })
            }).bindPopup(textNom + textDescription + image  + textAudio).openPopup()
          );
        }
      }
    }

    if (this.markers != null) {
      this.layer = this.markers;
    }
  }
}
