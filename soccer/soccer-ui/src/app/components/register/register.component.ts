import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Observable } from 'rxjs';
import { SoccerService } from 'src/app/services/soccer.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
validMessage : string = "";
playerForm : any;
playerPosition : any;
playerClub : any;
playerCountries : any;

  constructor(private soccerService : SoccerService) { }

  ngOnInit(): void {
    this.playerForm = new FormGroup({
      playerName : new FormControl('',Validators.required),
      playerAge : new FormControl('',Validators.required),
      playerClub : new FormControl('',Validators.required),
      playerNationality : new FormControl('',Validators.required),
      playerPosition : new FormControl('',Validators.required),
      playerGoals : new FormControl('',Validators.required),
      playerAssists : new FormControl('',Validators.required),
      playerCleanSheets : new FormControl('',Validators.required),
      playerStarRating : new FormControl('',Validators.required)
    });
    this.getAllPlayerPositions();
    this.getAllPlayerClubs();
    this.getAllPlayerCountries();
  }
  submitRegistration(){
    if(this.playerForm.valid){
      this.validMessage = "Player registration is successful. Thank you!";
      this.soccerService.addNewPlayer(this.playerForm.value).subscribe(
        data => {
          this.playerForm.reset();
          return true;
        },
        err => {
          return Observable.throw(err);
        }
      )
    }
    else{
      this.validMessage = "Please fill the details of the for before submitting!"
    }
  }

  getAllPlayerPositions(){
    this.soccerService.getAllPlayerPositions().subscribe(
      data => this.playerPosition = data,
      err => console.log(err),
      () => console.log("ALL POSITIONS LOADED")
    );
  }

  getAllPlayerClubs(){
    this.soccerService.getAllPlayerClubs().subscribe(
      data => this.playerClub = data,
      err => console.log(err),
      () => console.log("ALL CLUBS LOADED")
    );
  }

  getAllPlayerCountries(){
    this.soccerService.getAllPlayerCountries().subscribe(
      data => this.playerCountries = data,
      err => console.log(err),
      () => console.log("ALL COUNTRIES LOADED")
    );
  }
}
