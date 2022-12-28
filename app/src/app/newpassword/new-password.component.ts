import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'new-password',
    templateUrl: 'new-password.component.html',
    styleUrls: ['new-password.component.css']
})

export class NewPasswordComponent implements OnInit {
    public emailFC = 'email';
    public unregisteredEmail = 'false';
    
    constructor() { }

    ngOnInit(): void { }

    public sent = false;
    public newPasswordForm = new FormGroup({
        [this.emailFC]: new FormControl("", { 
            nonNullable: true,
            validators: [
              Validators.required,
              Validators.email,
              ] } )
    })

    newPassword = (): void => {
        if (this.newPasswordForm.invalid) return
        const email = this.newPasswordForm.get(this.emailFC).value;
        // this.unregisteredEmail = checkEmail(email); Checa se o e-mail está cadastrado e retorna verdadeiro se ele não estiver cadastrado
        
        // logica pra enviar e-mail com nova senha
        this.sent = true;
        this.newPasswordForm.reset();
        return undefined
    }
}