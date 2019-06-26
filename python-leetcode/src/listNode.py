class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

    def __str__(self) -> str:
        if self.next == None:
            return str(self.val)
        else:
            return str(self.val) + " > " + str(self.next)