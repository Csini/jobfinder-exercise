import { Component } from '@angular/core';
import { ClientService, PositionService, ClientResponse } from './core/api/v1';
import { AuthService } from './auth.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.scss']
})

export class AppComponent {

	inputTitle = '';
	inputPlace = '';

	title = 'jobfinder-exercise-ui';

	// Create a `cold` observable - we will be subscribing to this observable in the template
	c$ = this.clientService.createClient("testname", "testemail@a.hu");

	// Create a `cold` observable - we will be subscribing to this observable in the template
	bad_email$ = this.clientService.createClient("testname", "aaa");
	
	position1: any;
	
	soft: any;
	
	budapest : any;

	// Inject the generated Angular service as a dependency of this class
	constructor(private clientService: ClientService, private positionService: PositionService, private authService: AuthService) { }

	ngOnInit() {
		console.log("component has been initialized!")
		
		this.clientService.createClient("api_in_onint", "use@this.hu").subscribe((results: ClientResponse) => {
			
			this.authService.apikey = results.apikey;
			
			this.positionService.getPosition(1).subscribe((ret: any) => {
				console.log("ret:" + ret);
				this.position1 = ret;
			})
			
			this.positionService.searchPosition('soft', undefined).subscribe((ret: any) => {
				console.log("ret:" + ret);
				this.soft = ret;
			})
			
			this.positionService.searchPosition(undefined, 'Budapest').subscribe((ret: any) => {
				console.log("ret:" + ret);
				this.budapest = ret;
			})
		})
		
	}

	onCreatePosition() {
		console.log('onCreatePosition()');
		this.positionService.savePosition(this.inputTitle, this.inputPlace).subscribe((results: string) => {
			console.log('Data is received - Result - ', results);

		})
	}
}
