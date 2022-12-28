import { Component, OnInit } from "@angular/core";
import { AbstractControl, FormControl, FormGroup, ValidationErrors, Validators } from "@angular/forms";

@Component({
  selector: "register",
  templateUrl: "register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  public passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  public usernameRegex = /^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$/;

  public nameFC = "name";
  public emailFC = "email";
  public usernameFC = "username";
  public passwordFC = "password";
  public password2FC = "password2";
  public registered = false;

  public registerForm = new FormGroup({
    [this.nameFC]: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required],
    }),
    [this.emailFC]: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required, Validators.email],
    }),
    [this.usernameFC]: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required, Validators.pattern(this.usernameRegex)],
    }),
    [this.passwordFC]: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required, Validators.pattern(this.passwordRegex)],
    }),
    [this.password2FC]: new FormControl("", {
      nonNullable: true,
      validators: [Validators.required, Validators.pattern(this.passwordRegex)],
    }),
  });

  constructor() {}

  ngOnInit() {}

  differentPassword = (control: AbstractControl): ValidationErrors | null =>
    control.value !== this.registerForm.get(this.password2FC).value ? { differentPassword: true } : null;

  register = () => {
    const { name, email, username, password } = this.registerForm.controls;
    if (this.registerForm.invalid) return
    // lógica de enviar cadastrar
    this.registered = true;
  };
}
