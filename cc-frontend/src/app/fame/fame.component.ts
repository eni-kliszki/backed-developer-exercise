import { Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'cc-fame-card',
  templateUrl: './fame.component.html',
  styleUrls: ['./fame.component.scss']
})

export class FameComponent implements OnInit {
  @Input() fameData: any;
  public team = [];  
  public avatarList = [];  

  constructor() {    
  }

  ngOnInit() {    
    console.log(this.fameData);
    this.avatarList = this.fameData.usersUrl;
  }

}
