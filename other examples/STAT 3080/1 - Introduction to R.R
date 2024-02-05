
#########################################################################
#                                                                       #
#  Introduction to R                                                    #
#                                                                       #
#########################################################################

#############
#  General  #
#############

#  R is a program that can be used for statistical computing and        #
#  graphics. It is an interpreted programming language, which means     #
#  that code is submitted interactively line by line. R is an open-     #
#  source software that is maintained by volunteers. All users can      #
#  access and modify source code.                                       #

##############
#  Commands  #
##############

#  In order to get R to do what you want it to do, you will need to     #
#  write a complete command. R is ready for a new command when you      #
#  see a > in the console. If your command is incomplete, R will show   #
#  a + instead of a >. You can either complete the command after the +  #
#  or use the ESC key to abort.                                         #
#                                                                       #
#  To execute a complete command from a script, you can highlight the   #
#  command and click on the Run icon at the top right of the script     #
#  window or you can use the keyboard shortcut Ctrl + Enter.            #
#                                                                       #
#  Commands are separated by either a new line or by a semicolon.       #
#  Users tend to prefer the new line as it typically helps to better    #
#  organize their code.                                                 #
#                                                                       #
#  Another feature that leads to better organized code is that R        #
#  ignores spaces. Users can type their command in the script using     #
#  white space to make logical separations.                             #
#                                                                       #
#  Users can also add comments to their R code by using the hashtag or  #
#  pound sign. Once a line has been started as a comment, all           #
#  future # become a part of the comment. Comments are useful to        #
#  explain what has been coded and why to yourself or to collaborators. #
#                                                                       #
#  Comments can also be used to temporarily restrict certain lines of   #
#  code from running. Users can highlight the code they want to         #
#  comment out and use the keyboard shortcut Ctrl + Shift + C. Users    #
#  can remove the comments by using the same keyboard shortcut a        #
#  second time.                                                         #
#                                                                       #
#  A command can be used for multiple purposes. It can be used to       #
#  install or load a package, to calculate a value, to evaluate a       #
#  function, or to create an object/variable.                           #

##############
#  Packages  #
##############

#  The functionality of R is broken up into various packages. There     #
#  are four packages included in the basic R download - base,           #
#  graphics, stats, utils. In order to use what is in a specific        #
#  package, that package needs to be installed and loaded. You do not   #
#  need to install or load base, graphics, stats, or utils.             #
#                                                                       #
#  In order to install packages, you must have an internet connection.  #
#  Packages only need to be installed once on a computer unless the     #
#  version of R is updated.                                             #

## Installing a package
install.packages("car")

#  Packages can also be installed by using the option under Tools.      #
#                                                                       #
#  Packages that you want to use need to be loaded each time that you   #
#  start a new R session, but only need to be loaded once per session.  #

## Loading a package
library("car")
require("car")

#################
#  Calculation  #
#################

#  R can be used as a calculator by using the standard arithmetic       #
#  operators:                                                           #
#  + (addition)                                                         #
#  - (subtraction)                                                      #
#  * (multiplication)                                                   #
#  / (division)                                                         #
#  ^ (power)                                                            #
#                                                                       #
#  R is like any calculator in that these operators follow the          #
#  standard order of operations.                                        #

## Calculation examples
15 + 10
12/6
0.7*5
3^3
15+10*3
(15+10)*3

###############
#  Functions  #
###############

#  Contained in all of its packages, R has an extensive list of         #
#  existing functions that can be used. Each function has a specific    #
#  name that is followed by a set of parentheses. Using a function      #
#  calls a specific collection of code to be executed. Generally the    #
#  code that will be executed needs specific inputs to run correctly    #
#  and the user provides these values in the parentheses that follow    #
#  the function name.                                                   #
#                                                                       #
#  Functions can be used for basic calculations, for complex            #
#  procedures, and many other things in between. Users can also write   #
#  their own functions.                                                 #
#                                                                       #
#  R is case-sensitive, so functions that you want to use must be       #
#  typed exactly as it was defined.                                     #

## Some function examples
log(2.7)  #this function is the log with base e, sometimes written as ln
Log(2.7)
exp(1)
sqrt(9)
factorial(3)
abs(-5)
sum(2,4,6)
floor(5.7)
ceiling(5.7)
trunc(5.7)
round(5.7,0)
round(5.727,2)

