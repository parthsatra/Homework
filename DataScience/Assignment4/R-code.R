#R5.a.
#(a)
library(ISLR)
attach(Default)
set.seed(5)
View(Default)
model <- glm(default ~ income + balance, data = Default, family = "binomial")
summary(model)

#(b)
size <- dim(Default)[1]
train <- sample(size, size/2)
glm_model <- glm(default~ income + balance, data=Default, family="binomial", subset=train)
summary(glm_model)
probability <-predict(glm_model, newdata = Default[-train,], type = "response")
predictions <- rep("No", length(probability))
predictions[probability > 0.5] <- "Yes"
mean(predictions != Default[-train, ]$default)

#(c)
size <- dim(Default)[1]
train <- sample(size, size/2)
glm_model <- glm(default~ income + balance, data=Default, family="binomial", subset=train)
summary(glm_model)
probability <-predict(glm_model, newdata = Default[-train,], type = "response")
predictions <- rep("No", length(probability))
predictions[probability > 0.5] <- "Yes"
mean(predictions != Default[-train, ]$default)

size <- dim(Default)[1]
train <- sample(size, size/2)
glm_model <- glm(default~ income + balance, data=Default, family="binomial", subset=train)
summary(glm_model)
probability <-predict(glm_model, newdata = Default[-train,], type = "response")
predictions <- rep("No", length(probability))
predictions[probability > 0.5] <- "Yes"
mean(predictions != Default[-train, ]$default)

size <- dim(Default)[1]
train <- sample(size, size/2)
glm_model <- glm(default~ income + balance, data=Default, family="binomial", subset=train)
summary(glm_model)
probability <-predict(glm_model, newdata = Default[-train,], type = "response")
predictions <- rep("No", length(probability))
predictions[probability > 0.5] <- "Yes"
mean(predictions != Default[-train, ]$default)

#(d)
size <- dim(Default)[1]
train <- sample(size, size/2)
glm_model <- glm(default~ income + balance + student, data=Default, family="binomial", subset=train)
summary(glm_model)
probability <-predict(glm_model, newdata = Default[-train,], type = "response")
predictions <- rep("No", length(probability))
predictions[probability > 0.5] <- "Yes"
mean(predictions != Default[-train, ]$default)

#R5.b.
# reference: http://blog.manfredas.com/eigenfaces-tutorial/
library(pixmap)
library(ppls)
setwd("S:\\Courses\\Fall 2015\\CSC 591 Foundations of Data Science\\Assignment 4\\faces-corrected")
wd <- getwd()
rotate <- function(x) t(apply(x, 2, rev))
size = 231*195
mat <- matrix(, nrow = size, ncol = 0)
files <- Sys.glob("*")
getwd()
length(files)
# loop starts here
add_to_matrix <- function(fileName,mat) {
  x <- read.pnm(file = paste(wd,fileName,sep="\\"))
  y <- getChannels(x)
  #y <- rotate(y)  #???
  mat <- cbind(mat,as.vector(y))
  return(mat)
}
# read every image and transform into a vector. append vectors as columns to 
# create a K^2 * N sized matrix format where K is size of each image and 
# N is number of images
for(i in seq_along(files)){
  mat <- add_to_matrix(files[i], mat)
}
dim(mat)
# average all the images
average_face <- rowSums(mat)/165
# face difference from average
face_diff <- sweep(mat, 1, average_face)  #A
dim(face_diff)
#covariance matrix
cov_face_diff <- cov(face_diff)
eigen_object <- eigen(cov_face_diff)
summary(eigen_object)
values <- eigen_object$values
dim(eigen_object$vectors)                 #vi
actual_vectors <- face_diff %*% eigen_object$vectors
dim(actual_vectors)
op <- par(mfrow = c(2,3),
          oma = c(5,4,0,0) + 0.1,
          mar = c(0,0,1,1) + 0.1)
ranked_values <- cbind(values,as.numeric(factor(values)))
View(ranked_values[ranked_values[,2]<155,])
op<-par(mfrow = c(1,1))
for(i in 1:10){
  print(i)
  trial <-actual_vectors[,i]
  trial <- normalize.vector(trial)
  dim(trial) = c(231,195)
  plot(pixmapGrey(trial), main=i, xaxs = "i", yaxs="i")
}

#B6.a.
#(g)
x <- 1:100000
plot(x,1-(1-1/x)^x)

#(h)
store <- rep(NA, 100000)
for(i in 1:100000){
  store[i] = sum(sample(1:100, rep=TRUE) == 4) > 0
}
mean(store)

#B6.b.
#(a)
set.seed(2)
x <- rnorm(100)
e <- rnorm(100)

#(b)
b0 <- 4
b1 <- 2
b2 <- 5
b3 <- 6
y <- b0 + b1 * x + b2 * x^2 + b3 * x^3 + e

#(c)
library(leaps)
data_object <- data.frame(y=y, x=x)
reg_object <- regsubsets(y ~ x + I(x^2) + I(x^3) + I(x^4) + I(x^5) + I(x^6) + I(x^7) + I(x^8) + I(x^9) + I(x^10), data = data_object, nvmax = 10)
reg_sum <- summary(reg_object)
par(mfrow = c(1,3))
plot(reg_sum$cp,xlab = "Number of variables", ylab = "Cp")
points(which.min(reg_sum$cp), reg_sum$cp[which.min(reg_sum$cp)], col="green",cex = 2, pch = 20)
plot(reg_sum$bic,xlab = "Number of variables", ylab = "BIC")
points(which.min(reg_sum$bic), reg_sum$bic[which.min(reg_sum$bic)], col="green",cex = 2, pch = 20)
plot(reg_sum$adjr2,xlab = "Number of variables", ylab = "Adjusted R^2")
points(which.max(reg_sum$adjr2), reg_sum$adjr2[which.max(reg_sum$adjr2)], col="green", cex = 2, pch = 20)

coef(reg_object,which.max(reg_sum$adjr2))