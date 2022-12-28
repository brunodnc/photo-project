 import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

import { RegisterComponent } from './register.component';

@NgModule({
    imports: [CommonModule, ReactiveFormsModule, FormsModule, MatInputModule, MatFormFieldModule, MatButtonModule],
    exports: [RegisterComponent],
    declarations: [RegisterComponent],
    providers: [],
})
export class RegisterModule{ }
