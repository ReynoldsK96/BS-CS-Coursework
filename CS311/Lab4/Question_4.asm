; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 10/28/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

    segment .data
a       dq      -326        ; dividend
b       dq      7           ; divisor
quot    dq      0           ; quotient
rem     dq      0           ; remainder

    segment .text
    global main

main:
    mov     rax, [a]        ; set rax to value stored in a
    neg     rax             ; turn rax positive
    mov     rdx, 0          ; 
    idiv    qword [b]       ; divide rax by b
    neg     rax             ; turn rax to negative
    neg     rdx             ; turn rdc to negative
    mov     [quot], rax     ; store rax in quot
    mov     [rem], rdx      ; store rdx in rem
    
    xor     rax, rax
    ret
