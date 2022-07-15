import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClipUserComponent } from './clip-user.component';

describe('ClipUserComponent', () => {
  let component: ClipUserComponent;
  let fixture: ComponentFixture<ClipUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClipUserComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClipUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
