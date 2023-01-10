import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { MAT_DATE_FORMATS, MAT_DATE_LOCALE, NativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { BrowserModule } from "@angular/platform-browser";

import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { MudaHtml } from "./directive/muda-html";
import { HeaderModule } from "./header/header.module";
import { HomeModule } from "./home/home.module";
import { LoginModule } from "./login/login.module";
import { SafePipe } from "./pipe/sanitizer-pipe";
import { ProfileModule } from "./profile/profile.module";
import { RegisterModule } from "./register/register.module";

@NgModule({
  declarations: [AppComponent,SafePipe,MudaHtml],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginModule,
    RegisterModule,
    HomeModule,
    HeaderModule,
    BrowserAnimationsModule,
    NativeDateModule,
    MatDatepickerModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatInputModule,
    HeaderModule,
    ProfileModule,
    HttpClientModule,
  ],
  bootstrap: [AppComponent],
  providers: [
    {
      provide: "TESTE",
      useFactory: () => {},
    },
    { provide: MAT_DATE_LOCALE, useValue: "pt-BR" },
    {
      provide: MAT_DATE_FORMATS,
      useValue: {
        parse: {
          dateInput: ["l", "LL"],
        },
        display: {
          dateInput: "LLL",
          monthYearLabel: "llll",
          dateA11yLabel: "LL",
          monthYearA11yLabel: "MMMM YYYY",
        },
      },
    },
  ],
})
export class AppModule {}
