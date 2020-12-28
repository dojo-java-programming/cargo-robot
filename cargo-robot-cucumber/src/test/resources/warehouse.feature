Feature: Solving the Cargo Robot programming puzzles 

# Programming
#
# There are 4 registers as R1 to R4
#
# These can be programmed with the statements / commands:
# D - Down
# L - Left
# R - Right
# 1..4 - Start executing the given register 
#
# Each statement / command can have maximal one of the following labels:
# N - None       - If this label is added to a statement or command, it is only executed if there is no box in the crane 
# A - Any        - If this label is added to a statement or command, it is only executed if there is any box in the crane
# Y - Yellow box - If this label is added to a statement or command, it is only executed if there is yellow box in the crane
# G - Green box  - If this label is added to a statement or command, it is only executed if there is green box in the crane
# B - Blue box   - If this label is added to a statement or command, it is only executed if there is blue box in the crane
# R - Red box    - If this label is added to a statement or command, it is only executed if there is red box in the crane
 

Scenario:
		Given starting the level 'Easy' with challenge 'Double Flip'
		When programming 'R1' with the commands 'DL(A)DR1'
		And  programming 'R2' with the commands 'DL(A)DR1'
		And running the program
		Then goal should be reached


#register -> statement* -> END
#statement: statement command
#         | command
#command: down
#       | left
#       | right
#
       