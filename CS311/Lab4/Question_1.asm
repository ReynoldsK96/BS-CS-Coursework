; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 10/28/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.    
    
    segment .data
a       dq      2       ; x1 (x of first set of points)
b       dq      8       ; y1 (y of first set of points)
c       dq      1       ; x2 (x of second set of points)
d       dq      6       ; y2 (y of second set of points)
result  dq      0       ; result
    
    segment .text
    global main
    
main:
    mov     rbx, [c]        ; set rbx to value stored in c
    sub     rbx, [a]        ; substract value stored in a from rbx
    imul    rbx, rbx        ; multiply rbx by itelf 
    mov     [result], rbx   ; store rbx in result
    
    mov     rbx, [d]        ; set rbx to value stored in d
    sub     rbx, [b]        ; subtrace value stored in b from rbx
    imul    rbx, rbx        ; multiply rbx by itself
    mov     rdx, [result]   ; move value stored in result to rdx
    add     rdx, rbx        ; add rbx to rdx
    mov     [result], rdx   ; store rdx in result
    
    xor     rax, rax        
    ret
