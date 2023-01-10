import { InjectionToken } from "@angular/core";

export interface IPhoto {
  id?: number;
  file_name: string;
  path: string;
  watermark: boolean;
  print: boolean;
  downloaded: boolean;
  createdAt: Date;
  tab: string;
}

export interface ITab {
  id?: number;
  name: string;
  photos: IPhoto[];
  url: string;
  locked: boolean;
  password: string;
  downloadLimit: number;
  watermark: boolean;
}

export interface IClient {
  id?: number;
  name: string;
  tabs?: ITab[];
  createdAt?: Date;
  updatedAt?: Date;
  photographer?: IPhotographer

}

export interface IPhotographer {
  id?: number;
  name: string;
  username: string;
  email: string;
  password?: string;
  clients?: IClient[];
  subscription?: string;
  disk?: { size: number, totalSize: number };
}

export interface ISubscription {
  id?: string;
  name: string;
}

const token = new InjectionToken<IPhoto>("TESTE");
