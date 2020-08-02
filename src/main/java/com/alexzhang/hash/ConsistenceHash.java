package com.alexzhang.hash;

import com.alibaba.druid.util.FnvHash;

import java.util.*;

public class ConsistenceHash {

    // 物理节点集合
    private List<String> realNodes = new ArrayList<>();
    // 虚拟节点数，用户指定
    private int viretalNums = 100;
    // 物理节点与虚拟节点的对应关系存储
    private Map<String,List<Integer>> real2VirtualMap = new HashMap<>();
    // 排序存储结构红黑树，key是虚拟节点的hash值，value是物理节点
    private SortedMap<Long,String> sortedMap = new TreeMap<>();

    public ConsistenceHash(int viretalNums) {
        super();
        this.viretalNums = viretalNums;
    }

    public ConsistenceHash() {
        super();
    }

    /**
     * 添加物理节点
     * @param node
     */
    public void addService(String node){
        String vnode = null;
        int i = 0;
        for (int count=0;count<viretalNums;){
            i++;
            vnode = node+"-"+i;
            long hashValue = FnvHash.fnv1a_64(vnode);
            if (!this.sortedMap.containsKey(hashValue)){
                count++;
                this.sortedMap.put(hashValue,node);
            }
        }
        this.realNodes.add(node);
    }

    /**
     * 删除物理节点
     * @param node
     */
    public void removeService(String node){

    }

    /**
     * 获取数据的存取节点
     * @param key
     * @return
     */
    public String getService(String key){
        long hash = FnvHash.fnv1a_64(key);
        SortedMap<Long,String> map = this.sortedMap.tailMap(hash);
        if (map.isEmpty()){
            return this.sortedMap.get(sortedMap.firstKey());
        }else{
            return map.get(map.firstKey());
        }
    }


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ConsistenceHash consistenceHash = new ConsistenceHash();
        consistenceHash.addService("193.168.1.10");
        consistenceHash.addService("193.168.1.11");
        consistenceHash.addService("193.168.1.12");
        for (int i =0;i<100;i++){
            System.out.println("a"+i+" 对应的服务器："+consistenceHash.getService("a"+i));
        }
    }


}