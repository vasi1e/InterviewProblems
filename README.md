# InterviewProblems
This repository contains 2 problems given on interview

# 1. 10 Boxes
## Description
There are 10 boxes with 1000 balls. One ball weights 10 grams. With one weighing on scale say which:
a) box has balls with weight of 11 grams
b) boxes has balls with weight of 11 grams

## Solution
a) If we numerate the boxes from 1 to 10 we can take exactly N balls from the N-th box. After collecting the balls from the boxes we put them on the scale.
The weight that we got will have last digit representing the number of the box that has balls with weight 11 because from every box we will get n balls multiply
by 10(weight of normal ball) but from the box with heavier balls we will be multiplying by 11

b) Again we will need to take different amount of balls from each box so after weighing them we can calculate which boxes are heavier. Separting the boxes in 4 groups
(first one-1,2,4 second one-10,20,40 third one-100,200,400 and fourth-1000) will give us sum of weights that each digit represents the sum of box numbers of each group 

Example:
The first, second and sixth boxes has balls that weight 11 each. So from the first box we take 1 ball\*11g, second box-2 balls\*11g
third-4 balls\*10g, fourth-10 balls\*10g,..., sixth-40balls\*11g and so on. The weight after weighing says 17813 which is by 43 heavier than WEIGHT_IF_ALL_TEN
This means that from the first group(1,2,4) we have sum 3 and from the second group(10,20,40) we have sum of 40
From now it is easy to calculate which index of box was weighing more

# 2. Thief
## Description
You are a thief and you want to write a note for ransom money but if the note is handwriten the police will catch you. You have magazine in front of you.
The program tells you if is possible to write a note using letters from the magazine

## Solution
After recieving the text from the magazine the program puts the letters and the times they occur in hashtable. Now iterating thru the note you want to 
write, the algorithm checks if the current char has value more than 0 in the hash table. if so it continues until the text is over and returns true.