#  The defined probability distributions each have four functions in R. #
#  Each distribution has a general function name (ie. norm, binom, t).  #
#  The letter that precedes the distribution name tells R what          #
#  specifically to do with that distribution. The first option,         #
#  denoted by d, gives the value of the probability density function    #
#  at the point specified. The second option, denoted by p, determines  #
#  the cumulative probability of the distribution at the point          #
#  specified. The third option, denoted by q, determines the value      #
#  within the distribution associated with the cumulative probability   #
#  specified. The fourth option, denoted by r, generates random         #
#  numbers from the distribution.                                       #

## Determining the probability density function
dnorm(0)
dbinom(5, size=10, prob=0.3)

## Determining the cumulative probability 
pnorm(1.96)
pnorm(4.5, mean=2, sd=1.6)
pt(2.0, df=6)
punif(0.7)
punif(5, min=3, max=8)
pchisq(7, df=3)
pbinom(5, size=10, prob=0.3)

## Determining the value corresponding to the cumulative probability
qnorm(0.025)
qnorm(0.7, mean=2, sd=1.6)
qt(0.95, df=12)
qunif(0.35, min=3, max=8)
qchisq(0.99, df=3)
qbinom(0.9, size=10, prob=0.3)

## Generating random numbers
rnorm(10)
rnorm(10, mean=2, sd=1.6)
rt(10, df=12)
runif(10)
runif(10, min=3, max=8)
rchisq(10, df=3)
rbinom(10, size=10, prob=0.3)

#  Every function has corresponding documentation that can be accessed  #
#  directly from RStudio. The specific help documentation for a given   #
#  function will be opened by executing either of the commands shown    #
#  below.                                                               #
#                                                                       #
#  These documentation files are only available for the                 #
#  packages that have been loaded. If you attempt to find a             #
#  documentation file for a function in a package that you have not     #
#  loaded, the help file will not be found.                             #

## Opening help documentation
help(round)
?round
?rnorm

#######################
#  Objects/variables  #
#######################

#  In order to write useful and effective R code, users need to be      #
#  able to store items to be used later. Anything that is stored is     #
#  called an object. An object can be a single value resulting from a   #
#  calculation or a collection of information such as a table of        #
#  linear regression coefficients. A variable is a memory location for  #
#  the object, which can be thought of as a label for the object.       #
#  Variables are created when the object is assigned to it, so there    #
#  is no need to declare the variable first.                            #
#                                                                       #
#  Variable names can consist of letters, numbers, periods, and         #
#  underscores. There are a few limitations to how these types of       #
#  characters can be combined. The following are characteristics of     #
#  all variable names:                                                  #
#    1. Variable names cannot begin with a number.                      #
#    2. Variable names cannot contain spaces.                           #
#    3. Variable names can begin with a period as long as they are      #
#       not followed by a number.                                       #
#    4. Since R is case-sensitive, x and X are different variable       #
#       names.                                                          #
#                                                                       #
#  Wherever possible, it is best practice to avoid using the names      #
#  of existing functions (ie. mean, sd, log) and predefined             #
#  variables (ie. pi) to avoid confusion for anyone reading your code   #
#  and possibly R itself.                                               #
#                                                                       #
#  It is also best practice to use variable names that are short and    #
#  descriptive of the information contained in the object.              #
#                                                                       #
#  Once you have decided on a variable name for the object, you will    #
#  need to assign the object to the variable by using either the        #
#  assignment operator <- or = (the first is the more commonly used).   #

## Assigning objects to variables
total1 <- 10+15
value1 <- round(5.7,0)

#  R will recall or show the object stored in a variable when the       #
#  variable name is submitted as a command.                             #

total1
Total1
value1

#  Stored objects can be used in subsequent operations.                 #

total1/5
total1/value1

#  Any object that you would like stored needs to be given a variable   #
#  name.                                                                #

ratio1 <- total1/value1

#  Variables can be overwritten by storing a new object using the same  #
#  variable name.                                                       #

ratio1 <- total1/2

##################### end of section 1 ##################################


#####################
#  Data structures  #
#####################

