package test;

import java.util.*;

/**
 * @author leejalen
 * @Description TODO
 * Created on 2020/11/12
 */
public class TestClass {

    public static void test(){
        /*Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(5);
        set.add(9);
        set.add(1);
        set.add(4);
        while (!set.iterator().hasNext()){
            System.out.println(set.iterator());
        }*/


        /*int[] array = {4,7,9,1,3,2,5};
        int maxNum = array[0];
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String value = "SCF" + array[i];
            map.put(array[i], value);
            if (array[i] > maxNum){
                maxNum = array[i];
            }
        }
        String maxValue = map.get(maxNum);
        System.out.println(maxValue);
        System.out.println(map);*/
    }

    /**
     * 模拟获得桶列表
     * */
    public static List<String> getBucketsName(){
        List<String> list = new ArrayList<>();
        String bucketName = "scf".concat("-").concat("doc").concat("-");
        for (int i = 0; i < 4; i++) {
            String name = bucketName + i;
            list.add(name);
        }
        for (int i = 0; i < 10; i++) {
            String name = "hmj".concat("-").concat("doc").concat("-") + i;
            list.add(name);
        }
        for (int i = 10; i >7; i--) {
            String name = bucketName + i;
            list.add(name);
        }
        for (int i = 4; i <8; i++) {
            String name = bucketName + i;
            list.add(name);
        }
        System.out.println("模拟的桶列表: "+list);
        return list;
    }

    public static Map<String, String> getBucketsInGroup(String platform, String doc){
        List<String> bucketList = getBucketsName();
        Map<String, String> map = new HashMap<>();
        String maxNum = "-1";
        for (int i = 0; i < bucketList.size(); i++) {
            String bucket = bucketList.get(i);
            String[] array = bucket.split("-");
            if (platform.equals(array[0]) && doc.equals(array[1])){
                map.put(array[2], bucket);
                if (Integer.parseInt(array[2]) > Integer.parseInt(maxNum)){
                    maxNum = array[2];
                }
            }
        }
        map.put("maxKey", maxNum);
        return map;
        /*String lastBucket = map.get(maxNum);
        System.out.println("桶列表存入map: " + map);
        System.out.println("编号最大的桶: " +lastBucket);*/
    }
    /**
     * 获得编号最大的桶
     * */
    public static void getLastBucketName(String platform, String doc){
        Map<String, String> map = getBucketsInGroup(platform, doc);
        System.out.println(map);
        String maxKey = map.get("maxKey");
        String lastBucket = map.get(maxKey);
        System.out.println(lastBucket);
    }

    public static void main(String[] args) {
        getLastBucketName("scf", "doc");
    }
}
