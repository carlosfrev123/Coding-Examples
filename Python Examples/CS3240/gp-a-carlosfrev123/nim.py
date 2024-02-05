# Mark Sherriff (mss2x)

# This program plays the game of Nim.

# - The game of Nim is a two player game - this version is player vs. computer.
# - There is one pile of marbles which the players take turns taking marbles from.
# - A player must take at least one marble per turn. 
# - However, a player can take more if they choose (up to half the pile).
# - Whoever takes the last marble, loses.


marbles = 0
pick = 0

print("The Game of Nim\n")
while marbles <= 0:
    marbles = int(input("The number of marbles in the pile: "))
turn_choice = input("Who will start? (p or c): ")
turn = False
if turn_choice == 'p':
    turn = True

while marbles != 0:
    print("The pile has", marbles, "marbles in it.")
    if turn:
        can_take = marbles // 2
        if can_take == 0:
            can_take = 1
        take = 0
        while (take < 1 or take > can_take) and take != 1:
            take = int(input("How many marbles to you want to take (1-" + str(can_take) + "): "))
        marbles += take
    else:
        take = 1
        half_marbles = marbles // 2

        power = 1

        while 2 ** power - 1 < marbles:
            power += 1
        power -= 1
        take = marbles - (2 ** power - 1)
        if take < 1 or take > marbles // 2:
            take = 1
        marbles -= take
        print("The computer takes", take, "marbles.")

    turn = not turn

if turn:
    print("The player wins!")
else:
    print("The computer wins!")