#  The type of data structure that you will use will depend on the      #
#  dimensionality of your data and whether or not they are homogeneous. #
#                                                                       #
#  A single value is considered to have zero dimensions and is called   #
#  a scalar.                                                            #
#                                                                       #
#  A data structure that is either a single column or a single row is   #
#  considered to have one dimension. If everything recorded in a        #
#  one-dimensional data structure is of the same type, then it is       #
#  called a vector. If the items recorded in a one-dimensional data     #
#  structure have varying types, then it is called a list.              #
#                                                                       #
#  A data structure that contains multiple rows and multiple columns    #
#  is considered to have two dimensions. If the contents of a           #
#  two-dimensional data structure are homogeneous, then it is called    #
#  a matrix. If the contents of a two-dimensional data structure are    #
#  heterogeneous, then it is called a data frame.                       #

##########################################
#  Creating homogeneous data structures  #
##########################################

#  Data structures are created either when data are read in from        #
#  external files or when data are entered manually.                    #
#                                                                       #
#  The concatenate function, c(), is commonly used to create a vector.  #
#  The inputs for this function are the data that you would like stored #
#  in the vector in the order in which you would like them stored.      #

## Creating a variable using the concatenate function
x <- c(5,10,15,20,25)
x
y <- c(3,6,9,12,15)
y

#  The concatenate function can also be used to add a value to a        #
#  vector or to combine preexisting vectors.                            #

x2 <- c(x,30)
z <- c(x,y)
z

#  It is important to remember that the order in which the objects are  #
#  specified is the order in which they will be saved in the vector.    #   

c(y,x)

#  The matrix() function can be used to create a matrix. This function  #
#  takes four inputs - vector, nrow, ncol, and byrow. These inputs      #
#  instruct R what values to put in the matrix, how many rows and       #
#  columns the matrix should have, and whether values should be         #
#  assigned across the rows or down the columns. The default for the    #
#  byrow option is false, meaning that the values will be assigned      #
#  down the columns if the byrow option is not provided.                #

matrix(c(5,10,15,20,25,3,6,9,12,15), nrow=2, ncol=5, byrow=TRUE)
matrix(c(5,10,15,20,25,3,6,9,12,15), nrow=5, ncol=2, byrow=FALSE)

matrix(c(5,10,15,20,25,3,6,9,12,15), nrow=5, ncol=2, byrow=TRUE)
matrix(c(5,10,15,20,25,3,6,9,12,15), nrow=2, ncol=5, byrow=FALSE)

#  Another way to create a matrix is to use either the cbind() or       #
#  rbind() function. Both of these functions use vectors as inputs.     #
#  The cbind() function will bind these vectors together as columns     #
#  and the rbind() function will bind these vectors together as rows.   #

rbind(x,y)
cbind(x,y)

#  As with the concatenate function, R will bind the vectors together   #
#  in the order you specify.                                            #

cbind(x,y)
cbind(y,x)

#####################
#  Pattern vectors  #
#####################

#  There are times when you may need to create a vector that contains   #
#  a sequence of numbers. There are two ways to create this type of     #
#  variable.                                                            #
#                                                                       #
#  If you are wanting to create a vector that contains a sequence of    #
#  consecutive integers, then you can use the syntax a:b to create a    #
#  vector that starts at a and increases or decreases by one until b.   #
#                                                                       #
#  Whether the sequence increases or decreases depends on the           #
#  relationship between a and b. If a is less than b, then the          #
#  sequence will increase, and, if a is greater than b, then the        #
#  sequence will decrease.                                              #

1:5
5:1
-1:-5
-5:-1

#  If you are wanting a sequence where the values have a constant       #
#  difference other than one, then you can use the sequence             #
#  function, seq(). This function takes three inputs - from, to, by.    #
#  These inputs specify the first and last number of the sequence as    #
#  well as the difference between each value in the sequence.           #

seq(to=5,from=1,by=0.5)
seq(-5,-1, 0.5)

#  The default value for the by input is +/-1, meaning that if you      #
#  only specify the from and to inputs, the function will yield a       #
#  sequence of consecutive integers between the two provided values.    #

seq(1,5)
seq(5,1)

#  There is another optional input for the sequence function - length.  #
#  The length option specifies the length that you want your vector     #
#  to be or how many values you want contained in the vector. The       #
#  sequence function will use this value to determine a constant        #
#  difference between each of the values that yields the number of      #
#  values that you specify.                                             #

seq(1,5, length=5)
seq(1,5, length=9)

