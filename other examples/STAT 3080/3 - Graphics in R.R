
#########################################################################
#                                                                       #
#  Graphics in R                                                        #
#                                                                       #
#########################################################################

########### objects/packages needed ###########
library(ggplot2)
# OR library(tidyverse)
library(car)
library(gcookbook)
library(MASS)
###############################################

#############
#  General  #
#############

#  There are several different ways to produce graphics in R. Many      #
#  exist in the base graphics package.                                  #

## Scatterplot of tree circumference vs. tree age
plot(Orange$age, Orange$circumference)

## Histogram of tree circumference
hist(Orange$circumference)

#  A commonly used package for graphics is ggplot2.                     #

#####################
#  ggplot2 package  #
#####################

#  The main idea behind graphics in ggplot2 is that different layers    #
#  of the plot are specified by the user and then added together.       #
#  Layers have one of three purposes:                                   #
#     1. Display the data                                               #
#     2. Display a statistical summary of the data                      #
#     3. Add metadata, context, and annotations                         #
#                                                                       #
#  A graph is not displayed until there is at least one layer.          #
#  Generally, the first layer is specified by using the function        #
#  ggplot(). In this function, the data to be used for the entire       #
#  graphic and/or the aesthetic features for the entire graphic can     #
#  be specified. If these are not given in the ggplot() statement,      #
#  they must be specified in each layer. Aesthetic features for the     #
#  entire graphic are specified within the aes() function.              #

##################
#  Scatterplots  #
##################

## Look at the first 5 rows of the Davis data (contained in the car package)
Davis[1:5,]

## Define the first layer of a scatterplot of reported weight vs.
## measured weight
DavisPlot <- ggplot(Davis, aes(x=weight, y=repwt))
DavisPlot

#  A layer can contain any of many different elements. One of the most  #
#  basic elements that will be contained in a graphics layer is a       #
#  geometric object (ie. points, lines, bars, etc.). These are added    #
#  using one of many functions of the form geom_"object name"(). A full #
#  list of possible geometric objects is given on the ggplot2 website   #
#  or by typing geom_ into the console of RStudio and pressing Tab.     #
#                                                                       #
#  Any layer is added to a graphic by using the + operator.             #

## Adding points to the axes
DavisPlot + geom_point()

#  The aesthetics that are either default or specified in the aes()     #
#  function can be overwritten by providing new values for aesthetic    #
#  options in the geometric object function. Some of the aesthetics     #
#  that users may be interested in changing are the position, the       #
#  color, the fill color, the shape, and the size.                      #

## Modifying aesthetic features of points
DavisPlot + geom_point(shape=21, size=2, color="darkred", fill="blue")

##################### end of section 1 ##################################

########### objects/packages needed ###########
library(ggplot2)
# OR library(tidyverse)
library(car)
library(gcookbook)
DavisPlot <- ggplot(Davis, aes(x=weight, y=repwt))
###############################################


#############################
#  Scatterplots (continued) #
#############################

#  Additionally, the points can be made more transparent for cases      #
#  when several points are plotted on top of each other.                #

## Adjusting transparency of data points
DavisPlot + geom_point(alpha=0.2)

#  Alternatively for the case when several points are obscured          #
#  together, a layer can be created that groups points into rectangles  #
#  and shades each rectangle according to how many points are           #
#  contained in that space. This type of layer is created using the     #
#  function stat_bin2d().                                               #

## Binning the data points
DavisPlot + stat_bin2d()

#  If a scatterplot contains points belonging to different groups,      #
#  different shapes or colors can be used to differentiate the groups.  #
#  Automatically varying shapes or colors for the entire graphic        #
#  should be specified in the aesthetics function, aes().               #

## Setting varying colors for different groups
ggplot(Davis, aes(x=weight, y=repwt, color=sex)) + geom_point() 

## Specifying colors for different groups
ggplot(Davis, aes(x=weight, y=repwt, color=sex)) + geom_point() +
  scale_color_manual(values=c("M"="blue","F"="red"))

## Setting varying colors and shapes for different groups
ggplot(Davis, aes(x=weight, y=repwt, color=sex, shape=sex)) + geom_point()

