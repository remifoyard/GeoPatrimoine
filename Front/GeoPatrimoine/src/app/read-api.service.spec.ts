import { TestBed, inject } from '@angular/core/testing';

import { ReadApiService } from './read-api.service';

describe('ReadApiService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReadApiService]
    });
  });

  it('should be created', inject([ReadApiService], (service: ReadApiService) => {
    expect(service).toBeTruthy();
  }));
});
