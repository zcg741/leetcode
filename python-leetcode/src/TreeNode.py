class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    def __str__(self) -> str:
        return self.printNode(self)

    def printNode(self,root):
        l = []
        if not root:
            return []
        q = [root]
        while len(q):
            t = q.pop(0)
            l.append(t.val)
            if t.left:
                q.append(t.left)
            if t.right:
                q.append(t.right)
        return str(l)
