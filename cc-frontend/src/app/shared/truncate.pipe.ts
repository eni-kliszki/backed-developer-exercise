import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
 name: 'truncate'
})

export class TruncatePipe implements PipeTransform {

    transform(value: [], length: number) {    
        return value.length > length ? value.slice(0, length) : value;
    }
}