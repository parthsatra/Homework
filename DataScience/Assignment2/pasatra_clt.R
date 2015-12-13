#Clear all the environment variables
rm(list=ls())

#Function that reads integer as input
readinteger <- function(prompt_text) {
  input_text = readline(prompt = prompt_text)
  return(as.integer(input_text))
}

# Function that generates samples depending on the distribution type. 
getsamples <- function(type, sample_size) {
  if(type == 1) {
    # Normal distribution
    return(rnorm(sample_size)) 
  } else if(type == 2) {
    # Uniform Distribution
    return(runif(sample_size))
  } else if(type == 3) {
    # Exponential Distribution
    return(rexp(sample_size))
  } else if(type == 4) {
    # Poisson Distribution
    return(rpois(sample_size, lambda = 2))
  } else if(type == 5) {
    # Binomial Distribution
    return(rbinom(sample_size, size = 10, prob = 0.5))
  } else if(type == 6) {
    #Chi-Sqaure Distribution
    return(rchisq(sample_size, df = sample_size -1))
  }
}

# Taking input for distribution
text_distribution = "Enter the type of distribution \n1 - Normal \n2 - Uniform \n3 - Exponential \n4 - Poisson \n5 - Binomial \n6 - Chi Square"
distribution = readinteger(text_distribution)

#Taking input for number of samples 
text_no_sample = "Enter number of samples \n"
no_sample = readinteger(text_no_sample)

#Taking input for sample size
text_sample_size = "Enter sample size \n"
sample_size = readinteger(text_sample_size)

# Generates the required number of samples and calculates mean of all the samples.
sample_statistic = 0
for(i in 1 : no_sample) {
  temp = getsamples(distribution, sample_size)
  sample_statistic[i] = mean(temp);
}

#Plots the sampling distribution and output
hist(sample_statistic, main = "Sampling Distribution",col = "lightgreen",
     xlab = "Sample Mean")
cat("Output")
cat("\nMean = ", mean(sample_statistic))
cat("\nSD = ", sd(sample_statistic))
readline(prompt = "Press [enter] to continue...")
qqnorm(sample_statistic, col = "blue")
