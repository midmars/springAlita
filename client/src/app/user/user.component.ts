
import {UserService} from "../../../../../../spring/springAlita/client/src/app/shared/user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users:Array<any>;

  constructor(private  route:ActivatedRoute,
              private  router:Router,
              private  userService:UserService) { }

  ngOnInit() {
    this.userService.getAll().subscribe( data=>{
      this.users=data;
    })
  }

}
