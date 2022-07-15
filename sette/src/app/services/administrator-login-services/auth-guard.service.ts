import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

 constructor(private router: Router, private authService: AuthenticationService) { }

  canActivate() {
    if (this.authService.isUserLoggedIn()) {
      return true;
    } else { 
    this.router.navigate(['admin-login']);
    return false;
    }
  }
}
