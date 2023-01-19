import { Component, Input, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { Observable, of } from "rxjs";
import { IClient } from "../interfaces";
import { ClientService } from "../services/client-service";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  clicked: boolean;

  clientNameFC = 'name'
  clients$: Observable<IClient[]> = of([
    { 
      id: 1,
      name: "oiee",
      createdAt: new Date(),
    },
  ])

  // photographerId should come from login service
  photographerId = 1;

  newClientForm = new FormGroup({
    [this.clientNameFC]: new FormControl(null, [Validators.required], [])
  })

  constructor(private clientSrv: ClientService) {}

  ngOnInit(): void {
    // fetch clients
    this.clients$ = this.clientSrv.getAll(this.photographerId)
   
  }

  currentTime = (): Date => new Date();

  newClient() {
    this.clicked = !this.clicked;
  }

  registerNewClient() {
    // send new client to db,
    const newClient$ = this.clientSrv.post({name: this.newClientForm.get(this.clientNameFC).value});
    // update this tab's client list.... how to load only the missing one instead of all the clients again ???
    this.clients$ = this.clientSrv.getAll(this.photographerId)
  }

  deleteClient() {
    
  }
}
