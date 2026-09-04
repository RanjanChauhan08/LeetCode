        if not root:

            return []

        return tree_to_list(root.left) + [root.val] + tree_to_list(root.right)