import { Injectable } from '@angular/core';
import {
	HttpRequest,
	HttpHandler,
	HttpEvent,
	HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';

@Injectable()
export class ReqInterceptor implements HttpInterceptor {

	constructor(private authService : AuthService) { }

	intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
		const isApiRequest = !request.url.includes('client');

		if (isApiRequest) {
			request = request.clone({
				setHeaders: {
					'X-API-Key': this.authService.apikey
				}
			});
		}
		return next.handle(request);
	}
}