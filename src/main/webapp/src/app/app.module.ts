import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppRoutingModule } from './app-routing.module';
import { PeliculaService } from './pelicula.service';
import { ActorService } from './actor.service';
import { AppComponent }  from './app.component';
import { MovieDetailComponent } from './components/movie-detail.component';
import { PeliculasComponent } from './components/peliculas.component';

@NgModule({
  imports:      [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    MovieDetailComponent,
    PeliculasComponent
  ],
  providers: [
    PeliculaService,
    ActorService
  ],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