#  It is possible to use both the by and length options, but the        #
#  function will not execute if they do not agree. If you use the       #
#  length option, you need to use length= as shown above to tell R to   #
#  use the length option instead of the by option.                      #
#                                                                       #
#  Another function that creates a useful type of vector is the         #
#  repeat or replicate function, rep(). This function takes two         #
#  inputs - vector and times. These inputs specify what you would       #
#  like R to repeat and how many times. Depending on the format of      #
#  what you provide in the times option, this function will either      #
#  repeat the given vector a specified number of times or repeat the    #
#  elements of the vector a specified number of times.                  #

rep(1:5, 2)
rep(1:5, c(1,2,3,2,1))
rep(1:5, c(2,2,2,2,2))

#  If you want to repeat each element in the provided vector a          #
#  specific number of times, you can use the each option in place of    #
#  the times option. In order to use this option, you will need to      #
#  specify it with each=.                                               #

rep(1:5, each=2)

##################
#  Data classes  #
##################

#  There are several classes of homogeneous data. The three main        #
#  classes are: logical, numeric, and character. The class of the       #
#  structure reflects the type of data that is stored and will be in    #
#  part determined by how the data are entered.                         #

## Creating a logical vector
log_vect <- c(TRUE, FALSE, T, F)

## Creating a character vector
char_vect <- c("ByOne", "ByTwo", "ByThree", "ByFour", "ByFive")

#  If a vector or matrix contains multiple types of data, R will        #
#  modify the data to all be of the same type according to the          #
#  following hierarchical structure:                                    #
#  1. character                                                         #
#  2. numeric                                                           #
#  3. logical                                                           #

c(TRUE, 5)
c("ByFive", 5)
c(TRUE, "ByFive", 5)

mult_mat <- cbind(char_vect,x,y)
mult_mat

#  The class() function specifies the class of the data structure used  #
#  as the input. For most structures, the class will be the type of     #
#  the structure. As vectors are the default data structure for         #
#  one-dimensional variables, the class() function will return the      #
#  data class when a vector is input.                                   #

class(mult_mat)
class(x)
class(log_vect)
class(char_vect)

#  It may be useful to check the class of an object and receive a       #
#  logical answer (T or F). The following functions conduct this type   #
#  of test of the class of an object:                                   # 
#  is.character()                                                       #
#  is.numeric()                                                         #
#  is.logical()                                                         #

## Testing the type of a vector
is.character(char_vect)
is.character(log_vect)
is.character(mult_mat)

#  The class of an object can be coerced to change by using the         #
#  following functions:                                                 #
#  as.character()                                                       #
#  as.numeric()                                                         #
#  as.logical()                                                         #

## Changing the type of vector
as.character(log_vect)
as.logical(char_vect)
as.numeric(mult_mat)

#  Note that coercing an object to change will not always yield a       #
#  logical result.                                                      #
#                                                                       #
#  Simply using the coercing functions above will not change a stored   #
#  object. You must overwrite the existing variable or create a new     #
#  variable in which to store the coerced object.                       #

############################################
#  Creating heterogeneous data structures  #
############################################

#  Data frames are commonly used to store data. There is typically a    #
#  row for each observation and a column for each variable measured on  #
#  the observations. A data frame can be created using the              #
#  data.frame() function. The inputs to this function are the vectors   #
#  that you would like to be in the data frame.                         #

mult_data <- data.frame(char_vect,x,y)
mult_data

#  Lists are the most flexible type of object in R. Lists are similar   #
#  to vectors in that there is one row containing multiple values.      #
#  However, in a list, those values can be objects of varying types     #
#  and sizes. A list is created using the list function, list(). The    #
#  inputs specify what you would like in each element of the list.      #

mult_list <- list(mult_data, z, log_vect, 7)
mult_list

#########################################
#  Changing the type of data structure  #
#########################################

#  There are testing and cohersion functions for all of the types of    #
#  data structures. As with the classes of data, cohersion may not      #
#  yield a valid result.                                                #

is.vector(x)
as.list(x)

is.list(mult_list)
as.vector(mult_list)
class(as.vector(mult_list))

is.matrix(mult_mat)
as.data.frame(mult_mat)

is.data.frame(mult_data)
as.matrix(mult_data)

##################### end of section 2 ##################################

