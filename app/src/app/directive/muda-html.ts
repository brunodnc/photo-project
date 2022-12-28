import { Directive, ElementRef } from "@angular/core";

@Directive({
  selector: "[muda]",
})
export class MudaHtml {

  constructor(private el: ElementRef<any>) {
    this.el.nativeElement.style.backgroundColor = "yellow";
  }
}
