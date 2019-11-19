import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { DataService } from "./services/data.service";
import { HttpClientModule } from "@angular/common/http";
import { AgGridModule } from "@ag-grid-community/angular";
import { SharedModule } from "./shared/shared.module";

@NgModule({
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        SharedModule, // Shared (multi-instance) objects
        AgGridModule.withComponents([])
    ],
    declarations: [AppComponent],
    providers: [DataService],
    bootstrap: [AppComponent]
})
export class AppModule {}
