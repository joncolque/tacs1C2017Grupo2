import { Injectable } from '@angular/core';

@Injectable()
export class UserData {
  username: string;
  token: string

  setToken(unString: string): void {
    this.token = unString;
  }

  setUsername(unNombre: string): void {
    this.username = unNombre;
  }

  getToken(): string {
    return this.token;
  }

  getUsername(): string {
    return this.username;
  }
}
