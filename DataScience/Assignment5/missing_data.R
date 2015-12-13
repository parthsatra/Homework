# Regression for missing data
mt1 = c(74, 70 , 66 , 55 , 52 , 47 , 33)
mt2 = c(66 , 58 , 74 , 47 , 61 , 38 , 41)
reg_model = lm(formula = mt2 ~ mt1)
print(summary(reg_model))
