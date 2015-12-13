#Question B6 part (B)
# Question 1: Generating values of x and eps using rnorm
# setting seed to get the same random values for rnorm
set.seed(2)
x = rnorm(100)
eps = rnorm(100)

# Question 2: Generating response vector Y
# Coefficient values are taken by choice
b0 = 10
b1 = 3
b2 = -2.25
b3 = 0.05
y = b0 + b1 * x + b2 * x^2 + b3 * x^3 + eps

# Question 3: Determining the best model along with some plots as evidence. 
library(leaps)
sample_data = data.frame(y, x)
model = regsubsets(y ~ x + I(x^2) + I(x^3) + I(x^4) + I(x^5) + I(x^6) + I(x^7) + I(x^8) + I(x^9) + I(x^10), data = sample_data)
model_summary = summary(model)
plot(model_summary$cp, type = "l", col = "firebrick", xlab = "Number of variables", ylab = "c_p")
readline()
plot(model_summary$bic, type = "l", col = "steelblue", xlab = "Number of variables", ylab = "bic")
readline()
plot(model_summary$adjr2, type = "l", xlab = "Number of variables", ylab = "Adjusted R^2")

# Finding the coefficents of the best fitted model.
print(coef(model, which.max(model_summary$adjr2)))  
