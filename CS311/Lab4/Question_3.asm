; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 10/28/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

    segment .data
a           dq      25      ; grade 1
b           dq      50      ; grade 2
c           dq      75      ; grade 3
d           dq      100     ; grade 4
divis       dq      4       ; divisor
sum         dq      0       ; dividend
quot        dq      0       ; quotient
rem         dq      0       ; remainder

    segment .text
    global main

main:
    mov     rbx, [a]        ; set rbx to value stored in a
    add     rbx, [b]        ; add value stored in b to rbx
    add     rbx, [c]        ; add value stored in c to rbx
    add     rbx, [d]        ; add value stored in d to rbx
    mov     [sum], rbx      ; store rbx in sum
    mov     rax, [sum]      ; set rax to value stored in sum
    mov     rdx, 0          
    idiv    qword [divis]   ; divide sum by divis
    mov     [quot], rdx     ; store rdx in quot
    mov     [rem], rax      ; store rax in rem
    
    xor     rax, rax
    ret

