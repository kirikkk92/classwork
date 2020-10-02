import { Injectable,EventEmitter } from '@angular/core';

@Injectable()
export class ToolBarService {
    onMenuButtonClick: EventEmitter<void> = new EventEmitter();

    emitMenuButtonClick() {
        this.onMenuButtonClick.emit();
    }
}