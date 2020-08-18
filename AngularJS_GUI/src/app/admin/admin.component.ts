import { Component, OnInit } from '@angular/core';
import { VisualizeListService, Members } from '../visualize-list.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  members: Members[];

  constructor(
    private _visualizeListService: VisualizeListService) { }

  ngOnInit(): void {
    this._visualizeListService.getMembers().subscribe(
      response => this.handleResponse(response),
    );
  }

  handleResponse(response) {
    this.members = response;
    console.log(this.members);
  }
}
