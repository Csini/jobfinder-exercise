import { Component } from '@angular/core';
import { ClientService, PositionService } from './core/api/v1';

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

	// Inject the generated Angular service as a dependency of this class
	constructor(private clientService: ClientService, private positionService: PositionService) { }


	onCreatePosition() {
		console.log('onCreatePosition()');
		this.positionService.savePosition(this.inputTitle, this.inputPlace).subscribe((results: string) => {
			console.log('Data is received - Result - ', results);

		})
	}
}
