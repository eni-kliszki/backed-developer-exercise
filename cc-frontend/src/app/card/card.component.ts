import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'cc-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  @Input() groupData: any;
  public avatarList = [];  

  constructor() {    
  }

  ngOnInit() {    
    this.avatarList = this.groupData.teamAvatarUrls;
  }

}