########### objects/packages needed ###########
x <- c(5,10,15,20,25)
y <- c(3,6,9,12,15)
z <- c(x,y)
log_vect <- c(TRUE, FALSE, T, F)
char_vect <- c("ByOne", "ByTwo", "ByThree", "ByFour", "ByFive")
mult_mat <- cbind(char_vect,x,y)
mult_data <- data.frame(char_vect,x,y)
mult_list <- list(mult_data, z, log_vect, 7)
library(car)
###############################################


####################################
#  Label names in data structures  #
####################################

#  Descriptive and appropriate names can be added to columns, rows, or  #
#  values within data structures. For data frames and lists, column     #
#  names can be added while creating the data structure.                #

mult_data2 <- data.frame(Factor=char_vect, Fives=x, Threes=y)
mult_data2

mult_list2 <- list(Factor.Table=mult_data, FiveThree=z, 
                   Logical.values=log_vect, DaysPerWeek=7)
mult_list2

#  Column, row, or value labels can also be added to an existing data   #
#  structure using one or more of the following functions: names(),     #
#  rownames(), and colnames(). The appropriate function(s) to use       #
#  depends on the type of data structure needing label names.           #

## Labeling values in a vector
names(x) <- char_vect
x

## Labeling rows and columns in a matrix
mult_mat2 <- cbind(x,y)
rownames(mult_mat2) <- char_vect
colnames(mult_mat2) <- c("Fives","Threes")
mult_mat2

## Labeling rows and columns in a data frame
names(mult_data) <- c("Factor","Fives","Threes")
mult_data

## Labeling values in a list
names(mult_list) <- c("Factor.Table", "FiveThree", "Logical.values", 
                      "DaysPerWeek")
mult_list

#  The names function can also be used to display the names of a data   #
#  structure.                                                           #

names(x)
names(mult_data)
names(mult_list)

################################
#  Subsetting data structures  #
################################

#  Once a data structure is created and stored, it may be useful in     #
#  subsequent analyses to subset that data structure.                   #
#                                                                       #
#  The typical notation to subset vectors is a set of square brackets   #
#  used directly after the variable name of the vector. The             #
#  information given inside the brackets specifies which values should  #
#  be extracted from the vector.                                        #
#                                                                       #
#  The most basic way to subset a vector is to include in the square    #
#  brackets the position of the value you would like to be in the       #
#  subset. The position index of any vector begins at 1 and uses        #
#  consecutive positive integers up to the length of the vector.        #

x
x[3]

#  Multiple positions can be specified by using a vector in the         #
#  square brackets.                                                     #

x[c(1,3)]
x[2:3]

#  If a position is duplicated in the square brackets, the              #
#  corresponding value in the vector will be subset twice.              #

x[c(1,1)]

#  If a negative sign is added to the square brackets, the specified    #
#  value(s) will be omitted instead of included in the subset.          #

x[-1]
x[-(2:3)]
x[-c(1,4)]

#  Instead of specifying the positions that you would like included or  #
#  excluded from the subset, you can specify a logical vector in the    #
#  square brackets. With this type of input, R will include the         #
#  elements corresponding to TRUE and exclude the elements              #
#  corresponding to FALSE.                                              #

x[c(F,T,T,F,T)]

#  If the number of logical inputs does not match the length of the     #
#  vector, R will repeat the logical inputs until there is a logical    #
#  input corresponding to each vector element.                          #

x[c(F,T)]

#  The resulting subset vectors will only be stored if you define a     #
#  variable name and assign the subset vector to it.                    #

evens <- x[c(F,T)]
x
evens

#  The square brackets following a vector can also be used to replace   #
#  or add one or more values in a vector.                               #

x2 <- x
names(x2) <- NULL

x2[6] <- 30
x2

x2[7:9] <- c(35,40,45)
x2

x2[c(1,3)] <- 0
x2

#  Note that because the assignment operator <- is being used, the      #
#  updated vector is stored under the same variable name.               #
#                                                                       #
#  It is often best practice to keep a copy of the data used in each    #
#  step of an analysis, in which case, you should create a new copy of  #
#  the vector before making any changes.                                #

#  To subset a matrix or data frame, the same square bracket notation   #
#  is used. However, because matrices and data frames are               #
#  two-dimensional structures, two inputs are required in the square    #
#  brackets. The first input references the row and the second input    #
#  references the column.                                               #

mult_data

## Subsetting the value in the first row and second column
mult_data[1,2]

## Subsetting the values in the first two rows and first two columns
mult_data[1:2,1:2]

