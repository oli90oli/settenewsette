import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddClipContainerComponent } from './add-clip-container.component';

describe('AddClipContainerComponent', () => {
  let component: AddClipContainerComponent;
  let fixture: ComponentFixture<AddClipContainerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddClipContainerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddClipContainerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
