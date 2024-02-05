
#########################################################################
#                                                                       #
#  tidyverse in R                                                       #
#                                                                       #
#########################################################################

########### objects/packages needed ###########
library(tidyverse)
library(car)
mult_data <- data.frame(Factor=c("ByOne","ByTwo","ByThree","ByFour",
                                 "ByFive","BySix","BySeven","ByEight"),
                        Fives=seq(5,40,5), Fours=seq(4,32,4), 
                        Threes=seq(3,24,3), Twos=seq(2,16,2),
                        E_O=rep(c("O","E"),4))
###############################################

########################
#  General background  #
########################

#  The tidyverse is a collection of packages written primarily by       #
#  Hadley Wickham that aim to improve and tidy the process of working   #
#  with data from initial importation to visualization to complex       #
#  analysis. Each of the tidyverse packages focuses on a particular     #
#  portion of the process.                                              #
#  - The package readr contains functions for reading in external       #
#    files.                                                             #
#  - The package tidyr contain functions for transforming data between  #
#    long-form and wide-form.                                           #
#  - The package dplyr contains functions for subsetting, summarizing,  #
#    and joining data.                                                  #
#  - The package stringr contains functions for working with string     #
#    data.                                                              #
#  - The package lubridate contains functions for working with time     #
#    and date data.                                                     #
#  - The package forcats contains functions for working with            #
#    categorical data.                                                  #
#  - The package purr contains functions for functional programming.    #
#  - The package ggplot2 contains functions for graphing data.          #
#                                                                       #
#  The tidyverse uses a different type of data structure called a       #
#  tibble. A tibble is a two-dimensional, heterogeneous data structure  #
#  and is similar to a data frame. Tibbles are different from data      #
#  frames mainly in that they do not coerce character data into factor  #
#  data, they display the data type contained in each column beneath    #
#  the column name, and only the first ten rows and the columns that    #
#  will fit are displayed when printed in the Console. The names and    #
#  types of columns not displayed are listed underneath the printed     #
#  data.                                                                #
#  Note: chr is character, dbl is numeric, int is integer,              #
#        lgl is logical, fctr is factor                                 #
#                                                                       #
#  When using a tidyverse function on an existing data frame, the       #
#  resulting data structure is also a data frame. When a tidyverse      #
#  function creates a new data structure, it will be a tibble. A        #
#  tibble can be created using the tibble() function. A data structure  #
#  can be coerced into a tibble using the as_tibble() function.         #

#######################
#  Data manipulation  #
#######################
#                                                                       #
#  The package dplyr contains various functions that are functional     #
#  for data manipulation.                                               #
#                                                                       #
#  The filter() function subsets rows of a data frame and takes at      #
#  least two inputs -- the data to be subset and the selection          #
#  condition(s). Selection conditions involving different columns of    #
#  the data are separated by a comma to apply them as &. Multiple       #
#  selection conditions involving the same column of the data must be   #
#  combined with & or |.                                                #

filter(mult_data, Fives>25)
filter(mult_data, Fives>25, Fours>12)
filter(mult_data, Fives>25 | Fours>12)
filter(mult_data, Fives>25 | Fives<10)

#  The select() function subsets columns of a data frame and takes at   #
#  least two inputs -- the data to be subset and the column(s) to be    #
#  subset.                                                              #

select(mult_data, Fives)
select(mult_data, Fives, Threes)
select(mult_data, Fives:Threes)

#  The summarise() or summarize() function will calculate summaries of  #
#  the data and takes at least two inputs -- the data to be summarized  #
#  and how to summarize the data with what the resulting column should  #
#  be named. Multiple summaries are separated by commas.                #

summarize(mult_data, s.Fives=sum(Fives), s.Four=sum(Fours), 
          s.Threes=sum(Threes), s.Twos=sum(Twos))

#  The group_by() function is often used with the summarize() function  #
#  to obtain summaries for differing groups.                            #

mult_data2 <- group_by(mult_data, E_O)
summarize(mult_data2, s.Fives=sum(Fives), s.Four=sum(Fours), 
                      s.Threes=sum(Threes), s.Twos=sum(Twos))

#  The tidyverse also makes use of the piping operator %>% to directly  #
#  input the result of one command as the first input of the next       #
#  command.                                                             #

group_by(Davis, sex) %>%
  summarize(avg.height=mean(height), avg.weight=mean(weight))

#########################################################################

