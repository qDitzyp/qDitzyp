.ORIG x3000

LD R0,DEC1
LD R1,DEC2
AND R3,R3,#0

START

NOT R1,R1
ADD R1,R1,#1
ADD R2,R1,R0

BRz SAME
BRnp DIFF

DIFF

ADD R3,R3,#5
STI R3,LOCA

HALT

SAME
ADD R3,R3,#-5
STI R3,LOCA

HALT

LOCA .FILL x8002
DEC2 .FILL #6
DEC1 .FILL #6

.END