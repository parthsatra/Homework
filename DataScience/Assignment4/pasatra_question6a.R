# Question B6 part (A)
# Question 7 ploting the graph of the probability versus the bootstrap sample size.
x <- 1:100000
plot(x, 1 - (1 - 1/x)^x, xlab = "Number of bootstrap observations", ylab = "Probability of Selecting jth observation", 
    ylim = c(0.6, 1.0), col = "firebrick", type = "p", pch = 16, 
    main = "Probability distribution for size of bootstrap samples")
axis(side = 1, at = seq(0, 100000, by = 20000))
readline()

# Question 8. Sample code given in the question.
store=rep(NA, 10000)
for(i in 1:10000){ store[i]=sum(sample(1:100, rep = TRUE) == 4) > 0}
mean(store)