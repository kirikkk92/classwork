import {Pipe, PipeTransform}from '@angular/core';
@Pipe({ 
    name:"lower"
})

export class LowerPipe implements PipeTransform { 
    transform(value, args?) {
        return value.toLowerCase();
    }
}