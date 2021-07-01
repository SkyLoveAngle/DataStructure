package Homework0327;
import java.util.ArrayList;
import java.util.List;


public class MyHashMap {
}

class MyHashSet {
    private MyHashMap<Integer,Object> map;
    /** Initialize your data structure here. */
    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public void add(int key) {
        map.add(key,null);
    }

    public void remove(int key) {
        map.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return map.contains(key);
    }
    class MyHashMap<K,V> {
        class LinkNode<K,V>{
            K key;
            V val;
            int hash;
            //这个node之后有多少个node
            int size;
            LinkNode<K,V> next;

            public LinkNode(K key, V val, int hash) {
                this.key = key;
                this.val = val;
                this.hash = hash;
            }

            public LinkNode() {
            }


        }
        //默认数组大小
        private final int DEFAULT_SLOTSIZE = 64;
        //当链表长度大于TRANS_SIZE时，转换成跳表
        private final int TRANS_SIZE = 8;
        //当跳表大于CTThreshold时，重构
        private final int CTThreshold = 64;
        //当插槽到达0.75时，重构
        private final float Threshold = 0.75f;
        //当前插槽占用的数量
        private float slotSize = 0;
        private LinkNode<K,V>[] slots;
        private int size;
        /** Initialize your data structure here. */
        public MyHashMap() {
            slots = (LinkNode<K,V>[])(new LinkNode[DEFAULT_SLOTSIZE]);
        }

        public void add(K key, V val) {
            if(key == null) return;
            int hash = key.hashCode();
            int n = slots.length;
            int index = hash & (n - 1);
            if(slots[index] == null){
                slots[index] = new LinkNode<>(key,val,hash);
                slotSize ++;
            }else if(slots[index] instanceof MyHashMap.SkipNode){
                if(((SkipNode<K, V>) slots[index]).put(key,val)){
                    size ++;
                }
            }else{
                LinkNode<K,V> cur = slots[index];
                while(cur != null){
                    if(cur.hash == hash){
                        cur.val = val;
                        return;
                    }
                    cur = cur.next;
                }
                cur = new LinkNode<>(key, val, hash);
                cur.size = slots[index].size + 1;
                cur.next = slots[index];
                slots[index] = cur;
                if(cur.size + 1 > TRANS_SIZE){
                    slots[index] = transSkipTable(cur);
                }
                size ++;
            }
            if(slotSize / n > Threshold || slots[index].size > CTThreshold){
                slots = resize();
            }
        }

        public V get(K key){
            if(key == null) return null;
            int hash = key.hashCode();
            int n = slots.length;
            int index = hash & (n - 1);
            if(slots[index] != null){
                if(slots[index] instanceof MyHashMap.SkipNode){
                    return ((SkipNode<K, V>) slots[index]).get(key);
                }else{
                    LinkNode<K,V> cur = slots[index];
                    while(cur != null){
                        if(cur.hash == hash){
                            return cur.val;
                        }
                        cur = cur.next;
                    }
                }
            }
            return null;
        }



