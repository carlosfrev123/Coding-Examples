---
title:"Homework 2"
author:"Carlos F Revilla"
fontsize:12pt
geometry:margin=1in
urlcolor:black
output:pdf_document
---



##Problem 1
### a)

```r
commutes<-matrix(c(25,24,36,27,21,36,34,33,25,32),nrow=5,ncol=2)
row.names(commutes)<-c("Monday","Tuesday","Wednesday","Thursday","Friday")
print(commutes)
```

```
##           [,1] [,2]
## Monday      25   36
## Tuesday     24   34
## Wednesday   36   33
## Thursday    27   25
## Friday      21   32
```
### b)

```r
colnames(commutes)<-c("Week1","Week2")
print(commutes)
```

```
##           Week1 Week2
## Monday       25    36
## Tuesday      24    34
## Wednesday    36    33
## Thursday     27    25
## Friday       21    32
```
### c)

```r
comparison<-commutes[,"Week1"]<commutes[,"Week2"]
print(comparison)
```

```
##    Monday   Tuesday Wednesday  Thursday    Friday 
##      TRUE      TRUE     FALSE     FALSE      TRUE
```
### d)

```r
mean_commutes<-rowMeans(commutes)
print(mean_commutes)
```

```
##    Monday   Tuesday Wednesday  Thursday    Friday 
##      30.5      29.0      34.5      26.0      26.5
```
### e)

```r
diff<-commutes-30

print(diff)
```

```
##           Week1 Week2
## Monday       -5     6
## Tuesday      -6     4
## Wednesday     6     3
## Thursday     -3    -5
## Friday       -9     2
```
### f)

```r
mean_diff<-colMeans(diff)
print(mean_diff)
```

```
## Week1 Week2 
##  -3.4   2.0
```
### g)

```r
max_delay<-apply(diff,2,max)
print(max_delay)
```

```
## Week1 Week2 
##     6     6
```
### h)

```r
week2_fast_arrival<-row.names(commutes[diff[,"Week2"]<=-5,])
print(week2_fast_arrival)
```

```
## NULL
```
### i)

```r
days_within_budget<-colSums(diff<=0)
print(days_within_budget)
```

```
## Week1 Week2 
##     4     1
```
### j)

```r
week1_fast_arrival<-row.names(commutes[diff[,"Week1"]<=0,])
print(week1_fast_arrival)
```

```
## [1] "Monday"   "Tuesday"  "Thursday" "Friday"
```
### k)

```r
similar_commutes<-diff[diff[,"Week1"]==diff[,"Week2"],]
print(similar_commutes)
```

```
##      Week1 Week2
```


##Problem 2
### a)

```r
library(car)
data(Davis)

weight.metric <- Davis[, c("weight", "repwt")]
head(weight.metric)
```

```
##   weight repwt
## 1     77    77
## 2     58    51
## 3     53    54
## 4     68    70
## 5     59    59
## 6     76    76
```
### b)

```r
weight.imp<-weight.metric*2.2
names(weight.imp)<-c("rec.weight","rep.weight")

head(weight.imp)
```

```
##   rec.weight rep.weight
## 1      169.4      169.4
## 2      127.6      112.2
## 3      116.6      118.8
## 4      149.6      154.0
## 5      129.8      129.8
## 6      167.2      167.2
```

### c)

```r
height.metric<-Davis[,c("height","repht")]
head(height.metric)
```

```
##   height repht
## 1    182   180
## 2    161   159
## 3    161   158
## 4    177   175
## 5    157   155
## 6    170   165
```
### d)

```r
height.imp<-round(height.metric/2.54,1)
names(height.imp)<-c("rec.height","rep.height")
head(height.imp)
```

```
##   rec.height rep.height
## 1       71.7       70.9
## 2       63.4       62.6
## 3       63.4       62.2
## 4       69.7       68.9
## 5       61.8       61.0
## 6       66.9       65.0
```
### e)

