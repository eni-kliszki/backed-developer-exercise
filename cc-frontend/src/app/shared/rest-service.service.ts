import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {
  constructor(@Inject(HttpClient) private _http: HttpClient) { }

  public sendGet() {
    const BASE_URL = 'http://localhost:3000/data';

    return this._http.get(BASE_URL);
  }
}
