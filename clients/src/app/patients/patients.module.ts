import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { PatientsRoutingModule } from "./patients-routing.module";
import { PatientsComponent } from "./patients.component";
import { AgGridModule } from "@ag-grid-community/angular";
import { SharedModule } from "../shared/shared.module";

@NgModule({
    declarations: [PatientsComponent],
    imports: [
        CommonModule,
        SharedModule,
        PatientsRoutingModule,
        AgGridModule.withComponents([])
    ]
})
export class PatientsModule {}
