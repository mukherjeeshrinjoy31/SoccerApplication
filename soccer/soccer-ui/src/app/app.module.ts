import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { SoccerService } from './services/soccer.service';
import { AdminComponent } from './components/admin/admin.component';
import { StarComponent } from './components/star/star.component';
import { ViewPlayerComponent } from './components/view-player/view-player.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { AddDetailsComponent } from './components/add-details/add-details.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    StarComponent,
    ViewPlayerComponent,
    RegisterComponent,
    AddDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [SoccerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
