import { Component, OnInit } from '@angular/core';
import { SoccerService } from 'src/app/services/soccer.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-details',
  templateUrl: './add-details.component.html',
  styleUrls: ['./add-details.component.css']
})
export class AddDetailsComponent implements OnInit {
  validMessageCountry : string = "";
  validMessageClub : string = "";
  countryForm : any;
  clubForm : any;
  countryList : any;

  constructor(private soccerService : SoccerService) { }

  ngOnInit(): void {
    this.getAllCountriesList();
    this.countryForm = new FormGroup({
      nationName : new FormControl('',Validators.required),
      nationCode : new FormControl('',Validators.required)
    });
    this.clubForm = new FormGroup({
      clubName : new FormControl('',Validators.required),
      clubCode : new FormControl('',Validators.required),
      clubNationName : new FormControl('',Validators.required)
    });
  }

  submitCountryRegistration(){
    if(this.countryForm.valid){
      this.validMessageCountry = "Country details have been successfully added to the list. Thank You!";
      this.soccerService.addCountryDetails(this.countryForm.value).subscribe(
        data => {
          this.countryForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
    }
    else{
      this.validMessageCountry = "Please fill the country details for submitting!";
    }
  }

  submitClubRegistration(){
    if(this.clubForm.valid){
      this.validMessageClub = "Club details have been successfully added to the list. Thank You!";
      this.soccerService.addClubDetails(this.clubForm.value).subscribe(
        data => {
          this.clubForm.reset();
          return true;
        },
        error => {
          return Observable.throw(error);
        }
      );
    }
    else{
      this.validMessageClub = "Please fill the club details for submitting!";
    }
  }

  getAllCountriesList(){
    this.soccerService.getAllPlayerCountries().subscribe(
      data => this.countryList = data,
      err => console.log(err),
      () => console.log("ALL COUNTRIES LOADED")
    );
  }
}
