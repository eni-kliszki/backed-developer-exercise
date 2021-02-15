import { Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'cc-user-card',
  templateUrl: './userToLearn.component.html',
  styleUrls: ['./userToLearn.component.scss']
})

export class UserToLearnComponent implements OnInit {
  @Input() userData: any;
  public userName;  

  constructor() {    
  }

  ngOnInit() {  
    // this.userName = this.userData.name; 
  }

}
