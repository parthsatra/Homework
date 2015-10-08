# clean the environment
rm(list = ls())

# include library 
library(MASS)

# Question 10.1
# Generating samples with normal distribution with mean = 0 and standard deviation = 1.
samples = rnorm(100)
# mean
mean(samples)
# Standard Deviation
sd(samples)
# Variance
var(samples)
# Median
median(samples)
# Standard Quantiles
quantile(samples)

# Question 10.2
b = c(-3.5,-2.5,-1.5,-0.5,0.5,1.5,2.5,3.5)
# Generating Histogram 
histogram = hist(samples, breaks = b)
plot(histogram, main="Histogram", xlab = "Values", ylab = "Frequency")

# Question 10.3
qqnorm(samples)

# Question 10.4
# (a) Generate weight in lbs (20lbs to 400 lbs) and height in cm (2ft to 7ft) 
w = runif(100, 20, 400)
h = runif(100, 60, 220)
weight_height = rbind(w, h)
# Generate Summary
summary(t(weight_height))

# (b) Generate bar plots
barplot(weight_height, beside = TRUE, 
        col = c("lightblue","mistyrose"), 
        legend=c("Weight", "Height"), 
        ylim=c(20, 400),
        ylab = "Weight/Height",
        xlab = "Samples",
        main = "Bar Plot",)

# (c) Generate box plots
boxplot(t(weight_height), col = c("lightblue", "mistyrose"),
        legend=c("Weight", "Height"),
        ylim = c(20, 400),
        ylab = "Weight/Height",
        xlab = "Samples",
        main = "Box plot")

# (d) Generate Scatter Plots
plot(weight_height[1,], weight_height[2,], bg = c("lightblue"),
     pch = 21,
     ylim = c(50, 225),
     xlim = c(10, 410),
     ylab = "Height",
     xlab = "Weight",
     main = "Scatter plot")

# Question 10.5  
# Plotting the normal distribution for weight
normal_weight = dnorm(weight_height[1,], m = mean(weight_height[1,]), 
                      sd = sd(weight_height[1,]))
plot(weight_height[1,], normal_weight, bg = c("lightblue"),
     pch = 21,
     xlim = c(10,410),
     xlab = "Sample Weight",
     ylab = "Normal Weight",
     main = "Normal Distribution for Weight")

# Plotting the normal distribution for height
normal_height = dnorm(weight_height[2,], m = mean(weight_height[2,]), 
                      sd = sd(weight_height[2,]))
plot(weight_height[2,], normal_height, bg = c("mistyrose"),
     pch = 21,
     xlim = c(50,225),
     xlab = "Sample Weight",
     ylab = "Normal Weight",
     main = "Normal Distribution for Weight")

# Question 10.6
# Plot bivariate normal distribution
mu = c(mean(weight_height[1,]), mean(weight_height[2,]))
sigma = matrix(cov(t(weight_height)),2,2)
bivariate_distribution = mvrnorm(100, mu, sigma)
bivariate_distribution.kde = kde2d(bivariate_distribution[,1], bivariate_distribution[,2], 100)
persp(bivariate_distribution.kde, 
      phi = 45, 
      theta = 45,
      col = "lightblue",
      xlab = "Weight",
      ylab = "height",
      zlab = "Frequency", 
      main = "Bivariate Distribution")
contour(bivariate_distribution.kde, main = "Contour")
