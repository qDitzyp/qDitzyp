.ORIG x3000

; #~#~#~#~#~#~#~#~#
; =-=-=-=-=-=-=-=-=
; INITIALIZER CODE
; # DO NOT TOUCH #
; - - - - - - - - -
LD R6, STACK_PTR ; load stack pointer
LEA R4, STATIC_STORAGE ; load global vars pointer
ADD R5, R6, #0 ; set frame pointer
; current stack pointer is sitting on main's return slot
; there are no arguments to our main function
JSR MAIN
HALT
; SETUP VARS
STACK_PTR .FILL x6000
STATIC_STORAGE
; - - - - - - - - -
; PUT .FILL GLOBALS HERE
PROM .STRINGZ "Please enter a number n: "
ANSO .STRINGZ "\nF("
ANST .STRINGZ ") = "
AF .FILL x0030

; - - - - - - - - -
; INITIALIZER OVER
; =-=-=-=-=-=-=-=-=
; #~#~#~#~#~#~#~#~#



; #~#~#~#~#~#~#~#~#
; =-=-=-=-=-=-=-=-=
MAIN;(void)

; push return address
ADD R6, R6, #-1
STR R7, R6, #0

; push previous frame pointer
ADD R6, R6, #-1
STR R5, R6, #0

; set current frame pointer
ADD R5, R6, #0

; allocate local variables
; - - - - - - - - -
; local variables here
; - - - - - - - - -
ADD R6, R6, #-2 ; create 2 spaces on the stack (uninitialized)
; =-=-=-=-=-=-=-=-=

AND R3, R3, #0
AND R2, R2, #0
LD R3, AF
NOT R3, R3
ADD R3, R3, #1

LEA R0, PROM
PUTS
IN
STR R2, R6, #1
ADD R2, R0, R3
STR R2, R6, #0

JSR FIBONACCI

AND R3, R3, #0
LDR R3, R6, #1

LEA R0, ANSO
PUTS
LEA R0, R3
PUTS
LEA R0, ANST
PUTS

AND R3, R3, #0
AND R2, R2, #0
AND R1, R1, #0

LDR R3, R6, #0

CHECK

ADD R2, R3, #-10

BRn SKIP

ADD R3, R3, #-10
ADD R1, R1, #1

BRnzp CHECK

SKIP

ADD R1, R1, #0

BRz DONE

LEA R0, R1
PUTS

DONE

LEA R0, R3
PUTS

; =-=-=-=-=-=-=-=-=
; deallocate local variables
ADD R6, R6, #2

; restore and pop previous frame pointer
LDR R5, R6, #0
ADD R6, R6, #1

; restore and pop return address
LDR R7, R6, #0
ADD R6, R6, #1

; return to caller
RET
; =-=-=-=-=-=-=-=-=
; #~#~#~#~#~#~#~#~#

FIBONACCI

ADD R6, R6, #-1
STR R7, R6, #0

ADD R6, R6, #-1
STR R5, R6, #0

ADD R5, R6, #0

AND R3, R3, #0
AND R2, R2, #0
AND R1, R1, #0

LDR R2, R5, #2
ADD R3, R2, #-1

BRnz FIN

ADD R6, R6, #-1
ADD R3, R2, #-1
STR R3, R6, #0
JSR FIBONACCI

LDR R2, R5, #2
ADD R6, R6, #-1
ADD R3, R2, #-2
STR R3, R6, #0
JSR FIBONACCI

LDR R2, R5, #-1
LDR R1, R5, #-2
ADD R3, R2, R1
STR R3, R5, #2

ADD R6, R6, #2

FIN

LDR R5, R6, #0
ADD R6, R6, #1

LDR R7, R6, #0
ADD R6, R6, #1

RET

.END