import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientHashComponent } from './client-hash.component';

describe('ClientHashComponent', () => {
  let component: ClientHashComponent;
  let fixture: ComponentFixture<ClientHashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientHashComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ClientHashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
