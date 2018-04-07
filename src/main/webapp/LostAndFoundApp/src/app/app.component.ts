import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';
  tabIndex:number= 0;
  constructor(
  ){
	  
  }
  
  changeTab(index)
	  { 
		 this.tabIndex=index; 
		 //alert(this.tabIndex);
	  }
}
