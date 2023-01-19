import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { IPhotographer } from "../interfaces";
import { PhotographerService } from "../services/photographer-service";

@Component({
  selector: "app-profile",
  templateUrl: "./profile.component.html",
  styleUrls: ["./profile.component.css"],
})
export class ProfileComponent implements OnInit {
  public passwordFC = "oldPassword";
  public newPasswordFC = "newPassword";
  public toggledPasswordChange = false;
  public wrongPassword = false;
  public success = false;

  public user: IPhotographer

  public passwordChange = new FormGroup({
    [this.passwordFC]: new FormControl(null, [Validators.required], []),
    [this.newPasswordFC]: new FormControl(null, [Validators.required], []),
  });

  constructor(
    private photographerSrv: PhotographerService,
  ) {}

  ngOnInit(): void {
    // get username, get user.clients.length, get disk total size, get disk size
    // const photographerId = get photographer id from login service
    // this.user = this.photographerSrv.get(photographerId)
    
  }

  tooglePasswordChange() {
    this.toggledPasswordChange = true;
  }

  changePassword() {
    const oldPassword = this.passwordChange.get(this.passwordFC).value;
    const newPassword = this.passwordChange.get(this.newPasswordFC).value;
    // wrongPassword = checkPassword(password)

    // change password logic
    // const toggledPasswordChange = false;
    // const success = true;
  }
}
