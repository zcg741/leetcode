class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self) -> str:
        return str(self.val) + " > " + str(self.left) + " > " + str(self.right)

