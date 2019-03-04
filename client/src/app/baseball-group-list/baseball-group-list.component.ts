import { Component, OnInit } from '@angular/core';
import {GroupService} from "../shared/baseball/group.service";

@Component({
  selector: 'app-baseball-group-list',
  templateUrl: './baseball-group-list.component.html',
  styleUrls: ['./baseball-group-list.component.css']
})
export class BaseballGroupListComponent implements OnInit {
  groups:Array<any>;

  constructor(private groupService: GroupService) { }

  ngOnInit() {
    this.groupService.getAll().subscribe(data=>{
      this.groups=data;
    })
  }

}
