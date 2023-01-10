import { Component, OnInit } from "@angular/core";
import { AbstractControl, FormControl, FormGroup, ValidationErrors, Validators } from "@angular/forms";
import { IPhotographer } from "../interfaces";
import { PhotographerService } from "../services/photographer-service";

@Component({
  selector: "register",
  templateUrl: "register.component.html",
  styleUrls: ["./register.component.css"],
})
export class RegisterComponent implements OnInit {
  public passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  public nameFC = "name";
  public emailFC = "email";
  public usernameFC = "username";
  public passwordFC = "password";
  public password2FC = "password2";
  public registered = false;

  public registerForm = new FormGroup({
    [this.nameFC]: new FormControl("", {
      nonNullable: true,
      // validators: [Validators.required],
    }),
    [this.emailFC]: new FormControl("", {
      nonNullable: true,
      // validators: [Validators.required, Validators.email],
    }),
    [this.usernameFC]: new FormControl("", {
      nonNullable: true,
      // validators: [Validators.required, Validators.maxLength(15), Validators.minLength(5)],
    }),
    [this.passwordFC]: new FormControl("", {
      nonNullable: true,
      // validators: [Validators.required, Validators.pattern(this.passwordRegex)],
    }),
    [this.password2FC]: new FormControl("", {
      nonNullable: true,
      // validators: [Validators.required, Validators.pattern(this.passwordRegex)],
    }),
  });

  constructor(private photographerService: PhotographerService) {}

  ngOnInit() {}

  differentPassword = (control: AbstractControl): ValidationErrors | null =>
    control.value !== this.registerForm.get(this.password2FC).value ? { differentPassword: true } : null;

  register(): void {
    const { name, email, username, password, password2 } = this.registerForm.value;
    if (this.registerForm.invalid) return
    // lógica de enviar cadastrar
    console.log(name, email, username, password, password2);
    const photographer: IPhotographer = {
      name, email, username, password 
    }
    this.photographerService.post(photographer)    
    this.registered = true;
  };
}
