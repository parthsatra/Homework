rm(list = ls())
library(pixmap)
library(ppls)

# Extracts grey pixels from each face
get_pixels <- function(x_i) {
  return(c(x_i@grey))
}

# Read all the face files 
face_files = list.files(".")
faces = lapply(face_files, read.pnm)
faces = as.array(faces)

# Extract all the grey pixels from the faces
face_mat = lapply(faces, get_pixels)
face_mat = as.data.frame(face_mat)

# Calculate mean and normalize the faces
mean_mat = rowMeans(face_mat)
face_mat = sweep(face_mat, 1, mean_mat, "-")

# Compute covariance matrix and eigen vectors
cov_mat = cov(as.matrix(face_mat))
mat_eigen = eigen(cov_mat)
face_vectors = as.matrix(face_mat) %*% mat_eigen$vectors

# Print the top 10 images
op <- par(mfrow = c(3,4),
          oma = c(1,1,1,1) + 0.1,
          mar = c(0,0,1,1) + 0.1)
for(i in 1:10) {
  top_face = face_vectors[,i]
  top_face = normalize.vector(top_face)
  dim(top_face) = c(231,195)
  plot(pixmapGrey(top_face), main = i)
}
