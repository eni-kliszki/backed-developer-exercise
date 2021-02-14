import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { RestService } from './shared/rest-service.service';
import { HttpClientModule } from '@angular/common/http';
import { CardComponent } from './card/card.component';
import { TruncatePipe } from './shared/truncate.pipe';
import { SortModalComponent } from './sort-modal/sort-modal.component';
import { FameComponent } from './fame/fame.component';

@NgModule({
  declarations: [ //register components
    AppComponent,
    CardComponent,
    TruncatePipe,    
    SortModalComponent,
    FameComponent
  ],
  imports: [
  BrowserModule,
    HttpClientModule
  ],
  providers: [ // register all the dependencies in this module
    RestService //single instance - singleton
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
