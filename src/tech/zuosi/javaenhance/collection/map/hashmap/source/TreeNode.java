package tech.zuosi.javaenhance.collection.map.hashmap.source;

import java.util.HashMap;

public class TreeNode {
    /**
     * Tie-breaking utility for ordering insertions when equal
     * hashCodes and non-comparable. We don't require a total
     * order, just a consistent insertion rule to maintain
     * equivalence across rebalancings. Tie-breaking further than
     * necessary simplifies testing a bit.
     */
    static int tieBreakOrder(Object a, Object b) {
        int d;
        //如果a,b有一个为空或是a和b都是同一类的实例，则比较System.identityHashCode的返回值，否则返回默认值0
        if (a == null || b == null ||
                (d = a.getClass().getName().
                        compareTo(b.getClass().getName())) == 0)
            d = (System.identityHashCode(a) <= System.identityHashCode(b) ?
                    -1 : 1);
        return d;
    }

    /**
     * Tree version of putVal.
     */
    //如果对应key已存在映射，返回其结点，否则返回null（本方法内插入新结点）
    //putVal会处理已存在映射，其会更改该映射的值
    final HashMap.TreeNode<K,V> putTreeVal(HashMap<K,V> map, HashMap.Node<K,V>[] tab,
                                           int h, K k, V v) {
        Class<?> kc = null;
        boolean searched = false;
        HashMap.TreeNode<K,V> root = (parent != null) ? root() : this;
        //查找对应key的映射，不存在则插入新结点
        for (HashMap.TreeNode<K,V> p = root;;) {
            int dir, ph; K pk;
            //指定下一个查找的子树是左子树还是右子树，若该方向的链接指向空结点则插入新结点，否则继续查找
            if ((ph = p.hash) > h)
                dir = -1;
            else if (ph < h)
                dir = 1;
            //指定的hash同当前结点的hash相等，进一步检查key是否相等
            //先尝试判断key是否同一，再尝试判断key是否相同
            else if ((pk = p.key) == k || (k != null && k.equals(pk)))
                return p;
            //尝试通过compareTo来比较key
            else if ((kc == null &&
                    (kc = comparableClassFor(k)) == null) ||
                    (dir = compareComparables(kc, k, pk)) == 0) {
                if (!searched) {
                    HashMap.TreeNode<K,V> q, ch;
                    searched = true;
                    if (((ch = p.left) != null &&
                            (q = ch.find(h, k, kc)) != null) ||
                            ((ch = p.right) != null &&
                                    (q = ch.find(h, k, kc)) != null))
                        return q;
                }
                //尝试利用System.identityHashCode的返回值来比较
                dir = tieBreakOrder(k, pk);
            }

            HashMap.TreeNode<K,V> xp = p;
            if ((p = (dir <= 0) ? p.left : p.right) == null) {
                //若该方向的链接指向空结点，则创建并插入新结点
                HashMap.Node<K,V> xpn = xp.next; //保存next变量信息
                HashMap.TreeNode<K,V> x = map.newTreeNode(h, k, v, xpn);
                //将新结点作为新的左结点或右结点
                if (dir <= 0)
                    xp.left = x;
                else
                    xp.right = x;
                //即 将x加入xp链表中（plain node需要）
                xp.next = x;
                x.parent = x.prev = xp;
                if (xpn != null)
                    ((HashMap.TreeNode<K,V>)xpn).prev = x;
                //确保红黑树的根结点位于链表的头部（即tab[]中的结点）
                moveRootToFront(tab, balanceInsertion(root, x));
                return null;
            }
        }
    }

    static <K,V> HashMap.TreeNode<K,V> rotateLeft(HashMap.TreeNode<K,V> root,
                                                  HashMap.TreeNode<K,V> p) {
        //向左旋转
        HashMap.TreeNode<K,V> r, pp, rl;
        if (p != null && (r = p.right) != null) {
            //当前结点及其右结点都不为空
            if ((rl = p.right = r.left) != null)
                rl.parent = p;
                /*
                等效于
                p.right = r.left;
                rl = r.left;
                if (rl != null) rl.parent = p;
                */
            if ((pp = r.parent = p.parent) == null)
                //类比 2-3树中向单个2-结点中插入一个新键
                (root = r).red = false;
                /*
                等效于
                r.parent = p.parent;
                pp = p.parent;
                if (pp == null) {
                    root = r;
                    root.red = false;
                }
                */

            //将p替换为r，所以此处判断p是其父结点的左结点还是右结点
            else if (pp.left == p)
                pp.left = r;
            else
                pp.right = r;
            //更新链接，将r置于p与pp之间
            r.left = p;
            p.parent = r;
        }
        return root; //root的更改会作为结果传递到moveRootToFront
    }

