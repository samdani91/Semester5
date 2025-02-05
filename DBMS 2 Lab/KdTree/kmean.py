import numpy as np
import matplotlib.pyplot as plt
from sklearn import datasets
from sklearn.decomposition import PCA


iris = datasets.load_iris()
X = iris.data  

k = 3  


np.random.seed(42)
centroids = X[np.random.choice(X.shape[0], k, replace=False)] 

def euclidean_distance(p1, p2):
    return np.sqrt(np.sum((p1 - p2) ** 2))

def assign_clusters(X, centroids):
    clusters = [[] for _ in range(k)] 
    
    for i, point in enumerate(X):
        distances = [euclidean_distance(point, centroid) for centroid in centroids] 
        cluster_idx = np.argmin(distances)  
        clusters[cluster_idx].append(i)  

    return clusters

def update_centroids(X, clusters):
    new_centroids = np.array([X[cluster].mean(axis=0) if cluster else centroids[i] for i, cluster in enumerate(clusters)])
    return new_centroids


max_iters = 100
for _ in range(max_iters):
    clusters = assign_clusters(X, centroids)  
    new_centroids = update_centroids(X, clusters)  

    if np.allclose(centroids, new_centroids):  
        break
    centroids = new_centroids


labels = np.zeros(X.shape[0])
for cluster_idx, cluster_points in enumerate(clusters):
    for point_idx in cluster_points:
        labels[point_idx] = cluster_idx


pca = PCA(n_components=2)
X_2D = pca.fit_transform(X)


plt.figure(figsize=(8, 6))
for i in range(k):
    plt.scatter(X_2D[labels == i, 0], X_2D[labels == i, 1], label=f'Cluster {i+1}')
plt.scatter(pca.transform(centroids)[:, 0], pca.transform(centroids)[:, 1], c='black', marker='X', s=200, label='Centroids')
plt.xlabel('Principal Component 1')
plt.ylabel('Principal Component 2')
plt.title('K-Means Clustering on Iris Dataset')
plt.legend()
plt.show()