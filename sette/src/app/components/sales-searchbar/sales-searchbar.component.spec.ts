import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SalesSearchbarComponent } from './sales-searchbar.component';

describe('SalesSearchbarComponent', () => {
  let component: SalesSearchbarComponent;
  let fixture: ComponentFixture<SalesSearchbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SalesSearchbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SalesSearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
