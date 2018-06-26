import { Component, OnInit } from '@angular/core';
import { LeafletModule } from '@asymmetrik/ngx-leaflet';
import { latLng, LatLng, tileLayer, circle, polygon, marker, icon } from 'leaflet';
import 'leaflet/dist/images/marker-shadow.png';
import 'leaflet/dist/images/marker-icon.png';

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit {

  json:any = '[{"id":1,"nom":"Opéra de Lyon","description":"Le Grand Théâtre fut construit en 1756 par Jacques-Germain Soufflot (1713-1780 qui fit également à Paris le Panthéon, l’église Ste Geneviève, etc) et reconstruit de 1827 à 1831 par les architectes Chenavard et Pollet, il fut alors appelé Opéra.","horaires":"Samedi","telephone":472004500,"adresse":"1 Place de la Comédie","codePostal":"69001","commune":"Lyon","tarif":"13","tarifMin":"200","tarifMax":"13","geoTag":"4.836610,45.767793","lienImage":"opera_lyon.jpg","lienAudio":"opera.mp3"},{"id":2,"nom":"Basilique de Fourvière","description":"Cet édifice au style éclectique surplombe Lyon, forteresse mariale à l\'extérieur, ornée à l\'intérieur de mosaïques, vitraux et marbres. De l\'esplanade, la vue panoramique est imprenable. Visite insolite des toits incluse dans la Lyon City Card.","horaires":"Ouvert tous les jours. Basilique et crypte : de 8h à 19h. Chapelle : de 7h à 19h. Esplanade : de 6h à 21h30.","telephone":478251301,"adresse":"place de Fourvière","codePostal":"69005","commune":"Lyon","tarif":"Gratuit","tarifMin":"0","tarifMax":"0","geoTag":"4.822626,45.762293","lienImage":"basilique_fourviere_lyon.jpg","lienAudio":"basilique_fourviere_lyon.mp3"},{"id":3,"nom":"La Place Bellecour","description":"3ème plus grande place de France (après la Concorde à Paris et les Quinconces à Bordeaux), elle tire son nom de Bella Curia et renommée successivement place Louis-le-Grand, Place de la Fédération, place Bonaparte et enfin Place Bellecour en 1850.","horaires":"24h/24 7j/7","telephone":472776969,"adresse":"Place Bellecour","codePostal":"69002","commune":"Lyon","tarif":"Gratuit","tarifMin":"0","tarifMax":"0","geoTag":"4.832316,45.757796","lienImage":"place_bellecour.jpg","lienAudio":"place_bellecour.mp3"}]';
  layer:any;
  options:any;
  markers:any = [];

  constructor() {
    let obj = JSON.parse(this.json);

    for (let i of obj) {

      for (let obj2 in i) {
        if (obj2 == 'geoTag') {
          let longitude:any = i[obj2].split(',')[1];
          let latitude:any = i[obj2].split(',')[0];
          let nom:any = i['nom'];
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
            }).bindPopup('<b>'+ nom +'</b>').openPopup()
          );
        }
      }
    }
    this.options = {
      layers: [
        tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', { maxZoom: 18, attribution: '...' })
      ],
      zoom: 12.5,
      center: latLng(45.759012, 4.8351189)
    };
    if (this.markers != null) {
      this.layer = this.markers;
    }
  }

  ngOnInit() {
  }
}