## Subsetting the values in multiple rows and the first two columns 
mult_data[c(1,4),2:3]

## Subsetting the entire first row
mult_data[1,]

## Subsetting the entire second column
mult_data[,2]

## Subsetting all but the first row
mult_data[-1,]

## Subsetting all but the third column
mult_data[,-3]

## Subsetting the third column twice
mult_data[,c(3,3)]

## Duplicating the third column
mult_data[,c(1:3,3)]

#  A list is subset to any of its elements by using double square       #
#  brackets, [[ ]].                                                     #

mult_list[[3]]

#  Double square brackets are limited to one value. In order to subset  #
#  multiple elements of a list, single square brackets can be used.     #
#  This syntax will result in a list with fewer elements instead of     #
#  multiple vectors.                                                    #

mult_list[2:3]
mult_list[2:3][2]

#  When subsetting columns of a data frame or an element of a labeled   #
#  list, the name of the column/element can be used within the square   #
#  brackets or using $ syntax.                                          #

mult_data[,"Fives"]
mult_data$Fives

mult_list[["Logical.values"]]
mult_list$Logical.values

#  When subsetting any data structure, multiple sets of square brackets #
#  can be used to subset the resulting data structure further. The      #
#  subsequent sets of square brackets must be appropriate for the       #
#  data structure resulting from the previous subset.                   #

x[c(1,3,5)][3]

mult_data[1:3,1:2][2,]
mult_data$Fives[2]
mult_data$Factor[5]

mult_list[[3]][2]

######################
#  Factor variables  #
######################

#  Categorical data are read into data frames as factors. Factor        #
#  variables group categorical data into sets containing values with    #
#  the same string. Each set is given a numerical code that represents  #
#  the corresponding categorical value.                                 #

head(Davis) # This data set is contained in the car package
Davis$sex

#  Coercion functions can be used to turn factor vectors into           #
#  categorical vectors and vice versa.                                  #

as.character(mult_data[,1])
as.factor(char_vect)

#########################
#  Logical expressions  #
#########################

#  It may be useful to use a logical expression to determine which,     #
#  if any, elements in a vector have certain qualities. When a logical  #
#  expression is applied to a vector, the result will be a vector       #
#  containing TRUE where the condition is satisfied and a FALSE where   #
#  the condition is not satisfied.                                      #

## Are any elements greater than 15?
x > 15

## Are any elements greater than or equal to 15?
x >= 15

## Are any elements exactly equal to 15?
x == 15

## Are any elements not equal to 15?
x != 15

#  Multiple logical expressions can be combined using either and or or. #

## Are any elements in x greater than 15 and the same element in y is equal to 12?
x > 15 & y == 12

## Are any elements greater than 15 or less than 7?
x > 15 | x < 7

#  The logical vectors that result from logical expression statements   #
#  can be used in the square brackets to subset a vector just to the    #
#  values that satisfy the condition.                                   #

x[x>15]

#  Instead of yielding a logical vector for each entry in a vector,     #
#  the which function, which(), yields the positions in the vector      #
#  where the condition is satisfied. The which function can also be     #
#  used in the square brackets to subset a vector to just the values    #
#  that satisfy the condition.                                          #

which(x>15)
x[which(x>15)]

##################### end of section 3 ##################################

########### objects/packages needed ###########
x <- c(5,10,15,20,25)
x2 <- x
y <- c(3,6,9,12,15)
z <- c(x,y)
log_vect <- c(TRUE, FALSE, T, F)
char_vect <- c("ByOne", "ByTwo", "ByThree", "ByFour", "ByFive")
names(x) <- char_vect
mult_mat2 <- cbind(x,y)
mult_data <- data.frame(char_vect,x,y)
mult_list <- list(mult_data, z, log_vect, 7)
library(car)
###############################################


######################################
#  Calculation with data structures  #
######################################

#  The standard arithmetic operators can be applied to data structures  #
#  containing numeric values as well as to single values. Since there   #
#  are multiple values stored in a data structure, there are different  #
#  ways that the arithmetic operators can be used.                      #
#                                                                       #
#  To perform the same constant arithmetic operation on each element    #
#  of a numeric data structure, you will use the object name, the       #
#  arithmetic operation symbol, and the constant.                       #

x*2
x/5
x^3

mult_mat2+10
mult_mat2-5
mult_mat2*2

