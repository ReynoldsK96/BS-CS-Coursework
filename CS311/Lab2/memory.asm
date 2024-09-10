;Name: Katherine Reynolds
;Student ID: 24556946
;Date: 10/08/2021
;Honor Code: I pledge that this submission is solely my work, and that I have neither given, nor received help from anyone.
        
        segment .data
a       db      50
b       dw      60
c       dd      70
d       dd      25.125
e       dw      32452  

        segment .bss       
g       resw    10    
h       resb    50
i       resd    15

        section .text
        global  main        
main:
        push    rbp         
        mov     rbp, rsp    
        sub     rsp, 16     
                            
        xor     eax, eax    
        leave               
        ret
