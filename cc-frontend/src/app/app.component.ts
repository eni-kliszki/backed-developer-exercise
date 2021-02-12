import { Component, Inject, OnDestroy } from '@angular/core';
import { RestService } from './shared/rest-service.service';
import { Subscription } from 'rxjs';
import * as lod from 'lodash';

// components are used to visualize data
// shouldn't contain logic


// necessary to a component
@Component({
  selector: 'app-root', // select html tag, insert templateUrl's content in this tag
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnDestroy {
  public dataLoaded: Promise<boolean>;
  public userGroupList;
  public dataSubscription: Subscription;

  // DI
  constructor(@Inject(RestService) private _restService: RestService) { // inject and create variable
    this.dataSubscription = this._restService.sendGet().subscribe((data: any) => {
      this.userGroupList = data;
      console.log(this.userGroupList);
      this.dataLoaded = Promise.resolve(true);
    }); 
  }

  ngOnDestroy() {
    this.dataSubscription.unsubscribe();
    this.dataSubscription = null;
  }

  notifyNewSorting(method) {
    if (this.userGroupList) {
      switch(method.key) {
        case 'name':
          this.userGroupList.projects = lod.orderBy(this.userGroupList.projects, ['title', 'asc']);
          break;
        case 'nameReverse':
          this.userGroupList.projects = lod.orderBy(this.userGroupList.projects, ['title', 'desc']);
          break;
        case 'time':
          this.userGroupList.projects = lod.orderBy(this.userGroupList.projects, ['created', 'asc']);
          break;
        case 'timeReverse':
          this.userGroupList.projects = lod.orderBy(this.userGroupList.projects, ['created', 'desc']);
          break;
        default:
          this.userGroupList.projects = lod.orderBy(this.userGroupList.projects, ['title', 'asc']);
          break;
      }
    }
  }
}
