import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Clip } from './clip';

@Injectable({
  providedIn: 'root'
})

export class ClipService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getClip(): Observable<Clip[]> {
    return this.http.get<Clip[]>(`${this.apiServerUrl}/clip/all`);
  }

  public getClipByID(clipID: number): Observable<Clip[]> {
    return this.http.get<Clip[]>(`${this.apiServerUrl}/clip/${clipID}`)
  }

  public getLastClip(): Observable<Clip[]> {
    return this.http.get<Clip[]>(`${this.apiServerUrl}/clip/last`)
  }


  public addClip(clip: Clip): Observable<Clip> {
    return this.http.post<Clip>(`${this.apiServerUrl}/clip/add`, clip);
  }

  public updateClip(clipID: number, clip: Clip): Observable<Clip> {
    return this.http.put<Clip>(`${this.apiServerUrl}/clip/update/${clipID}`, clip);
  }

  public updateClipGroup(clipID: number, clip: Clip): Observable<Clip> {
    return this.http.put<Clip>(`${this.apiServerUrl}/clip/update/group/${clipID}`, clip);
  }

  public removeClipFromGroup(clipID: number, clip: Clip): Observable<Clip> {
    return this.http.put<Clip>(`${this.apiServerUrl}/clip/update/remove/${clipID}`, clip);
  }

  public deleteClip(clipID: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/clip/delete/${clipID}`);
  }
}