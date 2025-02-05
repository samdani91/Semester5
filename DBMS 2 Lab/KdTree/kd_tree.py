import math

class TreeNode:
    def __init__(self, value=None, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

class KDTree:
    def __init__(self):
        self.root = None

    def buildTree(self, dataPoints, height=0):
        if not dataPoints:
            return None

        k = len(dataPoints[0])
        axis = height % k

        dataPoints.sort(key=lambda x: x[axis])

        mid = len(dataPoints) // 2

        return TreeNode(
            value=dataPoints[mid],
            left=self.buildTree(dataPoints[:mid], height + 1),
            right=self.buildTree(dataPoints[mid + 1:], height + 1)
        )

    def insert(self, root, point, height=0):
        if root is None:
            return TreeNode(point)

        k = len(point)
        axis = height % k

        if point[axis] < root.value[axis]:
            root.left = self.insert(root.left, point, height + 1)
        else:
            root.right = self.insert(root.right, point, height + 1)

        return root

    def printTree(self, node, level=0):
        if node is not None:
            print(f"Level {level}: {node.value}")
            self.printTree(node.left, level + 1)
            self.printTree(node.right, level + 1)


    def distance(self, point1, point2):
        return math.sqrt(sum((a - b) ** 2 for a, b in zip(point1, point2)))

    def nearestNeighbor(self, root, target, height=0, best=None):
        if root is None:
            return best

        if best is None or self.distance(target, root.value) < self.distance(target, best):
            best = root.value

        k = len(target)
        axis = height % k

        
        if target[axis] < root.value[axis]:
            best = self.nearestNeighbor(root.left, target, height + 1, best)
            
            if abs(target[axis] - root.value[axis]) < self.distance(target, best):
                best = self.nearestNeighbor(root.right, target, height + 1, best)
        else:
            best = self.nearestNeighbor(root.right, target, height + 1, best)
            if abs(target[axis] - root.value[axis]) < self.distance(target, best):
                best = self.nearestNeighbor(root.left, target, height + 1, best)

        return best


def readDataFromFile(filename):
    dataPoints = []
    try:
        with open(filename, "r") as file:
            for line in file:
                parts = line.strip().split(",")
                if len(parts) == 2:
                    dataPoints.append([int(parts[0]), int(parts[1])])
    except FileNotFoundError:
        print(f"File {filename} not found. Using default data points.")
    return dataPoints


def writeDataToFile(filename, point):
    with open(filename, "a") as file:
        file.write(f"{point[0]},{point[1]}\n")


dataFile = "data.txt"
dataPoints = readDataFromFile(dataFile)


tree = KDTree()
tree.root = tree.buildTree(dataPoints)


print("Initial KD-Tree:")
tree.printTree(tree.root)









target_point = list(map(int, input("\nEnter target point to find nearest neighbor (x,y): ").split(",")))
nearest = tree.nearestNeighbor(tree.root, target_point)
print(f"\nNearest neighbor to {target_point} is {nearest}")
