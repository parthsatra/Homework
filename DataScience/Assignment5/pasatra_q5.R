rm(list = ls())
library(ADGofTest)
library(cluster)

# Read data
data <- read.csv("hw5-3d-data.csv", header = TRUE)
alpha = 0.005
num_centers = 1;
centers = data[0, ]
clusters <- kmeans(data, 1)

# Run kmeans for the desired number of clusters
while(TRUE) {
  if(num_centers != 1) {
    clusters <- kmeans(data, centers = centers)
  }
  next_centers = data[0, ]
  # Set of datapoints assigned to center cj 
  for(i in 1:nrow(clusters$centers)) {
    data_set <- data[clusters$cluster == i,]  
    
    # Use a statistical test to detect if each data set follows a Gaussian distribution
    # Performing PCA to get new(better) centers
    p_comp <- prcomp(data_set)
    lambda <- p_comp$sdev[1]
    p_vector <- p_comp$rotation[,1]
    p_vector <- p_vector * sqrt(2 * lambda / pi)
    new_centers = rbind(clusters$centers[i,] - p_vector, clusters$centers[i,] + p_vector)
    
    # Run kmeans to get the new centers for the dataset
    new_clusters <- kmeans(data_set, new_centers)
    
    # Calculate direction between the two centers.
    direction <- new_clusters$centers[1, ] - new_clusters$centers[2, ]
    distance <- norm(as.matrix(t(direction)), "f")
    
    # Project the data onto the new centers
    projection <- (as.matrix(data_set) %*% direction) / (distance ^ 2)
    projection <- scale(projection)
    
    # Perform AD-Test
    ad <- ad.test(projection, pnorm)
    if(ad$p.value <= alpha) {
      next_centers <- rbind(next_centers, new_clusters$centers)
    } else {
      next_centers <- rbind(next_centers, clusters$centers[i,])
    } 
  }
  centers <- next_centers
  if(num_centers == nrow(centers)) {
    break
  } else {
    num_centers = nrow(centers)
  }
}

final_cluster <- kmeans(data, centers)
clusplot(data, final_cluster$cluster, lines = 3, cex = 0.7, color = TRUE, 
         main = "G-Means", shade = TRUE, xlab = "Principal Component 1", 
         ylab = "Principal Component 2")