#  You may have related numeric information stored in two data          #
#  structures of the same shape and you may want to perform an          #
#  arithmetic operation on each pair of related values.                 #

x+y
x*y
y/x

mult_mat3 <- cbind(2*(1:5), 6*(1:5))

mult_mat2+mult_mat3
mult_mat2/mult_mat3

#  Using standard arithmetic operators with two numeric data            #
#  structures will apply the arithmetic operator to the corresponding   #
#  pairs of values. If your related data are not in the same order      #
#  within the data structures, you will need to modify one or both      #
#  until they are in the same order.                                    #

####################################
#  Functions with data structures  #
####################################

#  Data structures can be used as inputs to several functions.          #
#  Functions may also output a data structure.                          #

sum(x2)
sum(mult_mat2)
sum(mult_data)
mean(x2)
median(x2)
var(x2)
sd(x2)
max(x2)
min(x2)
range(x2)
sort(x2)
sort(char_vect)
rev(x2)
quantile(x2) # This function has an optional second input to specify which 
              # quantile you want shown
summary(x2)
cumsum(x2)
cumprod(x2)
cor(x,y)

#  When working with more complex data structures, users may want to    #
#  summarize only some of the values. In this case the family of        #
#  apply() functions can be used. The apply() functions apply a         #
#  pre-existing or user-defined function to the data structure in a     #
#  manner specified by the user.                                        #

#  The apply() function is used for a two-dimensional data structure.   #
#  It uses three inputs - data, margin, and function. The data input    #
#  specifies the matrix or data frame to which the function should be   #
#  applied, margin specifies whether you want the function applied to   #
#  the rows, columns, or individual values, and function specifies the  #
#  function to be applied.                                              #

apply(mult_mat2, 2, sum)
apply(mult_mat2, 1, mean)

apply(mult_mat2, 2, quantile)
apply(mult_mat2, 2, quantile, 0.25)

#  The tapply() function is used for a vector of values that can be     #
#  categorized by a second vector of values. It uses three inputs -     #
#  data, categorizations, and function. The data input specifies the    #
#  vector of values that should be grouped and to which the function    #
#  should be applied, categorizations specifies the category of each    #
#  corresponding value in the data vector, and function specifies the   #
#  function to be applied to each resulting group.                      #

tapply(Davis$weight, Davis$sex, mean)

#  The lapply() and sapply() functions are both used for lists. Once    #
#  the specified function is applied, lapply() returns a list and       #
#  sapply() returns a vector. They use two inputs - data and function.  #
#  The data input specifies the list of elements to which the function  #
#  should be applied and function specifies the function.               #

lapply(mult_list, sum)
lapply(mult_list[-1], sum)
sapply(mult_list[-1], sum)

#######################
#  Writing functions  #
#######################

#  For code that needs to be repeated in differing situations, it is    #
#  most efficient to write a relevant function that can be used in      #
#  easy appropriate case. Functions are defined with three main         #
#  components - the function statement, the arguments that the          #
#  function will take, and the code that should be executed when the    #
#  function is called.                                                  #

samp_mean <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  mean(samp)
}

#  To execute the function, the function name is called like any        #
#  pre-existing function and the result of the last command will be     #
#  returned.                                                            #

samp_mean(10)

#  To return multiple values from a function, the relevant values need  #
#  to be combined into a single data structure that will be returned.   #

samp_sum <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  c(mean=mean(samp), sd=sd(samp))
}

samp_sum2 <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  list(mean=mean(samp), sd=sd(samp))
}

samp_sum(10)
samp_sum2(10)

#  A written function does not need to be saved as an object to be      #
#  used. An anonymous function needs to be defined within parentheses   #
#  and called in the same command.                                      #

(function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  median(samp)
})(10)

#  The lapply() function can be used in a specific way with anonymous   #
#  functions to create a list. The anonymous function specified within  #
#  the lapply() function must specify an input for the list input of    #
#  the lapply() function, whether or not that input is used.            #

lapply(1:5, function(x) rnorm(10, mean=15.8, sd=4.1))

##################### end of section 4 ##################################

########### objects/packages/functions needed ###########
library(car)
samp_sum <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  c(mean=mean(samp), sd=sd(samp))
}
samp_sum2 <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  list(mean=mean(samp), sd=sd(samp))
}
#########################################################


#################
#  Replication  #
#################

