import { Component, OnInit } from '@angular/core';
import { SoccerService } from 'src/app/services/soccer.service';
import { ActivatedRoute } from '@angular/router';
import { StarComponent } from '../star/star.component';

@Component({
  selector: 'app-view-player',
  templateUrl: './view-player.component.html',
  styleUrls: ['./view-player.component.css']
})
export class ViewPlayerComponent implements OnInit {
  soccerPlayer : any;
  constructor(private soccerService : SoccerService, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.getPlayerDetailsByName(this.route.snapshot.params.name);
  }

  getPlayerDetailsByName(name : string) : any{
    this.soccerService.getPlayerDetailsByName(name).subscribe(
      data => this.soccerPlayer = data,
      err => console.log(err),
      () => console.log("SOCCER PLAYER DETAILS LOADED")
    );
  }

}