#  Differing colors can be used to designate the scale of a continuous  #
#  variable as well.                                                    #

## Setting varing colors for levels of a continuous variable
ggplot(Davis, aes(x=weight, y=repwt, color=repht)) + geom_point()

#  The value of another continuous variable can be represented by the   #
#  size of the point.                                                   #

## Setting size of point for value of a continuous variable
ggplot(Davis, aes(x=weight, y=repwt, size=repht)) + geom_point()

#  Differing groups can also be plotted in separate grids.              #

## Separating groups into plots separated vertically
DavisPlot + geom_point() + facet_grid(sex~.)

## Separating groups into plots separated horizontally
DavisPlot + geom_point() + facet_grid(.~sex)

#  For data sets with more than one grouping variable, the plots can    #
#  be split by two of the grouping variables to create a scatterplot    #
#  matrix.                                                              #

## Look at the first five rows of the mpg data set
mpg[1:5,]

## Create mpg plot of highway mpg vs. engine displacement and add points
mpgPlot <- ggplot(mpg, aes(x=displ, y=hwy)) + geom_point()
mpgPlot

## Separate plots based on type of drive (front, rear, all)
mpgPlot + facet_grid(.~drv)

## Separate plots based on number of cylinders 
mpgPlot + facet_grid(cyl~.)

## Separate plots based on both type of drive and # of cylinders
mpgPlot + facet_grid(cyl~drv)

#  By default all of the axes will have the same range. Users can allow #
#  the horizontal axis, vertical axis, or both to vary.                 #

## Varying vertical axes
mpgPlot + facet_grid(cyl~drv, scales="free_y")

## Varying horizontal axes
mpgPlot + facet_grid(cyl~drv, scales="free_x")

## Varying vertical and horizontal axes
mpgPlot + facet_grid(cyl~drv, scales="free")

#  For grouping variables with too many levels to make side-by-side     #
#  unfeasible, a facet wrap can be used.                                #

## Using facet wrap to create subplots based on vehicle class
mpgPlot + facet_wrap(~class)
mpgPlot + facet_wrap(~class, nrow=2)

#######################################
#  Scatterplots with regression line  #
#######################################

#  A smoothing line can be added to any scatterplot using the           #
#  geom_smooth() function. The default smoothing line will attempt to   #
#  smooth out the data into a curve that best fits the data.            #

## Adding default smoothing line
DavisPlot + geom_point() + geom_smooth()

#  Options can be specified in the geom_smooth() function for the       #
#  smoothing line to use a particular method, such as linear regression.#

## Adding the linear regression line
DavisPlot + geom_point() + geom_smooth(method=lm)

#  The default color of the smoothing line is blue and can be changed   #
#  using the color option.                                             #

## Adding a black linear regression line
DavisPlot + geom_point() + geom_smooth(method=lm, color="black")

#  The  geom_smooth() function default is to include the confidence     #
#  interval bands in a shaded region around the regression line. These  #
#  shaded bands are gray by default, but can be changed using the fill  #
#  option. 

## Changing color of confidence bands
DavisPlot + geom_point() + geom_smooth(method=lm, fill="blue")

#  The confidence bands can be made less prevalent by changing the      #
#  transparency of the shading. A transparency setting of zero is fully #
#  transparent and a transparent setting of one is fully opaque.        #

## Lessening the prevalence of the confidence bands
DavisPlot + geom_point() + geom_smooth(method=lm)
DavisPlot + geom_point() + geom_smooth(method=lm, alpha=0.2)

#  The shaded bands can be removed using the standard error option, se. #

## Adding the linear regression line without the confidence bands
DavisPlot + geom_point() + geom_smooth(method=lm, se=F)

#  If the universal settings of a graphic have defined different        #
#  colors for different groups, separate regression lines and           #
#  confidence bands will be added for each group.                       #

## Adding regression lines for groups
ggplot(Davis, aes(x=weight, y=repwt, color=sex)) + geom_point() +
  geom_smooth(method=lm) 

################
#  Line plots  #
################

