; Name: Katherine Reynolds
; Student ID: 24556946
; Date: 11/18/2021
; Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.

        segment .data
array       db  12, 14, 7, 45, 21, 15, 57, 36, 3, 79
divisor     dw  2
needle      db  21
index       db  0

        segment .text
        global main
        
main:
    xor     rax, rax                    ; clear out rax
    xor     rbx, rbx                    ; clear out rbx
    xor     rcx, rcx                    ; clear out rcx
    xor     rdx, rdx                    ; clear out rdx
    
do_sort:
    mov     dx, 0                       ; dx will hold the 'swapped' value of true (1) or false (0). It is set to false initially and reset false everytime do is jumped to

for_sort:
    cmp    cx, 9                        ; checks to see if rcx has reached the end of the array
    jge    search_setup                 ; if the zero flag is set the end of the array has been reached and the for loop ends
        movzx   ax, byte[array+rcx]     ; assigns value of array at index i to ax
        movzx   bx, byte[array+rcx+1]   ; assigns value of array at index i+1 to bx
        cmp     bx, ax                  ; checks to see if bx is larger than ax
        jge     in_order                ; if sum is 0 or larger then array elements are in the right order and jump is made 
        mov     [array+rcx], bl         ; if the sum was less than 0 then array elements are swapped
        mov     [array+rcx+1], al
        mov     dx, 1                   ; swapped value is set to true
        jnz     while_sort              ; sign flag is set and jump is made to while
        
in_order:
    inc     cx                          ; increments rcx
    jmp     for_sort                    ; jumps back to for
    
while_sort:
    
    dec     cx                          ; rcx is decremented
    jl      do_sort                     ; if rcx becomes less then 0 then the beginning of the array has been reached and jump is made back to do
        movzx   ax, byte[array+rcx]     ; assigns value of array at index i to ax
        movzx   bx, byte[array+rcx+1]   ; assigns value of array at index i+1 to bx
        cmp     bx, ax                  ; checks to see if bx is larger than ax
        jge     for_sort                ; if sum is 0 or larger then array elements are in the right order and jump is made back to for
        mov     [array+rcx], bl         ; if the sum was less than 0 then array elements are swapped
        mov     [array+rcx+1], al
        jmp     while_sort              ; jump is made back to while
       
search_setup:
    xor     rbx, rbx                    ; clear out rbx
    xor     rcx, rcx                    ; clear out rcx
    xor     rdx, rdx                    ; clear out rdx
    mov     ebx, 0                      ; lower
    mov     ecx, 9                      ; upper
    
while_search:
    cmp     ecx, ebx
    jl      end
        xor     rax, rax                ; clear out rax
        xor     rdi, rdi                ; clear out rdi
        add     edi, ebx                ; add lower value to edi
        add     edi, ecx                ; add upper value to edi
        mov     eax, edi                ; move sum of addition to eax to be divided
        mov     edx, 0                  ; set up edx for division
        div     word[divisor]           ; divide eax by 2 to calculate middle
        movsx   edx, byte[array+rax]    ; move array at index of middle calculation
        cmp     [needle], edx           ; compare needle to array value at middle index
        jz      found                   ; if 0, needle has been found
        jl      else_if                 ; if sign flag is set, array value was more than needle so needle must be to the left of the middle value. Jump to else_if
        jnz     else                    ; if zero flag was not set, needle was less then array value so needle must be to the right of the middle value. Jump to else

found:
    mov     [index], al                 ; move lower 8 bits of ax into index since ax is the current index of the array that the needle was found at
    jmp     end                         ; needle has been found. Jump to end
    
else_if:
    sub     eax, 1                      ; subtract 1 from eax (middle value)
    mov     ecx, eax                    ; update ecx to hold the new middle value, it becomes the new lower value. Eliminating the right side of the array from the search.
    jmp     while_search                ; return to while_search to continue search for the needle
    
else:   
    add     eax, 1                      ; add 1 to eax (middle value)
    mov     ebx, eax                    ; update ebx to hold the new middle value, it becomes the new upper value. Eliminating the left side of the array from the seach.
    jmp     while_search                ; return to while_search to continue search for the needle
    
end:  
    xor     rax, rax                    ; clear out rax
    xor     rbx, rbx                    ; clear out rbx
    xor     rcx, rcx                    ; clear out rcx
    xor     rdx, rdx                    ; clear out rdx
    xor     rdi, rdi                    ; clear out rdi
    ret