    static <K,V> HashMap.TreeNode<K,V> rotateRight(HashMap.TreeNode<K,V> root,
                                                   HashMap.TreeNode<K,V> p) {
        //向右旋转，基本同rotateLeft行为一致，只是将left和right互换
        HashMap.TreeNode<K,V> l, pp, lr;
        if (p != null && (l = p.left) != null) {
            if ((lr = p.left = l.right) != null)
                lr.parent = p;
            if ((pp = l.parent = p.parent) == null)
                (root = l).red = false;
            else if (pp.right == p)
                pp.right = l;
            else
                pp.left = l;
            l.right = p;
            p.parent = l;
        }
        return root;
    }

    //红黑树中红链接向上传递
    //插入新结点后使红黑树保持平衡
    static <K,V> HashMap.TreeNode<K,V> balanceInsertion(HashMap.TreeNode<K,V> root,
                                                        HashMap.TreeNode<K,V> x) {
        x.red = true;
        for (HashMap.TreeNode<K,V> xp, xpp, xppl, xppr;;) {
            if ((xp = x.parent) == null) {
                //没有父结点，那么该结点为根结点，其总是黑色的
                x.red = false;
                return x;
            }
            else if (!xp.red || (xpp = xp.parent) == null)
                //父结点为黑色 或 父结点为根结点且为红色(异常情况? 短路或执行到后面
                //  说明前面的布尔表达式为假，在这里就是说父节点为红色。 难道说这里
                //   父结点没有父结点并不一定是根节点?)
                return root;
            //执行到这里说明： xp != null && xp.red == true && xpp != null
            if (xp == (xppl = xpp.left)) {
                //父结点是祖父结点的左结点
                if ((xppr = xpp.right) != null && xppr.red) {
                    /*
                    祖父结点的右链接指向红色结点

                    将组父结点变为红色，父结点和祖父结点的右结点变为黑色
                    类比 2-3树中分解4-结点的情况
                     A  E  S              E
                    / /  \  \    =>     /   \
                                       A     S
                                      / \   / \
                     */
                    xppr.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x = xpp;
                    //将x指向祖父结点，也就是下次循环以祖父结点为起点进行操作
                }
                else {
                    //执行到这里说明： xp != null && xp.red == true && xpp != null
                    //执行到这里说明： xppr == null || xppr.red == false
                    if (x == xp.right) {
                        //该结点是父结点的右结点，从前面的布尔表达式可知x为红色，所以向左旋转
                        //结合红黑树性质，即 如果右子结点是红色的而左子结点是黑色的，进行左旋转
                        root = rotateLeft(root, x = xp);
                        //更新xp和xpp的指向，因为之前的语句更改了x的指向
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {
                        //父结点不为空
                        xp.red = false;
                        if (xpp != null) {
                            //祖父结点不为空
                            //类比 向3-结点插入一个新键，而新键最小
                            xpp.red = true;
                            root = rotateRight(root, xpp);
                        }
                    }
                }
            }
            else {
                //执行到这里说明： xp != null && xp.red == true && xpp != null && xp == xpp.right
                if (xppl != null && xppl.red) {
                    //此处xp == xpp.right
                    //转换一个结点的两个红色结点的颜色，同时也要将父结点的颜色由黑变红
                    //即 如果左右子结点均为红色，进行颜色转换
                    xppl.red = false;
                    xp.red = false;
                    xpp.red = true;
                    x = xpp;
                }
                else {
                    //执行到这里说明： xp != null && xp.red == true && xpp != null && xp == xpp.right
                    //  && (xpp == null || (xpp != null && xppl.red == false))
                    if (x == xp.left) {
                        //该结点是父结点的左结点，从前面的布尔表达式可知x为红色，所以向右旋转
                        //即 如果左子结点是红色的且它的左子结点也是红色的，进行右旋转
                        root = rotateRight(root, x = xp);
                        //更新xp和xpp的指向，因为之前的语句更改了x的指向
                        xpp = (xp = x.parent) == null ? null : xp.parent;
                    }
                    if (xp != null) {
                        //父结点不为空
                        xp.red = false;
                        if (xpp != null) {
                            //祖父结点不为空
                            //类比 向3-结点插入一个新键，而新键介于两者之间
                            xpp.red = true;
                            root = rotateLeft(root, xpp);
                        }
                    }
                }
            }
        }
    }
}
