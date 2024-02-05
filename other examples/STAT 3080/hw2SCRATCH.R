#Homework2

commutes<-matrix(c(25,36,21,34,25,24,27,36,33,32), nrow=5, ncol=2, byrow=FALSE)
colnames(commutes)<-c("Week1","Week2")
rownames(commutes)<-c("Monday","Tuesday","Wednesday","Thursday","Friday")

commutes$isWeek2Faster <- ifelse(commutes$col1 > commutes$col2, 'NO',
                     ifelse(commutes$col1 < commutes$col2, 'YEs', 'SAME'))

commutesMean <- rbind(commutes, c(mean[1,])) 

