import { TestBed } from '@angular/core/testing';

import { VisualizeListService } from './visualize-list.service';

describe('VisualizeListService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VisualizeListService = TestBed.get(VisualizeListService);
    expect(service).toBeTruthy();
  });
});
