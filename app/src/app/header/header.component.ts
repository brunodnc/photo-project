import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { Component, DoCheck, Input, OnChanges, OnDestroy, OnInit, SimpleChanges, ViewChild } from "@angular/core";
import { MatPaginator, PageEvent } from "@angular/material/paginator";
import { MatTableDataSource } from "@angular/material/table";
import { Observable } from "rxjs";
import { IPhoto } from "../interfaces";

type Pessoa = {
  nome: string;
  idade: number;
};

@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnChanges, OnInit, DoCheck, OnDestroy {
  /**boolean */
  private _boleano = true;
  /**array */
  colunas = ["nome", "idade"];
  /**angular */
  datasource = new MatTableDataSource<Pessoa>([]);

  @ViewChild("paginador", { static: true })
  public set paginator(paginador: MatPaginator) {
    this.datasource.paginator = paginador;
  }

  @Input()
  titulo = "valor anterior";

  count = 0;

  public user = {
    id: 0,
    name: "",
  };

  constructor(
    /* private d:ChangeDetectorRef, */
    private _http: HttpClient
  ) {}

  public ngOnChanges(changes: SimpleChanges): void {}

  public ngDoCheck(): void {
    this.increment();
  }

  public ngOnInit(): void {
    //imaginar como this.api.getFotos()
    this.getFotos().subscribe({
      next: (valor: IPhoto[]) => {
        console.log(valor);
      },
      error: (httpErro: HttpErrorResponse) => {
        console.log(httpErro);
      },
    });

    this.datasource.data = [
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
      {
        nome: "joao",
        idade: 27,
      },
    ];
    this.boleano = false;
  }

  public ngOnDestroy(): void {}

  public increment() {
    this.count++;
  }

  public mudouPagina(evento: PageEvent) {
    console.log(evento);
  }

  public getFotos(): Observable<IPhoto[]> {
    return this._http.get<IPhoto[]>("/styles.css", {
      observe: "body",
      responseType: "json",
    });
  }

  /** get set  */

  public get boleano() {
    return this._boleano;
  }

  public set boleano(valor: boolean) {
    this._boleano = valor;
  }
}
