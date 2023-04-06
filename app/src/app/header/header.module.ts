import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { MatLegacyButtonModule as MatButtonModule } from "@angular/material/legacy-button";
import { MatLegacyPaginatorModule as MatPaginatorModule } from "@angular/material/legacy-paginator";
import { MatLegacyTableModule as MatTableModule } from "@angular/material/legacy-table";
import { RouterModule } from "@angular/router";
import { HeaderComponent } from "./header.component";

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, RouterModule, MatTableModule, MatPaginatorModule, HttpClientModule, MatButtonModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
