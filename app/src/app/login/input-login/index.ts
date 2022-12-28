import { Component, Host, OnInit, Optional, Self, SkipSelf } from "@angular/core";
import { ServicoUm } from "src/app/services/servico1";

@Component({
  selector: "input-login",
  templateUrl: "./index.html",
  styleUrls: ["./index.css"],
})
export class InputLoginComponent implements OnInit {
  constructor(
    /* @SkipSelf()
    @Self()
    @Optional()
    @Host() */
    private _servico: ServicoUm
  ) {}

  ngOnInit(): void {
    console.log(this._servico.contador);
  }
}
