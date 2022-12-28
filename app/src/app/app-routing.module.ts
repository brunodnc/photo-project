import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { ClientModule } from "./client/client.module";
import { HomeComponent } from "./home/home.component";
import { LoginComponent } from "./login/login.component";
import { NewPasswordComponent } from "./newpassword/new-password.component";
import { ProfileComponent } from "./profile/profile.component";
import { RegisterComponent } from "./register/register.component";

const routes: Routes = [
  { path: "login", component: LoginComponent },
  { path: "home", component: HomeComponent },
  { path: "new-password", component: NewPasswordComponent },
  { path: "register", component: RegisterComponent },
  { path: "profile", component: ProfileComponent },
  {
    path: "client",
    loadChildren: () => ClientModule,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
