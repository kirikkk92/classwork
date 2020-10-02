import { Component, OnInit, Inject} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-item-dialog',
  templateUrl: './item-dialog.component.html',
  styleUrls: ['./item-dialog.component.scss']
})
export class ItemDialogComponent implements OnInit {

  constructor(
    private dialogRef: MatDialogRef<ItemDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any) { }

    closeDialog() {
      this.dialogRef.close();
    }

    removeImg(img) {
      let index = this.data.item.images.indexOf(img);
      this.data.item.images.splice(index, 1);
    }

  ngOnInit(): void {
  }

}
