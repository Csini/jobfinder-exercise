import { Injectable } from '@angular/core';
import {
	HttpRequest,
	HttpHandler,
	HttpEvent,
	HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class ReqInterceptor implements HttpInterceptor {

	constructor() { }

	intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
		const isApiRequest = !request.url.includes('client');

		if (isApiRequest) {
			request = request.clone({
				setHeaders: {
					'Authorization': 'key YOUR_API_KEY'
				}
			});
		}
		return next.handle(request);
	}
}