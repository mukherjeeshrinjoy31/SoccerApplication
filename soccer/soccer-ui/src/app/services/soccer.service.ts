import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {headers : new HttpHeaders({'Content-Type' : 'application/json'})};

@Injectable({
  providedIn: 'root'
})
export class SoccerService {

  constructor(private http : HttpClient) { }

  getAllPlayerDetails(){
    return this.http.get('/server/api/soccer/player/all');
  }

  getPlayerDetailsByName(name : string){
    return this.http.get('/server/api/soccer/player/' + name);
  }

  addNewPlayer(playerObject : any){
    let body = JSON.stringify(playerObject);
    return this.http.post('/server/api/soccer/player/add', body, httpOptions);
  }

  getAllPlayerPositions(){
    return this.http.get('/server/api/soccer/position');
  }

  getAllPlayerClubs(){
    return this.http.get('/server/api/soccer/club');
  }

  getAllPlayerCountries(){
    return this.http.get('/server/api/soccer/nation');
  }

  addCountryDetails(country : any){
    let body = JSON.stringify(country);
    return this.http.post('/server/api/soccer/nation/add', body, httpOptions);
  }
  
  addClubDetails(club : any){
    let body = JSON.stringify(club);
    return this.http.post('/server/api/soccer/club/add', body, httpOptions);
  }
}