#  When data consist of one variable that represent values in a         #
#  specified order, a line plot can be used to show the trend of the    #
#  data. One common example of this type of plot is a time series plot. #

## Look at US population data (in the car package)
USPop[1:5,]

## Create line plot
ggplot(USPop, aes(x=year, y=population)) + geom_line()

#  The options within the geom_line() function can be used to change    #
#  the line type, color, and size.                                      #

## Modify aesthetic features of line
ggplot(USPop, aes(x=year, y=population)) + 
  geom_line(linetype="dashed", size=1, color="blue")
  
#  To also show the points on a line plot, a layer can be added with    #
#  the data points.                                                     #

## Adding data points to line plot
ggplot(USPop, aes(x=year, y=population)) + geom_line() + geom_point()

#  There may be situations when it is useful to plot several line       #
#  plots that distinguish separate groups together. A muliple line      #
#  plot can be created by specifying the grouping variable to vary      #
#  over the line type and/or line color.                                #

## Look at US population data separated by age group (in gcookbook package)
uspopage[1:16,]

## Creating a multiple line plot
ggplot(uspopage, aes(x=Year, y=Thousands, linetype=AgeGroup)) + geom_line()
ggplot(uspopage, aes(x=Year, y=Thousands, color=AgeGroup)) + geom_line() 

##################### end of section 2 ##################################

########### objects/packages needed ###########
library(ggplot2)
# OR library(tidyverse)
library(gcookbook)
library(MASS)
###############################################


################
#  Bar graphs  #
################

#  When conducting an experiment and measuring a response over various  #
#  treatment groups, bar graphs are a useful way to graphically         #
#  summarize the data.                                                  #
#                                                                       #
#  The geom_bar() function will add a layer of bars to the graphic. An  #
#  input that is required for this function is the stat option. This    #
#  input indicates what statistical transformation to use on the data   #
#  for this layer. By default the geom_bar() function will group and    #
#  count the number of responses or use a variable that has already     #
#  been created in the data set if identity is specified for the stat   #
#  option.                                                              #

## Look at pg_mean data set (in gcookbook package)
pg_mean

## Create bar graph to view the means of the treatment groups
bar1 <- ggplot(pg_mean, aes(x=group, y=weight))
bar1 + geom_bar(stat="identity")

#  To plot a bar graph that represents a statistical measure other      #
#  than the count, the stat_summary() function can be used. This        #
#  function takes at least two inputs - the function to apply to the    #
#  data and the geometric object to create in the layer. The specified  #
#  function can be applied to just the y-variable or to the entire      #
#  data set by using the options fun or fun.data.                     #

## Look at the PlantGrowth data set
PlantGrowth[1:5,]

## Create bar graph to view the means of the treatment groups
bar2 <- ggplot(PlantGrowth, aes(x=group, y=weight)) 
bar2 + stat_summary(fun=mean, geom="bar")

#  Regardless of the function used to create the bar layer, aesthetic   #
#  features (color, border, separation, etc.) can be changed within     #
#  the layer function.                                                  #

## Modifying aesthetics of the bar graph
bar1 + geom_bar(stat="identity", fill="orange", color="blue")
bar2 + stat_summary(fun=mean, geom="bar", fill="orange", color="blue")

## Modifying the spacing of the bar graph
bar1 + geom_bar(stat="identity")
bar1 + geom_bar(stat="identity", width=0.5)
bar1 + geom_bar(stat="identity", width=1)

#  If the height of the bars represents the means of various groups,    #
#  error bars can be added to the plot to either represent confidence   #
#  limits or a single standard error of the mean. These error bars are  #
#  added as a new layer to the graphic.                                 #

## Adding error bars to the bar graph (CI)
bar2 + stat_summary(fun=mean, geom="bar", fill="white", color="black") +
  stat_summary(fun.data=mean_cl_normal, geom="errorbar", width=0.2)

## Adding error bars to the bar graph (one standard error)
bar2 + stat_summary(fun=mean, geom="bar", fill="white", color="black") +
  stat_summary(fun.data=mean_se, geom="errorbar", width=0.2)

