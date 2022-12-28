import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from "@angular/forms";
import { MatInputModule } from "@angular/material/input"
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatButtonModule } from '@angular/material/button';

import { NewPasswordComponent } from './new-password.component';

@NgModule({
    imports: [CommonModule, ReactiveFormsModule, MatInputModule, MatFormFieldModule, MatButtonModule],
    exports: [NewPasswordComponent],
    declarations: [NewPasswordComponent],
    providers: [],
})
export class NewPasswordModule { }
