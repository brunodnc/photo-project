import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MatTabsModule } from "@angular/material/tabs";
import { MatCardModule } from "@angular/material/card";
import { MatIconModule } from "@angular/material/icon";
import { MatTooltipModule } from "@angular/material/tooltip";
import { ClientComponent } from "./client.component";
import { RouterModule, Routes } from "@angular/router";
import { MatInputModule } from "@angular/material/input";
import { FormsModule } from "@angular/forms";
import { ClientHashComponent } from "./client-hash/client-hash.component";
import { MatButtonModule } from "@angular/material/button";

const routes: Routes = [
  {
    path: ":id",
    component: ClientComponent,
  },
  {
    path: ":id/:hash",
    component: ClientHashComponent,
  },
];

@NgModule({
  declarations: [ClientComponent, ClientHashComponent],
  imports: [
    CommonModule,
    MatButtonModule,
    MatTabsModule,
    RouterModule.forChild(routes),
    MatCardModule,
    MatIconModule,
    MatTooltipModule,
    MatInputModule,
    FormsModule,
  ],
  exports: [ClientComponent, ClientHashComponent],
})
export class ClientModule {}
