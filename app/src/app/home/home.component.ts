import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { IClient } from "../interfaces";

@Component({
  selector: "app-home",
  templateUrl: "./home.component.html",
  styleUrls: ["./home.component.css"],
})
export class HomeComponent implements OnInit {
  clicked: boolean;

  clientNameFC = 'name'
  clients: IClient[] = [
    { 
      id: 1,
      name: "oiee",
      createdAt: new Date(),
    },
  ];

newClientForm = new FormGroup({
  [this.clientNameFC]: new FormControl(null, [Validators.required], [])
})

  constructor() {}

  async getClients(): Promise<IClient[]> {
    // const clientList = await fetch();
    return [
      {
        id: 2,
        name: "oi",
        createdAt: new Date(),
      },
    ];
  }

  ngOnInit(): void {
    // fetch clients
    this.getClients().then((data) => (this.clients = data));
  }

  currentTime = (): Date => new Date();

  newClient() {
    this.clicked = !this.clicked;
  }

  registerNewClient() {
    // send new client to db,
    // update this tab's client list
  }
}
