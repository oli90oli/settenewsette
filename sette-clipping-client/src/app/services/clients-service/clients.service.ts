import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Clients } from './clients';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAllClients(): Observable<Clients[]> {
    return this.http.get<Clients[]>(`${this.apiServerUrl}/clients/all`);
  }

  public getClientsByID(clientID: number): Observable<Clients[]> {
    return this.http.get<Clients[]>(`${this.apiServerUrl}/clients/${clientID}`)
  }

  public addClients(clients: Clients): Observable<Clients> {
    return this.http.post<Clients>(`${this.apiServerUrl}/clients/add`, clients);
  }

  public updateClients(clients: Clients, clientID: number): Observable<Clients> {
    return this.http.put<Clients>(`${this.apiServerUrl}/clients/update/${clientID}`, clients);
  }

  public deleteClientsById(clientID: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/clients/delete/${clientID}`);
  }

}
