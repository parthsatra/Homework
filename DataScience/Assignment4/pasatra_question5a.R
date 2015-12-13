rm(list = ls())
library(ISLR)
attach(Default)
set.seed(1)

# a. Logistic regression model using "income" and "balance".
glm_fit = glm(default ~ income + balance, data = Default, family = "binomial")
print("Logistic Regression Model Summary using income and balance")
print(summary(glm_fit))

# b. Use Validation set approach and estimate the test error of this model.
validate_lrm = function(split_ratio) {
  print(paste0("Model validation for Default data set using split ratio = ", split_ratio))
  data_size = dim(Default)[1]
  train = sample(data_size, data_size * split_ratio)
  glm_fit = glm(default ~ income + balance, data = Default, 
                family = "binomial", subset = train)
  prob = predict(glm_fit, newdata = Default[-train,], type = "response")
  predictions = rep("No", length(prob))
  predictions[prob > 0.5] = "Yes"
  conf_mat = table(predictions, Default[-train,]$default)
  print(conf_mat)
  res_err = (conf_mat[1, 2] + conf_mat[2,1]) / length(predictions)  
  print(res_err)
  
}

# Assuming 50/50 to be the split for validation set approach.
validate_lrm(0.5)

# c. Repeating validations in b with different split ratios. 
#    The ratios taken here are 90/10, 75/25, 60/40.
validate_lrm(0.9)
validate_lrm(0.75)
validate_lrm(0.6)

# d. Logistic Regression model for Default data set using income, balance and student.
#    Considering split ratio as 75/25
print("Model validation for Default data set with student, income and balance using split ratio = 0.75")
data_size = dim(Default)[1]
train = sample(data_size, data_size * 0.5)
glm_fit = glm(default ~ income + balance + student, data = Default, 
              family = "binomial", subset = train)
prob = predict(glm_fit, newdata = Default[-train,], type = "response")
predictions = rep("No", length(prob))
predictions[prob > 0.5] = "Yes"
conf_mat = table(predictions, Default[-train,]$default)
print(conf_mat)
res_err = (conf_mat[1, 2] + conf_mat[2,1]) / length(predictions)  
print(res_err)
