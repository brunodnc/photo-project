import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params, Router } from "@angular/router";

@Component({
  selector: "client",
  templateUrl: "./client.component.html",
  styleUrls: ["./client.component.css"],
})
export class ClientComponent implements OnInit {
  openDialog = false;
  tabPassword: string = '';

  constructor(
    private _router: Router, 
    private _activatedRoute: ActivatedRoute
    ) {
      this._activatedRoute.params.subscribe((parametros:Params)=>{
        console.log(parametros);
      })
      this._activatedRoute.queryParams.subscribe((query:Params)=>{
        console.log(query);
      })
      /* this._activatedRoute.paramsMap
      this._activatedRoute.queryParams
      this._activatedRoute.queryParamsMap */
  }

  ngOnInit(): void {}
  
  tabs = [
    {
      id: 1,
      name: "Nome do album",
      photos: [{ id: 1, name: "nome da foto", path: "caminho da foto", watermark: false, date: '05/01/2016', print: true }, { id: 1, name: "nome da foto", path: "caminho da foto", watermark: false, date: '05/01/2016', print: false }, {}],
      link: '',
      locked: false,
      pwd: '',
    },
  ];

  // autenticar login do fotógrafo antes de carregar as fotos,
  // Load photo directories

  addTab() {
    // operação de adicionar nova aba, e consequentemente um novo album de fotos.
    this.tabs.push({
      id: 1,
      name: "Novo album de fotos",
      photos: [],
      link: '',
      locked: false,
      pwd: '',
    });
  }

  removeTab(index: number) {
    this.tabs.splice(index, 1);
  }

  generateLink() {
    // pede para gerar link (no servidor), recebe, salva no 'tabs local
    // faz update do database com base nesse tabs
    // mostra o link na tela
  }

  setWatermark(photoId, tabId) {
    const photo = this.tabs.find(t => t.id === tabId)
      .photos
      .find(p => p.id === photoId);
    photo.watermark = !photo.watermark;
  }

  deletePhoto(photoId, tabId) {
    const tab = this.tabs.find(t => t.id === tabId);
    tab.photos = tab.photos.filter(p => p.id !== photoId);
  }

  setAllWatermark(tabId) {
    const tab = this.tabs.find(t => t.id === tabId);
    tab.photos.map((p) => ({...p, watermark: !p.watermark}))
  }

  dialogToggle() {
    this.openDialog = !this.openDialog;
  }

  lockTab(tabId) {
    const tab = this.tabs.find(t => t.id === tabId);
    if (tab.locked) {
      tab.locked = false;
      tab.pwd = '';
    }
    if (!tab.locked) {
      tab.locked = true;
      tab.pwd = this.tabPassword;
    }
  }

  save() {
    // logica para salvar tudo e atualizar banco de dados
  }
}

