import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDetailsComponent } from './components/add-details/add-details.component';
import { AdminComponent } from './components/admin/admin.component';
import { RegisterComponent } from './components/register/register.component';
import { ViewPlayerComponent } from './components/view-player/view-player.component';

const routes: Routes = [
  {
    component : RegisterComponent,
    path : ''
  },
  {
    component : AdminComponent,
    path : 'admin'
  },
  {
    component : ViewPlayerComponent,
    path : 'admin/player/:name'
  },
  {
    component : AddDetailsComponent,
    path : 'admin/clubcountry/add'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
