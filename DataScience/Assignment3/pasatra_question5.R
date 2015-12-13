#Question 5
rm(list =ls())
# Applying log transform 
trans_data = read.table("hw3-q4c.txt", header = TRUE, sep = "\t")
trans_data$X3 = log(trans_data$X3)
trans_model = glm(trans_data$Y ~ trans_data$X1 + trans_data$X2 + trans_data$X3, 
                  family = "binomial")
print(summary(trans_model))
