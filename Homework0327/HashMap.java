package Homework0327;

class HashNode {
    public int key;
    public int value;
    HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class HashMap {
    //哈希表的核心是有一个数组, 数组上的每个元素又是一个链表！
    private HashNode[] array = new HashNode[16];
    private int size = 0;

    // 通过hashCode()方法, 把 key 映射成数组下标，
    // 此处是选用简单求余. 实际上可以根据情况选取更复杂的计算方式，比如根据 key 计算 md5 值再求余！
    private int hashCode(int key) {
        return key % array.length;
    }

    //1.put()方法，用于插入新元素
    public void put(int key, int value) {
        //a.先根据key, 计算出下标位置，即要插入的位置！
        int index = hashCode(key);
        //b.判断 key 在 hash 表中是否存在
        //如果存在, 就直接修改 value, 如果不存在，则直接插入新节点！
        for (HashNode cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                //说明找到了相同 key 值的元素, 直接修改 value。
                cur.value = value;
                return;
            }
        }
        //c.如果经过上面的循环, 没有找到匹配的 key, 就该 key 不存在,
        //就需要创建新的节点插入到链表上去(头插)
        HashNode newNode = new HashNode(key, value);
        newNode.next = array[index];
        array[index] = newNode;
        size++;
        // d.如果持续插入, 就可能导致冲突概率越来越大, 链表越来越长,
        // 就会影响到后续操作的效率, 就可以考虑进行扩容;
        // 为了衡量啥时候扩容 , 引入一个概念, "负载因子"(loadFactor),用（元素个数 / 数组长度）表示！
        if (loadFactor() > 0.75) {
            // 认为比较拥挤了, 就要进行扩容了，0.75的数值是根据实际需要进行改变！
            resize();
        }
    }

    private double loadFactor() {
        return (double)size / array.length;
    }

    //对数组进行扩容，需要把旧的元素进行搬运！
    private void resize() {
        //数组扩容的具体大小视情况而定！
        HashNode[] newArray = new HashNode[array.length * 2];
        // 遍历旧的hash表, 进行搬运。
        for (int i = 0; i < array.length; i++) {
            HashNode next = null;
            for (HashNode cur = array[i]; cur != null; cur = next) {
                next = cur.next;
                int newIndex = cur.key % newArray.length;
                // 把当前 cur 对应的节点给插入到新的数组上；
                cur.next = newArray[newIndex];
                newArray[newIndex] = cur;
            }
        }
        array = newArray;
    }

    //2.get()方法，用于获取元素
    public Integer get(int key) {
        int index = hashCode(key);
        // 遍历对应的链表
        for (HashNode cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }

    //3.remove()方法，用来删除元素
    public void remove(int key) {
        int index = get(key);
        HashNode loc = array[index];
        if (loc != null) {
            HashNode perv = null;
            while (loc != null) {
                if (loc.key == key) {
                    if (perv != null) {
                        perv.next = loc.next;
                    } else {
                        array[index] = loc.next;
                    }
                    return;
                }
                perv = loc;
                loc = loc.next;
            }
        }
    }
}
