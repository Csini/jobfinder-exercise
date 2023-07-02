import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { environment } from '../environments/environment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import {
	ApiModule,
	Configuration,
	ConfigurationParameters,
} from './core/api/v1';
import { ReqInterceptor } from './req.interceptor';

export function apiConfigFactory(): Configuration {
	const params: ConfigurationParameters = {
		basePath: environment.basePath,
	};
	return new Configuration(params);
}

@NgModule({
	declarations: [
		AppComponent
	],
	imports: [
		BrowserModule,
		AppRoutingModule,
		ApiModule.forRoot(apiConfigFactory),
		HttpClientModule
	],
	providers: [
		{ provide: HTTP_INTERCEPTORS, useClass: ReqInterceptor, multi: true }
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