        public void remove(K key) {
            if(key == null) return;
            int hash = key.hashCode();
            int n = slots.length;
            int index = hash & (n - 1);
            if(slots[index] != null){
                if(slots[index] instanceof MyHashMap.SkipNode){
                    if(((SkipNode<K, V>) slots[index]).remove(key)){
                        size --;
                    }

                }else{
                    if(slots[index].hash == hash){
                        slots[index] = slots[index].next;
                        size --;
                        if(slots[index] == null) slotSize--;
                        return;
                    }
                    LinkNode<K,V> pre = slots[index];
                    LinkNode<K,V> next = pre.next;
                    while(next != null && next.hash != hash){
                        pre = next;
                        next = next.next;
                    }
                    if(next != null){
                        //前面的size都要减1
                        LinkNode<K,V> head = slots[index];
                        while(head != next){
                            head.size --;
                            head = head.next;
                        }
                        pre.next = next.next;
                        size --;
                    }
                }
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(K key) {
            if(key == null) return false;
            int hash = key.hashCode();
            int n = slots.length;
            int index = hash & (n - 1);
            if(slots[index] != null){
                if(slots[index] instanceof MyHashMap.SkipNode){
                    return ((SkipNode<K, V>) slots[index]).containsKey(key);
                }else{
                    LinkNode<K,V> cur = slots[index];
                    while(cur != null){
                        if(cur.hash == hash){
                            return true;
                        }
                        cur = cur.next;
                    }

                }
            }
            return false;
        }

        public LinkNode<K,V>[] resize(){
            LinkNode<K,V>[] table; int n,oldN;
            slotSize = 0;
            if((table = slots) == null || table.length == 0){
                table = (LinkNode<K,V>[])new LinkNode[DEFAULT_SLOTSIZE];
            }else if(table.length > (2 << 10)){
                return slots;
            }else {
                int newCap = table.length << 1;
                table = (LinkNode<K,V>[])new LinkNode[newCap];
                for(int i = 0; i < slots.length; i ++){
                    if(slots[i] == null) continue;
                    if(slots[i] instanceof MyHashMap.SkipNode){
                        ((SkipNode<K, V>) slots[i]).splitTable(table);
                    }else{
                        LinkNode<K,V> cur = slots[i];
                        while(cur != null){
                            LinkNode<K,V> next = cur.next;
                            int index = cur.hash & (newCap - 1);
                            if(table[index] == null)slotSize++;
                            cur.next = table[index];
                            table[index] = cur;
                            cur = next;
                        }
                    }
                }
            }
            return table;

        }
        private SkipNode<K,V> transSkipTable(LinkNode<K,V> cur) {
            SkipNode<K,V> head = new SkipNode<>();
            while(cur != null){
                head.put(cur.key,cur.val);
                cur = cur.next;
            }
            return head;
        }


        class SkipNode<K,V> extends LinkNode<K,V> {
            List<SkipNode<K,V>> nexts;
            int height;

            public SkipNode(K key, V val,int hash) {
                super(key, val,hash);
                nexts = new ArrayList<>();
                height = 0;
                nexts.add(null);
                size = 0;
            }

            public SkipNode() {
                nexts = new ArrayList<>();
                height = 0;
                nexts.add(null);
                size = 0;
            }

            public boolean put(K key, V val){
                if(key == null){
                    return false;
                }
                int hash = key.hashCode();
                SkipNode<K, V> lastSam = getLastBigByTree(key);
                SkipNode<K, V> find = lastSam.nexts.get(0);
                if(find != null && find.hash == hash){
                    find.val = val;
                    return false;
                }else{
                    //生成新的节点
                    SkipNode<K, V> newNode = new SkipNode<>(key,val,hash);
                    int newLevel = 0;
                    while(Math.random() < 0.5){
                        newLevel ++;
                    }
                    for(int i = 0; i < newLevel; i ++){
                        newNode.nexts.add(null);
                    }
                    if(newLevel > height){
                        for(int i = height; i < newLevel; i ++){
                            this.nexts.add(null);
                        }
                        height = newLevel;
                    }
                    int curHeight = height;
                    SkipNode<K, V> cur = this;
                    while(curHeight >= 0){
                        SkipNode<K, V> pre = getLastSmallByLevel(curHeight, cur, hash);
                        //到可以加的那层才可以连接
                        if(curHeight <= newLevel){
                            newNode.nexts.set(curHeight,pre.nexts.get(curHeight));
                            pre.nexts.set(curHeight,newNode);
                        }
                        curHeight--;
                    }
                }
                size ++;
                return true;
            }
            public boolean remove(K key){
                if(get(key) != null){
                    int curHeight = height;
                    int hash = key.hashCode();
                    SkipNode<K, V> cur = this;
                    while(curHeight >= 0){
                        SkipNode<K, V> pre = getLastSmallByLevel(curHeight, cur, hash);
                        SkipNode<K, V> find = pre.nexts.get(curHeight);
                        if(find != null && find.hash == hash){
                            pre.nexts.set(curHeight,find.nexts.get(curHeight));
                        }
                        if(pre == this && pre.nexts.get(curHeight) == null){
                            pre.nexts.remove(curHeight);
                            height --;
                        }
                        curHeight --;

                    }
                    size--;
                    return true;
                }
                return false;
            }

            public V get(K key){
                if(key == null){
                    return null;
                }
                int hash = key.hashCode();
                SkipNode<K, V> lastSam = getLastBigByTree(key);
                SkipNode<K, V> find = lastSam.nexts.get(0);
                if(find != null && find.hash == hash){
                    return find.val;
                }
                return null;
            }
            public boolean containsKey(K key){
                if(key == null){
                    return false;
                }
                int hash = key.hashCode();
                SkipNode<K, V> lastSam = getLastBigByTree(key);
                SkipNode<K, V> find = lastSam.nexts.get(0);
                return find != null && find.hash == hash;
            }

            public void splitTable(LinkNode<K, V>[] table) {
                SkipNode<K, V> cur = this.nexts.get(0);
                int n = table.length;
                while(cur != null){
                    SkipNode<K, V> next = cur.nexts.get(0);
                    int index = cur.hash & (n - 1);
                    LinkNode<K,V> node = new LinkNode<>(cur.key,cur.val,cur.hash);
                    if(table[index] == null)slotSize++;
                    node.next = table[index];
                    table[index] = node;
                    cur = next;
                }
            }

            private SkipNode<K,V> getLastBigByTree(K key){
                int curHeight = height;
                SkipNode<K,V> cur = this;
                int hash = key.hashCode();
                while(curHeight >= 0){
                    cur = getLastSmallByLevel(curHeight--, cur, hash);
                }
                return cur;
            }

            private SkipNode<K,V> getLastSmallByLevel(int level, SkipNode<K,V> cur, int hash){
                SkipNode<K,V> next = cur.nexts.get(level);
                while(next != null && next.hash < hash){
                    cur = next;
                    next = next.nexts.get(level);
                }
                return cur;
            }
        }

    }

}


