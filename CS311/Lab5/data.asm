; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 11/11/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

        segment .data
    t       dw  0x65A9
    day     dw  0
    month   db  0
    year    dw  1980
    
        segment .text
        global main

main:
    xor EDX, EDX        ;sets EDX register to 0
    mov DX, [t]         ;moves value stored at t to DX register
    shl DX, 0           ;shifts bits 15 - 15 = 0 to the left
    shr DX, 11          ;shifts bits 15 - (15 - 11) = 11 to the right
    mov [day], DX       ;stores extracted bit field 11-15 at day  
    
    xor EDX, EDX        ;sets EDX register to 0
    mov DX, [t]         ;moves value stored at t to DX register
    shl DX, 5           ;shifts bits 15 - 10 = 5 to the left
    shr DX, 12          ;shifts bits 15 - (10 - 7) = 12 to the right
    mov [month], DL     ;stores extracted bit field 7-10 at month
    
    xor EDX, EDX        ;sets EDX register to 0
    mov DX, [t]         ;moves value stored at t to DX register
    shl DX, 9           ;shifts bits 15 - 6 = 9 to the left
    shr DX, 9           ;shifts bits 15 - (6 - 0) = 9 to the right 
    add DX, [year]      ;adds year value to extracted bit field 0-6 value
    mov [year], DX      ;stores sum DX at year
     
    xor EDX, EDX        ;sets EDX register to 0
ret
