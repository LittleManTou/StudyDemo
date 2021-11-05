//import com.mantou.entity.Node;
//
//import javax.swing.tree.TreeNode;
//import java.io.Serializable;
//import java.util.AbstractMap;
//
//public class HashMap<K,V> extends AbstractMap<K,V>
//	implements Map<K,V>, Cloneable, Serializable {   //1.实现了两个Map接口,重复
//	//3.部分属性
//	static final float DEFAULT_LOAD_FACTOR = 0.75f;     //加载因子
//	final float loadFactor;     //接收加载因子
//	transient Node<K,V>[] table;   //主数组
//	//2.调用空参构造
//	public HashMap() {
//        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
//    }
//	//4.调用有参构造
//	public HashMap(int initialCapacity) {
//        this(initialCapacity, DEFAULT_LOAD_FACTOR);
//    }
//	//5.跳到这个HashMap
//	public HashMap(int initialCapacity, float loadFactor) {  // 10 , 0.75
//		//6.健壮性处理
//        if (initialCapacity < 0)
//            throw new IllegalArgumentException("Illegal initial capacity: " +
//                                               initialCapacity);
//        if (initialCapacity > MAXIMUM_CAPACITY)
//            initialCapacity = MAXIMUM_CAPACITY;
//        if (loadFactor <= 0 || Float.isNaN(loadFactor))
//            throw new IllegalArgumentException("Illegal load factor: " +
//                                               loadFactor);
//		//7.loadFactor = 0.75
//        this.loadFactor = loadFactor;
//		//8.调用tableSizeFor(10)
//        this.threshold = tableSizeFor(initialCapacity);
//    }
//	//9.tableSizeFor  这个方法确定主数组的长度   --->  这个方法的返回结果是最接近cap参数的2的n次幂
//	static final int tableSizeFor(int cap) {    //10
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//
//	//10.调用put方法
//	public V put(K key, V value) {   // 通话 ， 10
//        return putVal(hash(key), key, value, false, true);
//    }
//	//11.调用hash方法
//	static final int hash(Object key) {   //返回哈希码
//        int h;
//        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//    }
//	//12.进入putVal
//	final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                   boolean evict) {       //  哈希码，通话 ，10 ，false ，true
//        Node<K,V>[] tab; Node<K,V> p; int n, i;
//		//13.进入if条件，tab指向 table这个主数组
//        if ((tab = table) == null || (n = tab.length) == 0)   // 证实数组类型是Node[]类型 , key 和 value 封装的是Node实例
//            //14.进入resize()
//			n = (tab = resize()).length;  //22.tab = newTab  n = 16
//			//23.经过公式(n - 1) & hash 算出键值对存储在主数组的下标
//        if ((p = tab[i = (n - 1) & hash]) == null)  //24. 进入if
//            tab[i] = newNode(hash, key, value, null); //25.调用newNode方法 封装Node对象，然后赋值给tab[i] ，到此第一组键值对存入map
//        else {
//            Node<K,V> e; K k;
//			//27.第二组 通话键值对 产生哈希碰撞 ，进入 if
//			//30.重地键值对 产生哈希碰撞 但是key不同 不进入 if
//            if (p.hash == hash &&
//                ((k = p.key) == key || (key != null && key.equals(k))))  //key 是 String 的好处就是不用进行后边的equals方法
//                e = p;
//            else if (p instanceof TreeNode)
//                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//            else {  //31.前两个条件都不满足，进入这个死循环
//                for (int binCount = 0; ; ++binCount) {  // binCount 是桶的个数 ，尾插法
//                    if ((e = p.next) == null) {  //32. p.next == null 条件满足 进入条件
//                        p.next = newNode(hash, key, value, null); // 33.p.next 指向 新封装的重地的Node对象 尾插法
//                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                            treeifyBin(tab, hash);    //如果大于8个就转化成树
//                        break;
//                    }
//                    if (e.hash == hash &&
//                        ((k = e.key) == key || (key != null && key.equals(k))))
//                        break;
//                    p = e;
//                }
//            }
//			//28.e -- > p   e != null 进入 if
//            if (e != null) { // existing mapping for key
//                V oldValue = e.value;
//                if (!onlyIfAbsent || oldValue == null)
//                    e.value = value;   // 29. 将冲突的value改为新的value
//                afterNodeAccess(e);
//                return oldValue;   //把旧值返回
//            }
//        }
//        ++modCount;
//        if (++size > threshold)
//            resize();
//        afterNodeInsertion(evict);
//        return null;
//    }
//
//	//15.进入resize()
//	final Node<K,V>[] resize() {
//        Node<K,V>[] oldTab = table;    //table:null    oldTap:null
//        int oldCap = (oldTab == null) ? 0 : oldTab.length;   //oldCap:0
//        int oldThr = threshold;	// oldThr:16
//        int newCap, newThr = 0;
//        if (oldCap > 0) {  //16.这个if不进入
//            if (oldCap >= MAXIMUM_CAPACITY) {
//                threshold = Integer.MAX_VALUE;
//                return oldTab;
//            }
//            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
//                     oldCap >= DEFAULT_INITIAL_CAPACITY)
//                newThr = oldThr << 1; // double threshold
//        } //17.进入这个if条件
//        else if (oldThr > 0) // initial capacity was placed in threshold
//            newCap = oldThr; // newCap : 16
//        else {               // zero initial threshold signifies using defaults
//            newCap = DEFAULT_INITIAL_CAPACITY;
//            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
//        }//18.进入
//        if (newThr == 0) {
//            float ft = (float)newCap * loadFactor;  // 16 * 0.75 = 12   ft = 12
//            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
//                      (int)ft : Integer.MAX_VALUE);  // newThr : 12
//        }
//        threshold = newThr;  //threshold = 12
//        @SuppressWarnings({"rawtypes","unchecked"})
//		//19.创建了一个长度为16的Node数组
//        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
//        table = newTab;  //20.主数组长度确定为16
//        if (oldTab != null) {   //21.这个if不进入
//            for (int j = 0; j < oldCap; ++j) {
//                Node<K,V> e;
//                if ((e = oldTab[j]) != null) {
//                    oldTab[j] = null;
//                    if (e.next == null)
//                        newTab[e.hash & (newCap - 1)] = e;
//                    else if (e instanceof TreeNode)
//                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        Node<K,V> loHead = null, loTail = null;
//                        Node<K,V> hiHead = null, hiTail = null;
//                        Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
//                }
//            }
//        }
//        return newTab;
//    }
//
//	//26.封装Node对象
//	Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
//        return new Node<>(hash, key, value, next);
//    }
//
//
//	//如果链表大于8个元素则进行树化
//	final void treeifyBin(Node<K,V>[] tab, int hash) {
//        int n, index; Node<K,V> e;
//        if (tab == null || (n = tab.length) < MIN_TREEIFY_CAPACITY)    // 链表元素大于8并且主数组的长度大于64 才进行树化
//            resize();
//        else if ((e = tab[index = (n - 1) & hash]) != null) {
//            TreeNode<K,V> hd = null, tl = null;
//            do {
//                TreeNode<K,V> p = replacementTreeNode(e, null);
//                if (tl == null)
//                    hd = p;
//                else {
//                    p.prev = tl;
//                    tl.next = p;
//                }
//                tl = p;
//            } while ((e = e.next) != null);
//            if ((tab[index] = hd) != null)
//                hd.treeify(tab);
//        }
//    }
//
//}
