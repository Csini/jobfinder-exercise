import { Component } from '@angular/core';
import { ClientService } from './core/api/v1';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent {
  title = 'jobfinder-exercise-ui';

  // Create a `cold` observable - we will be subscribing to this observable in the template
  c$ = this.clientService.getClient("testname", "testemail@a.hu");

  // Create a `cold` observable - we will be subscribing to this observable in the template
  bad_email$ = this.clientService.getClient("testname", "aaa");

  // Inject the generated Angular service as a dependency of this class
  constructor(private clientService: ClientService) {}
}
