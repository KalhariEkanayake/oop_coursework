import { Component, OnInit } from '@angular/core';
import { VisualizeListService, Members, MemberList } from '../visualize-list.service';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  name: string;
  membershipNo: string;
  members: Members[];

  columndefs : any[] = ['membershipNo', 'name', 'startMembershipDate', 'mobileNo', 'schoolName', 'grade', 'age', 'nicNo'];

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

  SearchName(event: Event) {
    if(this.name != "") {
      this.members = this.members.filter(res=> {
        return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
      });
    } else if (this.name == "") {
      this.ngOnInit()
    }
  }
  }
