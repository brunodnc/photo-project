import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { IClient } from "../interfaces";
import { routeGetAllClients, routeGetClient, routePostClient } from "../utils/api-route";
import { BaseService } from "./base-service";

@Injectable({ providedIn: "root" })
export class ClientService extends BaseService {
  
    
    constructor(private http: HttpClient) {
        super()
    }

    getAll(photographerId: number): Observable<IClient[]> {
        return this.http.get<IClient[]>(this.baseUrl + routeGetAllClients + photographerId)
    }

    get(clientId: number): Observable<IClient> {
        return this.http.get<IClient>(this.baseUrl + routeGetClient + clientId);
    }

    post(client: IClient): Observable<IClient> {
        return this.http.post<IClient>(this.baseUrl + routePostClient, { client });
    }

    



}
