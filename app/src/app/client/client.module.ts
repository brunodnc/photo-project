import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { MatLegacyTabsModule as MatTabsModule } from "@angular/material/legacy-tabs";
import { MatLegacyCardModule as MatCardModule } from "@angular/material/legacy-card";
import { MatIconModule } from "@angular/material/icon";
import { MatLegacyTooltipModule as MatTooltipModule } from "@angular/material/legacy-tooltip";
import { ClientComponent } from "./client.component";
import { RouterModule, Routes } from "@angular/router";
import { MatLegacyInputModule as MatInputModule } from "@angular/material/legacy-input";
import { FormsModule } from "@angular/forms";
import { ClientHashComponent } from "./client-hash/client-hash.component";
import { MatLegacyButtonModule as MatButtonModule } from "@angular/material/legacy-button";

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