```r
Davis.imp<-cbind(sex=Davis$sex,weight.imp,height.imp)

head(Davis.imp)
```

```
##   sex rec.weight rep.weight rec.height rep.height
## 1   M      169.4      169.4       71.7       70.9
## 2   F      127.6      112.2       63.4       62.6
## 3   F      116.6      118.8       63.4       62.2
## 4   M      149.6      154.0       69.7       68.9
## 5   F      129.8      129.8       61.8       61.0
## 6   M      167.2      167.2       66.9       65.0
```
### f)

```r
apply(Davis.imp,2,function(x)sum(is.na(x)))
```

```
##        sex rec.weight rep.weight rec.height rep.height 
##          0          0         17          0         17
```
### g)

```r
sum(apply(Davis.imp,1,function(x)any(is.na(x))))
```

```
## [1] 19
```

### h)

```r
Davis.imp[which(apply(Davis.imp,1,function(x)any(is.na(x)))),"sex"]
```

```
##  [1] M F M F F F M F F F F F F F M F F M M
## Levels: F M
```
##Problem 3
### a)

```r
planets<-data.frame(name=c("Mercury","Venus","Earth","Mars","Jupiter","Saturn","Uranus","Neptune"),
distance=c(0.39,0.72,1,1.52,5.2,9.54,19.18,30.06),
type=c("terrestrial","terrestrial","terrestrial","terrestrial","gas","gas","gas","gas"),
diameter=c(0.382,0.949,1,0.532,11.209,9.449,4.007,3.883),
rotation=c(58.64,-243.02,1,1.03,0.41,0.43,-0.72,0.67),
rings=c(FALSE,FALSE,FALSE,FALSE,TRUE,TRUE,TRUE,TRUE),
moons=c(0,0,1,2,67,62,27,14))

#remember to print
print(planets)
```

```
##      name distance        type diameter rotation rings moons
## 1 Mercury     0.39 terrestrial    0.382    58.64 FALSE     0
## 2   Venus     0.72 terrestrial    0.949  -243.02 FALSE     0
## 3   Earth     1.00 terrestrial    1.000     1.00 FALSE     1
## 4    Mars     1.52 terrestrial    0.532     1.03 FALSE     2
## 5 Jupiter     5.20         gas   11.209     0.41  TRUE    67
## 6  Saturn     9.54         gas    9.449     0.43  TRUE    62
## 7  Uranus    19.18         gas    4.007    -0.72  TRUE    27
## 8 Neptune    30.06         gas    3.883     0.67  TRUE    14
```
### b)

```r
small_planets<-subset(planets,diameter<5)
print(small_planets)
```

```
##      name distance        type diameter rotation rings moons
## 1 Mercury     0.39 terrestrial    0.382    58.64 FALSE     0
## 2   Venus     0.72 terrestrial    0.949  -243.02 FALSE     0
## 3   Earth     1.00 terrestrial    1.000     1.00 FALSE     1
## 4    Mars     1.52 terrestrial    0.532     1.03 FALSE     2
## 7  Uranus    19.18         gas    4.007    -0.72  TRUE    27
## 8 Neptune    30.06         gas    3.883     0.67  TRUE    14
```
### c)

```r
same_rotation_planets<-subset(planets,rotation==1)
print(same_rotation_planets)
```

```
##    name distance        type diameter rotation rings moons
## 3 Earth        1 terrestrial        1        1 FALSE     1
```
### d)

```r
large_diameter_planets<-subset(planets,diameter>1,select=c("name","moons","type"))
print(large_diameter_planets)
```

```
##      name moons type
## 5 Jupiter    67  gas
## 6  Saturn    62  gas
## 7  Uranus    27  gas
## 8 Neptune    14  gas
```
### e)

```r
ringed_planets<-subset(planets,moons>1,select=c("rings","type"))
print(ringed_planets)
```

```
##   rings        type
## 4 FALSE terrestrial
## 5  TRUE         gas
## 6  TRUE         gas
## 7  TRUE         gas
## 8  TRUE         gas
```

