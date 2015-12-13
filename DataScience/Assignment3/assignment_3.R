#Question 4(a)
# Clean the environment
rm(list = ls())
# Load data
adv_data = read.csv("Advertising.csv")
adv_data = adv_data[,-1]

#Simple linear Regression for TV covariate
plot(adv_data$TV, adv_data$Sales, xlab = "Sales", ylab = "TV - Advertising",
     main = "Scatter Plot of TV - Sales", col = "firebrick", 
     type = "p", pch = 16)
model_TV = lm(adv_data$Sales ~ adv_data$TV)
abline(model_TV, col = "steelblue", lw = 3)
print(model_TV$coefficients)
print(summary(model_TV))

#Simple linear Regression for Radio covariate
plot(adv_data$Radio, adv_data$Sales, xlab = "Sales", ylab = "Radio - Advertising",
     main = "Scatter Plot of Radio - Sales", col = "firebrick", 
     type = "p", pch = 16)
model_Radio = lm(adv_data$Sales ~ adv_data$Radio)
abline(model_Radio, col = "steelblue", lw = 3)
print(model_Radio$coefficients)
print(summary(model_Radio))

#Simple linear Regression for Newspaper covariate
plot(adv_data$Newspaper, adv_data$Sales, xlab = "Sales", ylab = "Newspaper - Advertising",
     main = "Scatter Plot of Radio - Newspaper", col = "firebrick", 
     type = "p", pch = 16)
model_NewsPaper = lm(adv_data$Sales ~ adv_data$Newspaper)
abline(model_NewsPaper, col = "steelblue", lw = 3)
print(model_NewsPaper$coefficients)
print(summary(model_NewsPaper))

#Question 4(b)
# Multiple Linear Regression and the Beta-coefficient
model_multivatiate = lm(adv_data$Sales ~ adv_data$TV + 
                          adv_data$Radio + adv_data$Newspaper)
print(model_multivatiate$coefficients)

#Question 4(c)
rm(list = ls())
# Load the new data
log_data = read.table("hw3-q4c.txt", header = TRUE, sep = "\t")
log_model = glm(log_data$Y ~ log_data$X2 + log_data$X1 + log_data$X3, 
                family = "binomial")
print(summary(log_model))

