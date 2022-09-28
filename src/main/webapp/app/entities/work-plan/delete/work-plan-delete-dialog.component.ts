import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

import { IWorkPlan } from '../work-plan.model';
import { WorkPlanService } from '../service/work-plan.service';
import { ITEM_DELETED_EVENT } from 'app/config/navigation.constants';

@Component({
  templateUrl: './work-plan-delete-dialog.component.html',
})
export class WorkPlanDeleteDialogComponent {
  workPlan?: IWorkPlan;

  constructor(protected workPlanService: WorkPlanService, protected activeModal: NgbActiveModal) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.workPlanService.delete(id).subscribe(() => {
      this.activeModal.close(ITEM_DELETED_EVENT);
    });
  }
}