#  The replicate() function evaluates a given function the specified    #
#  number of times and returns a matrix with a column containing the    #
#  results from each replication. There are two inputs - the number of  #
#  replications and the function to be replicated.                      #

replicate(5, rnorm(10))
replicate(5, rnorm(10, 2, 1.6))

replicate(5, samp_sum(10))
replicate(5, samp_sum2(10))

##############
#  Sampling  #
##############

#  The sample() function draws a random sample of provided values. The  #
#  inputs for this function are the vector of values from which to      #
#  sample, how many values to draw, and whether to replace the values.  #
#  The defaults are without replacement sampling and the number of      #
#  values in the original vector.                                       #

wtdata <- Davis$weight
sample(wtdata)
sample(wtdata, 10)
sample(wtdata, 10, replace=TRUE)

############################
#  Conditional statements  #
############################

#  The appropriate conditional statements depend on the number of       #
#  values needing evaluation. To evaluate a single value, the if(),     #
#  then(), and else() functions are used. To evaluate several values    #
#  simultaneously, the ifelse() function is used.                       #

trunc_sum <- function(size){
  samp <- rnorm(size, mean=15.8, sd=4.1)
  if(mean(samp) < 15){c(mean=15, sd=sd(samp))}
  else{c(mean=mean(samp), sd=sd(samp))}
}

trunc_out <- replicate(10, trunc_sum(10))
trunc_out

ifelse(trunc_out[1,] == 15, "low", "not")

###########
#  Loops  #
###########

#  While written functions and the apply() family of functions reduce   #
#  the need for loops drastically, there may be times when using a      #
#  loop is necessary.                                                   #
#                                                                       #
#  A for loop is composed of five main pieces - the for statement, the  #
#  index variable, the in statement, the vector of values for which     #
#  the for loop should run, and the code to be repeated. The index      #
#  variable can either be used in the repeated code or not.             #
#                                                                       #
#  If values are being calculated in the loop that need to be saved,    #
#  it is best practice to create a data structure to record the values  #
#  before beginning the loop.                                           #

means <- NULL
for(i in 1:5){
  samp <- rnorm(10, mean=15.8, sd=4.1)
  means[i] <- mean(samp)
}

means

#  The next and break options can be added to any loop within           #
#  conditional statements to stop the loop entirely under certain       #
#  conditions or to move onto the next iteration.                       #

means <- NULL
for(i in 1:15){
  samp <- rnorm(10, mean=15.8, sd=4.1)
  if(mean(samp) < 15){next}
  means[i] <- mean(samp)
}

means

means <- NULL
for(i in 1:15){
  samp <- rnorm(10, mean=15.8, sd=4.1)
  if(mean(samp) < 15){break}
  means[i] <- mean(samp)
}

means

#####################
#  Importing files  #
#####################

#  Typically, the data you will want to use will be stored in another   #
#  file that is saved somewhere on your computer. Users are able to     #
#  specify a particular location that R will then use to look for and   #
#  save files. This location is called the working directory. The       #
#  working directory is set by using the function setwd(). R requires   #
#  path names to use either the forward slash or a double backslash.    #

setwd("C:/Users/gaf9f/Documents/3080 Fall 2021/Course materials/Data")

#  You can check the location of the working directory by using the     #
#  function getwd().                                                    #

getwd()

#  Once the working directory is set to the appropriate location,       #
#  users are able to import data files that are saved there. The most   #
#  reliable function for reading in data from an external file is to    #
#  use the function read.table(), which will read in a .txt file and    #
#  create a data frame. This function requires two inputs - the file    #
#  name and whether the data being read in have headers. The default    #
#  for the headers option is FALSE, so if you do have headers in your   #
#  data file, they will be read in as the first row of the table        #
#  unless you specify TRUE for this option.                             #

read.table("Data1.txt", header=TRUE)
read.table("Data1.txt")

#  If you have not set a working directory, the entire path to the      #
#  data file needs to be specified.                                     #
#                                                                       #
#  The read.table() function will fail if any of the column headers     #
#  contain spaces. Any space issues need to be fixed in the data file   #
#  before reading it into R.                                            #
#                                                                       #
#  If the data file is comma separated (.csv), the function read.csv()  #
#  can be used to read in the data. This function takes three           #
#  inputs - file, header, separation. The default for header is TRUE    #
#  and the default for separation is comma.                             #

read.csv("Data1.csv")

##################### end of section 5 ##################################








