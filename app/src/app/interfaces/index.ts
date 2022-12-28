import { InjectionToken } from "@angular/core";

export interface ITab {
  id: number;
  name: string;
  photos: IPhoto[];
  link: string;
  locked: boolean;
  pwd: string;
  hash?: string;
  downloadLimit: number;
  lock?: boolean;
}

export interface IPhoto {
  id: number;
  name: string;
  path: string;
  watermark: boolean;
  print: boolean;
  download: boolean;
  date: Date;
}

export interface IClient {
  id?: number;
  name: string;
  tabs?: ITab[];
  creationDate?: Date;
}

const token = new InjectionToken<IPhoto>("TESTE");
