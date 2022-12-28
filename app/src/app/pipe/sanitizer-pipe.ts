import { Pipe, PipeTransform } from "@angular/core";
import { DomSanitizer } from "@angular/platform-browser";

@Pipe({
  name: "sanitizer",
})
export class SafePipe implements PipeTransform {
  constructor(private _sanitizer: DomSanitizer) {}

  transform(value: any, tipo?: string) {
    if ("url") {
        console.log('url ',value);
        return this._sanitizer.bypassSecurityTrustUrl(value);
    }
    return this._sanitizer.bypassSecurityTrustHtml(value);
  }
}
