import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatTableModule } from "@angular/material/table";
import { HeaderComponent } from "./header.component";

@NgModule({
  declarations: [HeaderComponent],
  imports: [CommonModule, MatTableModule, MatPaginatorModule, HttpClientModule],
  exports: [HeaderComponent],
})
export class HeaderModule {}