#  In the case of experiments with more than one variable that defines  #
#  each treatment group or in the case where there are more than one    #
#  groups of interest, it is useful to separate the bars of the plot    #
#  to distinguish the groups.                                           #

## Look at cabbages data set (in MASS package)
cabbages[1:5,]

## Create bar graph for average weight, separated by cultivation
bar3 <- ggplot(cabbages, aes(x=Date, y=HeadWt, fill=Cult)) 
bar3 + stat_summary(fun=mean, geom="bar")

#  Even if groups are specified by different fill color in the base     #
#  layer, bars will be plotted on top of each other unless the user     #
#  specifies otherwise. The dodge option for the position input         #
#  indicates that bars should not overlap.                              #

## Create bar graph for average weight, separated by cultivation
bar3 + stat_summary(fun=mean, geom="bar", position="dodge")

#  By default, bars within groups will never have space between them,   #
#  even if the width is adjusted.                                       #

## Adjusting width
bar3 + stat_summary(fun=mean, geom="bar", position="dodge", width=0.5)

#  In order to add space between the bars within a group, the position  #
#  needs to be adjusted. When the dodge option is specified, the        #
#  function is using position_dodge(0.5). Changing the value in the     #
#  position_dodge() function will adjust the separation between bars    #
#  within groups.                                                       #

## Adding space between bars within groups
bar3 + stat_summary(fun=mean, geom="bar", position=position_dodge(0.7), 
                    width=0.5)

#  In some plots, it is useful to add the value of the height of each   #
#  bar onto the plot. If these values are part of the initial data set, #
#  a layer is added using the geom_text() function. If these values     #
#  were calculated using the stat_summary() function, a new layer       #
#  using a second stat_summary() function is used.                      #

## Adding bar height values
bar3 + stat_summary(fun=mean, geom="bar", position="dodge") +
  stat_summary(fun=mean, geom="text", aes(label=..y..), vjust=1.5, 
               position=position_dodge(0.9), color="white")

##############
#  Boxplots  #
##############

#  Boxplots give users the ability to quickly compare population        #
#  distributions using the information contained in the five-number     #
#  summary.                                                             #

## Look at birthwt data (in MASS package)
birthwt[1:5,]

## Label race values in data
bwdata <- birthwt
bwdata$race <- factor(bwdata$race, labels=c("white","black","other"))

## Create boxplots for birth weights separated by mother's race
bxplot <- ggplot(bwdata, aes(x=race, y=bwt)) 
bxplot + geom_boxplot() 

#  The spaces between multiple boxplots can be modified with the        #
#  width option.                                                        #

## Modify the space between the boxplots
bxplot + geom_boxplot(width=0.5)

#  Outliers are marked as points on each boxplot. If there are many     #
#  outliers, the aesthetics of the outliers can be modified to unmask   #
#  any overlapped points.                                               #

## Modifing outlier aesthetics
bxplot + geom_boxplot(outlier.size=1.5, outlier.shape=21)

#  To emphasize the location of the median of each population, notches  #
#  can be added to the boxplots.                                        #

## Adding notches to boxplots
bxplot + geom_boxplot(notch=TRUE)

#  Markers for the mean of each population can be added to the boxplot  #
#  using the stat_summary() function.                                   #

## Adding markers for the means
bxplot + geom_boxplot() + stat_summary(fun="mean", geom="point")
bxplot + geom_boxplot() + 
  stat_summary(fun="mean", geom="point", shape=21, size=3)

################
#  Histograms  #
################

#  Histograms allow us to see the distribution of a sample in more      #
#  detail by plotting the frequencies over several bins.                #

## Look at the faithful data
faithful[1:5,]

## Create histogram of waiting times
hist1 <- ggplot(faithful, aes(x=waiting))
hist1 + geom_histogram()

#  The width of bins can be specified with the binwidth option or the   #
#  number of bins can be specified with the bins option. The bar        #
#  aesthetics can be modified using the fill and color options.         #

## Change number of bins in a histogram
hist1 + geom_histogram(binwidth=5, fill="white", color="black")
hist1 + geom_histogram(bins=9, fill="white", color="black")

