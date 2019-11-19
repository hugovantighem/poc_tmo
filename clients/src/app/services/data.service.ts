import { Injectable, Inject } from "@angular/core";
import { HttpClient, HttpErrorResponse } from "@angular/common/http";

import { Observable } from "rxjs";
import { catchError, map } from "rxjs/operators";

import { IPatient } from "../shared/interfaces";

@Injectable()
export class DataService {
    private baseAdress = "http://10.11.6.117:8080";
    private patientsSearchtUrl = `${this.baseAdress}/patients/search/`;
    private computationBaseUrl = `${this.baseAdress}/patients/compute/`;

    constructor(private httpClient: HttpClient) {}

    searchPatients(filter: string): Observable<IPatient[]> {
        return this.httpClient
            .get<IPatient[]>(`${this.patientsSearchtUrl}${filter}`)
            .pipe(catchError(this.handleError));
    }

    compute(param: string): Observable<IPatient[]> {
        return this.httpClient
            .get<IPatient[]>(`${this.computationBaseUrl}${param}`)
            .pipe(catchError(this.handleError));
    }

    private handleError(error: HttpErrorResponse) {
        console.error("server error:", error);
        if (error.error instanceof Error) {
            const errMessage = error.error.message;
            return Observable.throw(errMessage);
            // Use the following instead if using lite-server
            // return Observable.throw(err.text() || 'backend server error');
        }
        return Observable.throw(error || "Node.js server error");
    }
}
