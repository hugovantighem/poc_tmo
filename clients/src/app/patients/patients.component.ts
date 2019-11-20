import { Component, OnInit, ViewChild } from "@angular/core";
import { DataService } from "../services/data.service";
import { IPatient } from "../shared/interfaces";
import { LoggerService } from "../services/logger.service";
import { Subscription } from "rxjs";
import { AllCommunityModules } from "@ag-grid-community/all-modules";
import { NgForm } from "@angular/forms";

@Component({
    selector: "app-patients",
    templateUrl: "./patients.component.html",
    styleUrls: ["./patients.component.scss"]
})
export class PatientsComponent implements OnInit {
    patients: IPatient[] = [];
    searchParam = {
        firstName: ""
    };
    @ViewChild("patientsForm", { static: true }) customerForm: NgForm;

    columnDefs = [
        { headerName: "Id", field: "id", sortable: true, filter: true },
        {
            headerName: "First name",
            field: "firstname",
            sortable: true,
            filter: true
        },
        {
            headerName: "Last name",
            field: "lastname",
            sortable: true,
            filter: true
        },
        { headerName: "email", field: "email", sortable: true, filter: true }
    ];

    modules = AllCommunityModules;

    constructor(
        private dataService: DataService,
        private logger: LoggerService
    ) {}

    ngOnInit() {}

    search(event: Event) {
        event.preventDefault();
        this.dataService.searchPatients(this.searchParam.firstName).subscribe(
            (data: IPatient[]) => {
                this.patients = data;
            },
            err => this.logger.log(err)
        );
    }

    compute(event: Event) {
        event.preventDefault();
        this.dataService.compute(this.searchParam.firstName).subscribe(
            (data: IPatient[]) => {
                this.patients = data;
            },
            err => this.logger.log(err)
        );
    }
}
