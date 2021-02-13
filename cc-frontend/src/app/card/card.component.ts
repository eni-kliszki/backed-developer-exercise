import { Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'cc-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})

export class CardComponent implements OnInit {
  @Input() groupData: any;
  public avatarList = [];  
  
  public experiencePoints;
  public users : number;

  public averageExperiencePointByTeyhnologies = new Map<String, number>();

  constructor() {    
  }

  fillExperiencePointByTeyhnologies() {
    for(let experiencePoint of this.experiencePoints){
      for(let key in experiencePoint){
        if(!this.averageExperiencePointByTeyhnologies.has(key)){
          this.averageExperiencePointByTeyhnologies.set(key, experiencePoint[key]); 
        }else{
          let point = this.averageExperiencePointByTeyhnologies.get(key);
          this.averageExperiencePointByTeyhnologies.set(key, point + experiencePoint[key]); 
        }
      }
    }
  }

  countExperiencePointAverage() { 
    this.averageExperiencePointByTeyhnologies.forEach((value: number, key: string) => {
      let average = this.averageExperiencePointByTeyhnologies.get(key) / this.users;
      average = Math.round((average + Number.EPSILON) * 100) / 100;
      this.averageExperiencePointByTeyhnologies.set(key, average)
    });
  }

  ngOnInit() {    
    this.avatarList = this.groupData.teamAvatarUrls;
    this.experiencePoints = this.groupData.usersExperiencePoints;
    this.users = this.experiencePoints.length;
    this.fillExperiencePointByTeyhnologies();
  }

  ngAfterContentInit(){
    this.countExperiencePointAverage();
  }

}
