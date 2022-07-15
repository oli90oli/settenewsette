import { TestBed } from '@angular/core/testing';

import { ChartsModelAutorService } from './charts-model-author.service';

describe('ChartsModelAutorService', () => {
  let service: ChartsModelAutorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChartsModelAutorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
