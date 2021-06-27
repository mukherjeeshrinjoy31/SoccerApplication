import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-star',
  templateUrl: './star.component.html',
  styleUrls: ['./star.component.css']
})
export class StarComponent implements OnChanges {
  @Input() rating : any;
  starWidth : number = 75;
  cropWidth : any;

  constructor() { }
  ngOnChanges(changes: SimpleChanges): void {
    this.cropWidth = this.rating * this.starWidth / 5;
  }

  ngOnInit(): void {
  }

}
