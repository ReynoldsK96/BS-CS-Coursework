; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 11/29/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

    segment .data
x       dq  0       ; the number for comparison
scanf_format    db  "%ld",0
printf_format   db  "The number closest to the fib(%ld) is = %ld",0x0a,0

    segment .text
    global main
    global fibonacci
    extern scanf
    extern printf

main:
    push    rbp                 ; set up stack
    mov     rbp, rsp
    frame   0, 0, 3
    sub     rsp, frame_size
    lea     rcx, [scanf_format] ; set arg 1
    lea     rdx, [x]            ; set arg 2 for scanf call scanf
    call    scanf
    mov     rdx, [x]            ; move x for fact call call fact
    call    fibonacci  
    lea     rcx, [printf_format]; set arg 1
    mov     rdx, [x]
    mov     r8,  rax
    call    printf
    xor     eax, eax
    leave
    ret
    
fibonacci:
a       equ local1          ; local variable a
b       equ local2          ; local variable b
diff1   equ local3          ; local variable diff1
diff2   equ local4          ; local variable diff2 
    push    rbp             ; set up stack
    mov     rbp, rsp
    frame   0, 4, 1         ; two local variable 
    sub     rsp, frame_size ; set stack pointer 
    mov rcx, 2              ; i = 2
    mov r9, 1               ; a = 1
    mov r10, 1              ; b = 1

    if:    
        cmp rdx, 1          ; if x <= 1 fib(x) = x
        jle less_than_equal

    for:            
        cmp rdx, rcx            ; i < x     
        jl  calculate_distance  ; if 0 then they are equal and the for loop ends, jumping to end label
        mov r11, r9             ; temp = fib
        add r9, r10             ; fib + prevFib
        mov r10, r11            ; prevFib = temp
        mov [rbp+a], r9         ; save a (fib sequence 1)
        mov [rbp+b], r10        ; save b (fib sequence 2) 
        inc rcx                 ; i++
        cmp rdx, r9
        jle calculate_distance
        jmp for                 ; jump back to for label to continue for loop
             
less_than_equal:
    mov rcx, [rdx]
    leave
    ret
    
calculate_distance:    
    cmp     rdx, [rbp+a]        ; compare x and a
    jz      fib_equals_x        ; if 0 they are equal and jump to fib_equals_x label
    cmp     rdx, [rbp+b]        ; compare x and b
    jz      fib_equals_x        ; if 0 they are equal and jump to fib_equals_x label  
    mov     r9, [rbp+a]         ; move a value into r9
    sub     rdx, r9             ; x-a to get distance between the two
    jl      negate_1            ; if negative jump to negate_1 label

resume_1:    
    mov     [rbp+diff1], rdx    ; move difference of x-a to local variable diff1
    mov     rdx, [x]            ; move x value into rdx
    mov     r9, [rbp+b]         ; move b value into r9    
    sub     rdx, r9             ; x-b to get the distance between the two
    jl      negate_2            ; if negative jump to negate_2 label

resume_2:
    mov     [rbp+diff2], rdx    ; move difference of x-b to local variable diff2
    mov     r9, [rbp+diff1]     ; move diff1 value into r9
    cmp     r9, rdx             ; diff1-diff2 to determine which is greater
    jl      less                ; if SF is set then diff1 was less than diff2, jump to less label
    jnz     greater             ; if SF was not set then diff1 was greater than diff2, jump to greater label
    jz      equal               ; if ZF was set then diff1 and diff2 are equal, jump to equal label

fib_equals_x:
    mov     rax, [x]               
    leave
    ret

negate_1:
    neg rdx                         ; makes rdx positive
    jmp resume_1                    ; jumps to resume_1 label
    
negate_2:
    neg rdx                         ; makes rdx positive
    jmp resume_2                    ; jumps to resume_2 label
    
less:
    mov     rax, [rbp+a]            ; a is the close fibonacci sequence
    leave
    ret

greater:
    mov     rax, [rbp+b]            ; b is the closer fibonacci sequence
    leave
    ret

equal:
    mov     rax, [rbp+a]            ; distance is equal so a, the greater number, is returned
    leave
    ret
