import { Component, OnInit } from '@angular/core';
import { SoccerService } from 'src/app/services/soccer.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  playerDetailsObject : any;
  filteredPlayerDetailsObject : any;
  filterByAttributes : string[] = ["NAME", "CLUB", "NATIONALITY", "POSITION"];
  filterAttribute : string = "";
  private _filterText : string = "";


  get filterText() : string{
    return this._filterText;
  }

  set filterText(value : string){
    this._filterText = value;
    this.filteredPlayerDetailsObject = this.performFilter(value, this.filterAttribute);
  }
  constructor(private soccerService : SoccerService) { }

  ngOnInit(): void {
    this._filterText = "";
    this.filterAttribute = "";
    this.getAllPlayerDetails(); 
    this.filteredPlayerDetailsObject = this.playerDetailsObject;
  }

  getAllPlayerDetails(){
    this.soccerService.getAllPlayerDetails().subscribe(
      data => this.playerDetailsObject = data,
      err => console.log(err),
      () => console.log("PLAYER DETAILS LOADED")
    );
  }

  performFilter(enteredText : string, enteredAttribute : string){
    enteredText = enteredText.toUpperCase();
    if(enteredAttribute.includes("NAME")){
      return this.playerDetailsObject.filter((eachPlayer : any) =>
      eachPlayer.playerName.toUpperCase().includes(enteredText));
    }
    else if(enteredAttribute.includes("CLUB")){
      return this.playerDetailsObject.filter((eachPlayer : any) =>
      eachPlayer.playerClub.toUpperCase().includes(enteredText));
    } 
    else if(enteredAttribute.includes("NATIONALITY")){
      return this.playerDetailsObject.filter((eachPlayer : any) =>
      eachPlayer.playerNationality.toUpperCase().includes(enteredText));
    }
    else if(enteredAttribute.includes("POSITION")){
      return this.playerDetailsObject.filter((eachPlayer : any) =>
      eachPlayer.playerPosition.toUpperCase().includes(enteredText));
    }
    else{
      return this.playerDetailsObject;
    }
  }
}
