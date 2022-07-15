import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ChartsModelAuthor } from './charts-model-author';

@Injectable({
  providedIn: 'root'
})
export class ChartsModelAutorService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public return_clips_by_author(): Observable<ChartsModelAuthor[]> {
    
    console.log('in returnClipsByAuthor in service');

    return this.http.get<ChartsModelAuthor[]>(`${this.apiServerUrl}/charts/clips_by_author_procedure`);
  }
}

