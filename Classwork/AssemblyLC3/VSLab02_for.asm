.ORIG x3000

LD R0,ITER
LD R2,MAXI
LD R3,NUMB
NOT R2,R2
ADD R2,R2,#1

START_LOOP

ADD R1,R0,R2

BRzp SKIP

ADD R3,R3,#5
ADD R0,R0,#1

BRnzp START_LOOP

SKIP

STI R3,LOCA

HALT


MAXI .FILL #6
ITER .FILL #0
NUMB .FILL #0
LOCA .FILL x8001

.END