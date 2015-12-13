The basic requirements
1. Install R 3.2.2 - https://www.r-project.org/
2. Install R Studio for the required platform. - https://www.rstudio.com/products/rstudio/download/

After installation of R follow the following steps to run the program 
STEP1: 
Open the file "pasatra_clt.R" in R Studio

STEP2: 
Click on the "Source" icon top right of the window containing the R code. 

STEP3: 
The program will start running and will ask for input on the type of distribution. User needs to enter number between 1 to 6 		   representing the type of distribution as stated in the beginning. With 1 representing normal distribution, 2 for uniform and so on. 

STEP4: 
The program will ask for the net input as the number of samples that need to be generated. Example is 200.

STEP5:
The program requires one more final input which indicated the number of observations in each sample. Also known as the size of the sample. This value should generally be greater than 30. Example 60. 

STEP6: 
The program will generate output as a histogram plot and will print the mean and standard deviation of the sampling distribution. This is always the normal distribution. Press [Enter] to see the next plot which proves that this distribution is normal distribution. 

STEP7:
The program now shows the qqnorm plot of the theoretical normal distribution vs the sampling distribution generated above. Since the line is almost a straight line similar to line x = y, it proves that both distribution are normal and thus proves CLT. 

STEP8:
To rerun the program with another distribution follow the steps 1 through 7. 

Note: The output file contains the sample output for all the distributions with sample size as 60 and number of samples as 200. 
