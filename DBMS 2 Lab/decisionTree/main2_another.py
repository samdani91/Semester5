import numpy as np
import pandas as pd

col_names = ['sepal_length', 'sepal_width', 'petal_length', 'petal_width', 'type']
data = pd.read_csv("F:\DBMS2\codes\DecisionTrees\iris\iris.csv", skiprows=1, header=None, names=col_names)

class Node():
    def __init__(self, feature_index=None, threshold=None, left=None, right=None, gini_impurity=None, value=None):
        ''' constructor '''
        self.feature_index = feature_index
        self.threshold = threshold
        self.left = left
        self.right = right
        self.gini_impurity = gini_impurity
        self.value = value

class DecisionTreeClassifier():
    def __init__(self, min_samples_split=2, max_depth=2):
        ''' constructor '''
        self.root = None
        self.min_samples_split = min_samples_split
        self.max_depth = max_depth

    def build_tree(self, dataset, curr_depth=0):
        ''' recursive function to build the tree '''
        X, Y = dataset[:, :-1], dataset[:, -1]
        num_samples, num_features = np.shape(X)

        if num_samples >= self.min_samples_split and curr_depth <= self.max_depth:
            best_split = self.get_best_split(dataset, num_samples, num_features)
            if best_split["gini_impurity"] < float("inf"):
                left_subtree = self.build_tree(best_split["dataset_left"], curr_depth + 1)
                right_subtree = self.build_tree(best_split["dataset_right"], curr_depth + 1)
                return Node(best_split["feature_index"], best_split["threshold"],
                            left_subtree, right_subtree, best_split["gini_impurity"])

        leaf_value = self.calculate_leaf_value(Y)
        return Node(value=leaf_value)

    def get_best_split(self, dataset, num_samples, num_features):
        ''' function to find the best split '''
        best_split = {}
        min_gini_impurity = float("inf")

        for feature_index in range(num_features):
            feature_values = dataset[:, feature_index]
            possible_thresholds = np.unique(feature_values)

            for threshold in possible_thresholds:
                dataset_left, dataset_right = self.split(dataset, feature_index, threshold)
                if len(dataset_left) > 0 and len(dataset_right) > 0:
                    left_y, right_y = dataset_left[:, -1], dataset_right[:, -1]
                    gini_impurity = self.calculate_gini_impurity(dataset[:, -1], left_y, right_y)

                    if gini_impurity < min_gini_impurity:
                        best_split["feature_index"] = feature_index
                        best_split["threshold"] = threshold
                        best_split["dataset_left"] = dataset_left
                        best_split["dataset_right"] = dataset_right
                        best_split["gini_impurity"] = gini_impurity
                        min_gini_impurity = gini_impurity

        return best_split

    def split(self, dataset, feature_index, threshold):
        ''' function to split the data '''
        dataset_left = np.array([row for row in dataset if row[feature_index] <= threshold])
        dataset_right = np.array([row for row in dataset if row[feature_index] > threshold])
        return dataset_left, dataset_right

    def calculate_gini_impurity(self, parent, left_child, right_child):
        ''' function to compute gini impurity '''
        weight_l = len(left_child) / len(parent)
        weight_r = len(right_child) / len(parent)
        gini = (weight_l * self.gini_index(left_child)) + (weight_r * self.gini_index(right_child))
        return gini

    def gini_index(self, y):
        ''' function to compute gini index '''
        class_labels = np.unique(y)
        gini = 1 - sum((len(y[y == cls]) / len(y)) ** 2 for cls in class_labels)
        return gini

    def calculate_leaf_value(self, Y):
        ''' function to compute leaf node '''
        Y = list(Y)
        return max(Y, key=Y.count)

    def print_tree(self, tree=None, indent=" ", class_names=None):
        ''' Function to print the tree with Gini impurity and named output for classes '''
        if not tree:
            tree = self.root

        if tree.value is not None:
            class_name = class_names[int(tree.value)] if class_names else tree.value
            print(f"Class: {class_name}")
        else:
            print(f"X_{tree.feature_index} <= {tree.threshold:.2f} ? <Gini Impurity: {tree.gini_impurity:.3f}>")
            print(f"{indent}left:", end="")
            self.print_tree(tree.left, indent + indent, class_names)
            print(f"{indent}right:", end="")
            self.print_tree(tree.right, indent + indent, class_names)

    def fit(self, X, Y):
        ''' function to train the tree '''
        dataset = np.concatenate((X, Y), axis=1)
        self.root = self.build_tree(dataset)

    def predict(self, X):
        ''' function to predict new dataset '''
        return [self.make_prediction(x, self.root) for x in X]

    def make_prediction(self, x, tree):
        ''' function to predict a single data point '''
        if tree.value is not None:
            return tree.value
        feature_val = x[tree.feature_index]
        return self.make_prediction(x, tree.left if feature_val <= tree.threshold else tree.right)

# Map the class labels to integers for processing
data['type'] = data['type'].map({'Iris-setosa': 0, 'Iris-versicolor': 1, 'Iris-virginica': 2})

X = data.iloc[:, :-1].values
y = data.iloc[:, -1].values
y = y.reshape(-1, 1)

def main():
    classifier = DecisionTreeClassifier(min_samples_split=2, max_depth=3)
    classifier.fit(X, y)

    class_names = {0: "Iris-setosa", 1: "Iris-versicolor", 2: "Iris-virginica"}
    print("\nDecision Tree:")
    classifier.print_tree(class_names=class_names)

if __name__ == "__main__":
    main()
