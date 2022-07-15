import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NostrificationsSearchbarComponent } from './nostrifications-searchbar.component';

describe('NostrificationsSearchbarComponent', () => {
  let component: NostrificationsSearchbarComponent;
  let fixture: ComponentFixture<NostrificationsSearchbarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NostrificationsSearchbarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NostrificationsSearchbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
