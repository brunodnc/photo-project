import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { ServicoUm } from "../services/servico1";

@Component({
  selector: "login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"],
})
export class LoginComponent implements OnInit {
  /**string */
  public usernameFC = "username";
  public passwordFC = "password";
  /**objeto */
  public atributos = {
    forca: 0,
    vitalidade: 0,
  };

  /**angular */
  public loginForm = new FormGroup({
    [this.usernameFC]: new FormControl(null, [Validators.required], []),
    [this.passwordFC]: new FormControl(null, [Validators.required, Validators.minLength(8)], []),
  });

  constructor() {}

  ngOnInit(): void {}

  login() {
    if (this.loginForm.invalid) return;
    const { username, password } = this.loginForm.value;
  }
}
