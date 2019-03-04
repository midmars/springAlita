import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BaseballGroupListComponent } from './baseball-group-list.component';

describe('BaseballGroupListComponent', () => {
  let component: BaseballGroupListComponent;
  let fixture: ComponentFixture<BaseballGroupListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BaseballGroupListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BaseballGroupListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
