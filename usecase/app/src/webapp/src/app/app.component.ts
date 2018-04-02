import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

class GreetingMessage {
  public server : String;
  public message : String;
  public count : Number;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  private autoMsBetweenQueries : Number = 1000;

  public auto : boolean = false;
  private autoInterval : any = null;
  private greetings : GreetingMessage[] = [];

  constructor(private http: HttpClient) {
    this.http = http;
  }

  toggleAuto() {
    this.auto = !this.auto;
    if (this.auto) {
      this.autoInterval = window.setInterval(() => {
        this.getGreeting();
      }, this.autoMsBetweenQueries);
    } else {
      if (this.autoInterval) {
        window.clearInterval(this.autoInterval);
      }
      this.autoInterval = null;
    }
  }

  getServers() {
    return Array.from(new Set(this.greetings.map(g => g.server)));
  }

  getGreetingsFromServer(server : String) {
    return this.greetings.filter(g => g.server === server);
  }

  getGreeting() {
    this.http.get<GreetingMessage>('/api/greeting').subscribe(greeting => {
      this.greetings.push(greeting);
    }, err => {
      alert(`An error has occurred: ${err.statusText}`);
      console.debug(err);
    });
  }

}
