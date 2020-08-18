import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class Members {
  constructor(
    public membershipNo: string,
    public name: string,
    public startMembershipDate: Date,
    public gender: string,
    public mobileNo: string,
    public schoolName: string,
    public grade: number,
    public age: number,
    public nicNo: string,
  ){}
}

export interface MemberList {
  membershipNo: string,
  name: string,
  startMembershipDate: Date,
  gender: string,
  mobileNo: string,
  schoolName: string,
  grade: number,
  age: number,
  nicNo: string,
}

@Injectable({
  providedIn: 'root'
})
export class VisualizeListService {

  constructor(private _http: HttpClient) { }

  getMembers(){
    console.log("Test call");
    return this._http.get<Members[]>('http://localhost:8080/members');
  }
}
