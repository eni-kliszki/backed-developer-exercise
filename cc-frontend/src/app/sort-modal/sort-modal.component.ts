import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'sort-modal',
  templateUrl: './sort-modal.component.html',
  styleUrls: ['./sort-modal.component.scss']
})
export class SortModalComponent implements OnInit {
  @Output() sortingMethod = new EventEmitter<string>();

  public sortMethods = [
    { key: 'name', caption: 'Name A - Z'},
    { key: 'nameReverse', caption: 'Name Z - A'},
    { key: 'time', caption: 'Newest to oldest'},
    { key: 'timeReverse', caption: 'Oldest to newest'}
  ]
  public modalState = {
    open: false,
    selected: null    
  };

  constructor() { }

  ngOnInit() {
    this.modalState.selected = this.sortMethods[0];
    this.sortingMethod.emit(this.modalState.selected);
  }

  openModal() {
    this._setModalState();
  }

  onSelectMethod(method) {
    this.modalState.selected = method;
    this.sortingMethod.emit(this.modalState.selected);
  }

  private _setModalState() {
    this.modalState.open = !this.modalState.open;
  }
}