#  For users who would like to compare histograms for multiple groups,  #
#  the function facet_grid() can be used to split the frame and         #
#  display multiple histograms.                                         #

## Look at the birthwt data (in MASS package)
birthwt[1:5,]

## Change labels for smoking and nonsmoking mothers
bwdata <- birthwt
bwdata$smoke <- factor(bwdata$smoke, labels=c("Nonsmoking","Smoking"))

## Create histograms for birth weights separated by mothers' smoking habits
hist2 <- ggplot(bwdata, aes(x=bwt))
hist2 + geom_histogram(binwidth=250, fill="white", color="black") +
  facet_grid(smoke~.)
hist2 + geom_histogram(binwidth=250, fill="white", color="black") +
  facet_grid(.~smoke)

#  Another option for comparing multiple histograms is to overlay them  #
#  and make them semitransparent.                                       #

## Overlapping histograms
ggplot(bwdata, aes(x=bwt, fill=smoke)) + 
  geom_histogram(binwidth=250, position="identity", alpha=0.4)

##################### end of section 3 ##################################

########### objects/packages needed ###########
library(ggplot2)
# OR library(tidyverse)
library(car)
###############################################

#########################
#  Distribution curves  #
#########################

#  There are times when it may be useful to plot the density curve of   #
#  a distribution. These can be created as a layer using the            #
#  stat_function() function and specifying the desired distribution.    #
#  If the distribution function requires additional parameters, they    #
#  are specified in the args option.                                    #

## Plotting a normal distribution curve
Xdata1 <- data.frame(X=c(-4,4))
dist1 <- ggplot(Xdata1, aes(x=X)) 
dist1 + stat_function(fun=dnorm) 
  
## Plotting a normal distribution and t-distribution curve
dist1 + stat_function(fun=dnorm) + 
  stat_function(fun=dt, args=list(df=3), linetype="dashed")

## Plotting a chi-squared curve
Xdata2 <- data.frame(X=c(0,20))
dist2 <- ggplot(Xdata2, aes(x=X))
dist2 + stat_function(fun=dchisq, args=list(df=4))

#  An area under a curve can be shaded using the geom_area() function.  #
#  Within this function, the density of the distribution must be        #
#  specified along with the x-values to be shaded.                      #

## Shading the area above 1.5 in the normal distribution
dist1  + stat_function(fun=dnorm) + 
  geom_area(stat="function", fun=dnorm, xlim=c(1.5,4))

## Shading the area above and below +/- 1.5 in the normal distribution
dist1  + stat_function(fun=dnorm) + 
  geom_area(stat="function", fun=dnorm, xlim=c(1.5,4)) +
  geom_area(stat="function", fun=dnorm, xlim=c(-4,-1.5))

#  The cumulative probability function of a distribution can be shown   #
#  in a graphic by specifying the distribution function beginning       #
#  with p instead of d.                                                 #

## Plotting the cumulative probability function of the normal distribution
dist1  + stat_function(fun=pnorm)

##############
#  QQ plots  #
##############

#  A common way to verify that data follows a normal distribution is    #
#  by creating a QQ plot or normal probability plot. A QQ plot takes    #
#  the sample data ordered from smallest to largest and compares each   #
#  value with what it would be if the data had been drawn from a        #
#  normal distribution. If the sample data is normally distributed,     #
#  the points will follow the straight reference line in the QQ plot.   #

## Create a QQ plot for the waiting times
ggplot(faithful, aes(sample = waiting)) + stat_qq() + stat_qq_line()

######################################
#  Modifying the graphic aesthetics  #
######################################

#  The ggplot2 package has two preset themes for its graphics - grey    #
#  and black and white. The grey theme is the default. The theme can    #
#  be changed for specific plots by adding a layer with the theme name. #

## Default grey theme
DavisScatter <- ggplot(Davis, aes(x=weight, y=repwt)) + geom_point()
DavisScatter

## Changing the theme
DavisScatter + theme_bw()

#  If you prefer the black and white theme for all of your graphics,    #
#  you can use the theme_set() function and specify your chosen theme.  #
#  This function will apply only to the current R session and will      #
#  reset every time R is restarted.                                     #

