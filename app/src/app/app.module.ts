import { HttpClientModule } from "@angular/common/http";
import { APP_INITIALIZER, NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { NativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { BrowserModule } from "@angular/platform-browser";

import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { KeycloakAngularModule, KeycloakService } from "keycloak-angular";
import { initializer } from "src/app-init";
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
  declarations: [AppComponent,
    SafePipe,
    MudaHtml
   //kc
    // AccessDeniedComponent,
    // ManagerComponent,
    // AdminComponent,
  ],
  imports: [ BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule,
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
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [KeycloakService],
      multi: true,
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
