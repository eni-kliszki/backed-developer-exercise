import { Injectable, Inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

// useable with DI, component decorator contains this dec.
@Injectable({
  providedIn: 'root'
})
export class RestService {
  constructor(@Inject(HttpClient) private _http: HttpClient) { }

  public sendGet() {
    const BASE_URL = 'http://localhost:8080/data';

    return this._http.get(BASE_URL);
  }

  public sendGetFame() {
    const BASE_URL = 'http://localhost:8080/fame';

    return this._http.get(BASE_URL);
  }
}