DavisScatter
theme_set(theme_bw())
DavisScatter
theme_set(theme_grey())
DavisScatter

#  One aesthetic option is to suppress the gridlines. Users can         #
#  suppress either the horizontal lines, vertical lines, or both.       #

DavisScatter + theme(panel.grid.major=element_blank(), 
                     panel.grid.minor=element_blank())
DavisScatter + theme(panel.grid.major.y=element_blank(), 
                     panel.grid.minor.y=element_blank())
DavisScatter + theme(panel.grid.major.x=element_blank(), 
                     panel.grid.minor.x=element_blank())

#  For graphics that will be used in a report or presentation, it is a  #
#  best practice to have a plot title and axis labels that are easily   #
#  understood. The function labs() can be used to add a title and/or    #
#  to change the axis labels.                                           #

DavisScatter + labs(title="Weights of individuals who regularly exercise")
DavisScatter + labs(title="Weights of individuals who regularly exercise",
                    x="Measured weight", y="Reported weight")

#  The aesthetics of the graphic labels can be changed using the        #
#  theme() and element_text() functions.                                #

DavisScatter + labs(title="Weights of individuals who regularly exercise",
                    x="Measured weight", y="Reported weight") +
  theme(plot.title=element_text(face="bold", size=20), 
        axis.title.y=element_text(size=14), 
        axis.title.x=element_text(size=14))

DavisScatter + labs(title="Weights of individuals who \n regularly exercise",
                    x="Measured weight", y="Reported weight") +
  theme(plot.title=element_text(face="bold", size=20))

DavisScatter + labs(title="Weights of individuals who \nregularly exercise",
                    x="Measured weight", y="Reported weight") +
  theme(plot.title=element_text(face="bold", size=20))

#  The axis values themselves can be modified by using axis.text.y=     #
#  and axis.text.x= in the theme() function.                            #
#                                                                       #
#  The range of the axes can be changed using the functions xlim(),     #
#  ylim(), or expand_limits().                                          #

DavisScatter + labs(title="Weights of individuals who regularly exercise",
                    x="Measured weight", y="Reported weight") +
  xlim(0,170) + ylim(0,130)
  
DavisScatter + labs(title="Weights of individuals who regularly exercise",
                    x="Measured weight", y="Reported weight") +
  expand_limits(x=0, y=0)

#  When groups are represented separatedly in a graphic, changes can    #
#  be made to the legend. These changes can be differences in           #
#  aesthetics or a difference in position.                              #

DavisScatter2 <- ggplot(Davis, aes(x=weight, y=repwt, color=sex)) + 
  geom_point()

DavisScatter2 + labs(title="Weights of individuals who regularly exercise",
                     x="Measured weight", y="Reported weight") +
  labs(color="Biological sex")

DavisScatter2 + labs(title="Weights of individuals who regularly exercise",
                     x="Measured weight", y="Reported weight") +
  labs(color="Biological sex") +
  scale_color_discrete(labels=c("Female","Male")) 

DavisScatter2 + labs(title="Weights of individuals who regularly exercise",
                     x="Measured weight", y="Reported weight") +
  labs(color="Biological sex") + 
  scale_color_discrete(limits=c("M","F"))

DavisScatter2 + labs(title="Weights of individuals who regularly exercise",
                     x="Measured weight", y="Reported weight") +
  theme(legend.position="top")

#  The legend can also be moved inside the plot by using the coordinate #
#  system. The bottom left begins at 0,0 and the top right is 1,1.      #

DavisScatter2 + labs(title="Weights of individuals who regularly exercise",
                     x="Measured weight", y="Reported weight") +
  theme(legend.position=c(1,1), legend.justification=c(1,1))

#  If groups are represented in separate plots, the aesthetics of the   #
#  facet labels can be modified in the theme() function.                #

DavisScatter3 <- ggplot(Davis, aes(x=weight, y=repwt)) + geom_point() +
  facet_grid(.~sex)
DavisScatter3 + theme(strip.background=element_rect(fill="darkgreen"),
                      strip.text.x=element_text(size=14, color="white"))

##################### end of section 4 ##################################