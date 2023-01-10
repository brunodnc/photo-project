import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IPhotographer } from "../interfaces";
import { routePostPhotographer } from "../utils/api-route";
import { BaseService } from "./base-service";

@Injectable({ providedIn: "root" })
export class PhotographerService extends BaseService {
  
    
    constructor(private http: HttpClient) {
        super()
    }

    post(photographer: IPhotographer): Observable<IPhotographer> {
        return this.http.post<IPhotographer>(this.baseUrl + routePostPhotographer, { photographer });
    }

    



}
