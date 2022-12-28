import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";


@Component({
  selector: "app-header",
  templateUrl: "./header.component.html",
  styleUrls: ["./header.component.css"],
})
export class HeaderComponent implements OnInit {

  public user = {
    id: 0,
    name: "",
  };

  constructor(
    private _http: HttpClient
  ) {}


  public ngOnInit(): void {
    //imaginar como this.api.getFotos()
    // this.getFotos().subscribe({
    //   next: (valor: IPhoto[]) => {
    //     console.log(valor);
    //   },
    //   error: (httpErro: HttpErrorResponse) => {
    //     console.log(httpErro);
    //   },
    // });
  }


  // public getFotos(): Observable<IPhoto[]> {
  //   return this._http.get<IPhoto[]>("/styles.css", {
  //     observe: "body",
  //     responseType: "json",
  //   });
  // }

}
