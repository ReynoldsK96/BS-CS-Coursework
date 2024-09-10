; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 10/28/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

    segment .data
a       dq      2       ; x1 (x of first set of points)
b       dq      8       ; y1 (y of first set of points)
c       dq      2       ; x2 (x of second set of points)
d       dq      6       ; y2 (y of second set of points)
x       dq      0       ; difference of x coordinates
y       dq      0       ; difference of y coordinates
    
    segment .text
    global main
    
main:    
    mov     rax, 0          ; set rax to 0
    mov     rdx, 1          ; set rdx to 1
    mov     rbx, [c]        ; set rbx to value stored in c
    sub     rbx, [a]        ; substract value stored in a from rbx
    cmovz   rax, rdx        ; set rax to rdx if zero flag set because if x is 0 that means that the slope is verticle
    mov     [x], rax        ; store rbx in x
 
    mov     rbx, [d]        ; set rbx to value stored in d
    sub     rbx, [b]        ; subtrace value stored in b from rbx
    mov     [y], rbx        ; store rbx in y
         
    ret
