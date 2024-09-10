; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 10/21/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
        
    segment .data
a           dw  -278, 124, -172     ; array of 3 values
b           db  38, -120, -92       ; array of 3 values
result      dq  0                   ; memory for result

    segment .text
    global main

main:
    mov     rax, 10             ; set rax to 10
    movsx   rbx, byte[b]        ; set rbx to 38
    sub     rbx, rax            ; subtract 10 from 38
    add     rbx, [a]            ; add -278 to rbx
    mov     rdx, rbx            ; set rdx to rbx (sum of calculations) 
    movsx   rbx, byte[b]        ; set rbx to 38
    mov     rax, 32             ; set rax to 32
    add     rbx, rax            ; add 32 to 38
    sub     rbx, [a]            ; subtract -278 from rbx
    add     rdx, rbx            ; add rbx to rdx (adding sum of first and second parts of equation together)
    mov     [result],rdx        ; set rdx value to result 
    
    mov     rax, 10             ; set rax to 10
    movsx   rbx, byte[b+1]      ; set rbx to -120
    sub     rbx, rax            ; subtract 10 from -120
    add     rbx, [a+2]          ; add 124 to rbx                  
    mov     rdx, rbx            ; set rdx to rbx (sum of calculations) 
    movsx   rbx, byte[b+1]      ; set rbx to -120
    mov     rax, 32             ; set rax to 32
    add     rbx, rax            ; add 32 to -120
    sub     rbx, [a+2]          ; subtract 124 from rbx
    add     rdx, rbx            ; add rbx to rdx (adding sum of first and second parts of equation together)
    add     rdx, [result]       ; add result to rdx (adding the sum of the first and second iteration of the equation together)
    mov     [result],rdx        ; set rdx value to the result  
    
    mov     rax, 10             ; set rax to 10
    movsx   rbx, byte[b+2]      ; set rbx to -92
    sub     rbx, rax            ; substract 10 from -92
    add     rbx, [a+4]          ; add -172 to rbx
    mov     rdx, rbx            ; set rdx to rbx (sum of calculations)
    movsx   rbx, byte[b+2]      ; set rbx to -92
    mov     rax, 32             ; set rax to 32
    add     rbx, rax            ; add 32 to -92  
    sub     rbx, [a+4]          ; subtract -172 from rbx
    add     rdx, rbx            ; add rbx to rdx (adding sum of first and second parts of equation together)
    add     rdx, [result]       ; add result to rdx (now the sum of all calculations)
    mov     [result],rdx        ; set rdx value to the result  
    xor     rax, rax            ; zero out rax
    ret
