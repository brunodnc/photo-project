import { Component, OnInit } from '@angular/core';
import { IClient, ITab } from 'src/app/interfaces';

@Component({
  selector: 'app-client-hash',
  templateUrl: './client-hash.component.html',
  styleUrls: ['./client-hash.component.css']
})
export class ClientHashComponent implements OnInit {
  tab: ITab;
  client: IClient;
  downloadCounter: number = 0;
  printClicked: boolean;
  printCount: number = 0;

  constructor() { }

  ngOnInit(): void {
    // carrega os dados do cliente,
    // carrega as fotos da pasta
    // this.tab = {}
  }

  setPrint(photoId) {
    const photo = this.tab.photos.find(p => p.id === photoId);
    photo.print = !photo.print;
  }

  setDownload(photoId) {
    const photo = this.tab.photos.find(p => p.id === photoId);
    if (photo.download === false) {
      this.downloadCounter += 1;
    }
    if (photo.download === true) {
      this.downloadCounter -= 1;
    }
    photo.download = !photo.download;
  }



  download() {
    const photosToDownload = this.tab.photos.filter(p => p.download);
    // enviar para o servidor o pedido com as fotos
    // verificar no servidor se a quantidade é igual o downloadLimit da pasta
    // travar a pasta estabelecer lock = true ?? criar um middleware para checar essa trava de download;
  }

  print() {
    this.printCount = this.tab.photos.filter(f => f.print).length;
    this.printClicked = true;
    // update database print photo
  }
}
