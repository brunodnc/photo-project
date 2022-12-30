import { Component, OnInit } from "@angular/core";
import { FormControl, FormGroup, Validators } from "@angular/forms";
import { IPhotographer } from "../interfaces";

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

  constructor() {}

  ngOnInit(): void {
    // get username, get user.clients.length, get disk total size, get disk size
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
