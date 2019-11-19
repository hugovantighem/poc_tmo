import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

const routes: Routes = [
    {
        path: "patients-list",
        loadChildren: () =>
            import("./patients/patients.module").then(m => m.PatientsModule)
    },
    {
        path: "",
        loadChildren: () =>
            import("./patients/patients.module").then(m => m.PatientsModule)
    }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}
