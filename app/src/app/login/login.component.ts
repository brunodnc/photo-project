import { Component, OnInit } from "@angular/core";
import { AbstractControl, FormControl, FormGroup, ValidationErrors, Validators } from "@angular/forms";
import { Observable, of } from "rxjs";
import { ServicoUm } from "../services/servico1";

@Component({
  selector: "login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
  providers: [ServicoUm],
})
export class LoginComponent implements OnInit {
  /**string */
  public usernameFC = "username";
  public passwordFC = "password";
  /**array */
  private _usuariosJaExistentes = ["brunodnc", "balthus", "jaoKun", "coxa"];
  /**objeto */
  public atributos = {
    forca: 0,
    vitalidade: 0,
  };

  /**angular */
  public loginForm = new FormGroup({
    [this.usernameFC]: new FormControl(
      null,
      [Validators.required],
      [this.registeredUserCheck.bind(this)]
      /* [this.funcaoAsync()] */
    ),
    [this.passwordFC]: new FormControl(null, [Validators.required, Validators.minLength(8)], []),
  });

  constructor(private _servico: ServicoUm) {}

  ngOnInit(): void {
    console.log(this._servico.contador += 10);
    // exemplo de pipe e validação asyncrona
    //   this.loginForm
    //     .get(this.usernameFC)
    //     .valueChanges.pipe(
    //       filter(() => {
    //         return this.loginForm.get(this.usernameFC).valid;
    //       }),
    //       map((valor: any) => {
    //         return valor + " transformado";
    //       })
    //       tap((valor:any)=>{}),
    //       debounceTime(2000)
    //     )
    //     .subscribe((valor: any) => {
    //       console.log(valor);
    //     });
    // }
    // funcaoAsync(): AsyncValidatorFn {
    //   return (control: AbstractControl): Observable<ValidationErrors | null> => {
    //     return null;
    //   };
    // }
    // validacaoUsuarioAssincrono(control: AbstractControl): Observable<ValidationErrors | null> {
    //   const valorInput = control.value;
    //   let usuarioJaExiste: boolean;
    //   if (this._usuariosJaExistentes.includes(valorInput)) {
    //     usuarioJaExiste = true;
    //   }
    //   return usuarioJaExiste ? of({ jaExiste: true }) : of(null);
  }

  // fora do onInit ??
  registeredUserCheck(control: AbstractControl): Observable<ValidationErrors | null> {
    const { value } = control;
    let registeredUsernames: string[]; // get registered usernames
    return registeredUsernames.includes(value) ? of({ registered: true }) : of({ unregistered: true });
  }

  // acho que não está sendo usado esse get.
  // get username() {
  //   return this.loginForm.get("name");
  // }

  // get password() {
  //   return this.loginForm.get("password");
  // }

  login() {
    if (this.loginForm.invalid) return;
    const { username, password } = this.loginForm.value;
    // const token = validateLogin();
    // save token as dependency?
    // route to home when login operations are done
  }

  /* 
  loginFormsModule(form:NgForm):void{
    console.log(form.value);
  } */

  // loginFormsModule(): void {
  //   console.log(this.atributos);
  // }
}
