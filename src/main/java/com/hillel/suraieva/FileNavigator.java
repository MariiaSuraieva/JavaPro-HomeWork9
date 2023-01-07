package com.hillel.suraieva;

import java.util.*;


public class FileNavigator {
    //static Map<String, List<FileData>> map = new HashMap<>();
    public static void main(String[] args) throws Exception {
        Map<String, List<FileData>> map = new HashMap<>();
        String path7 = "/java/hw7";
        String path8 = "/java/hw8";
        String path9 = "/java/hw9";
        FileData fileData1 = new FileData("SomeData1", "/java/hw7", 16);
        FileData fileData2 = new FileData("SomeData2", "/java/hw7", 32);
        FileData fileData3 = new FileData("SomeData3", "/java/hw7", 64);
        FileData fileData4 = new FileData("SomeData4", "/java/hw8", 128);
        FileData fileData5 = new FileData("SomeData5", "/java/hw8", 256);
        FileData fileData6 = new FileData("SomeData6", "/java/hw9", 512);

        add(map, fileData1, fileData1.path);
        add(map, fileData2, fileData2.path);
        add(map, fileData3, fileData3.path);
        add(map, fileData4, fileData4.path);
        add(map, fileData5, fileData5.path);
        add(map, fileData6, fileData6.path);
        System.out.println("----Map----");

        System.out.println("----List by path----");
        System.out.println(find(map, path8));

        System.out.println("----Filtered by size----");
        System.out.println(filterBySize(map, 256));

        System.out.println("----Remove----");
        System.out.println(remove(map, path7));

        System.out.println("----Sort----");
        System.out.println(sortBySize(map));


    }

    public static Map<String, List<FileData>> add(Map<String, List<FileData>> map, FileData fileData, String path) throws Exception{
        if (path == fileData.getPath()) {
            if (map.containsKey(path)) {
                List<FileData> fileDataList = map.get(path);
                fileDataList.add(fileData);
            } else {
                List<FileData> fileDataListNew = new ArrayList<>();
                fileDataListNew.add(fileData);
                map.put(path, fileDataListNew);
            }
        }else throw new Exception("The path is wrong");


        return map;
    }

    public static List<FileData> find(Map<String, List<FileData>> map, String path) {
        List<FileData> listFound = new ArrayList<>();
        listFound = map.get(path);
        return listFound;

    }

    public static List<FileData> filterBySize(Map<String, List<FileData>> map, int size) {
        List<FileData> sortedList = new ArrayList<>();
        Set<Map.Entry<String, List<FileData>>> entries = map.entrySet();

        for (Map.Entry<String, List<FileData>> entry : entries) {
            for (FileData fileData : entry.getValue()) {
                if (fileData.getSizeBytes() <= size)
                    sortedList.add(fileData);
            }
        }
        return sortedList;
    }

    public static Map<String, List<FileData>> remove(Map<String, List<FileData>> map, String path) {
        Map<String, List<FileData>> map1 = new HashMap<>();
        map.forEach(
                (k, v) -> {
                    if (!k.equals(path)) map1.put(k, v);
                });
        return map1;
    }

    public static Map<Integer, String> sortBySize(Map<String, List<FileData>> map) {
        Map<Integer, String> treeMap = new TreeMap<>();
        Set<Map.Entry<String, List<FileData>>> entries = map.entrySet();

        for (Map.Entry<String, List<FileData>> entry : entries) {
            for (FileData fileData : entry.getValue())
                treeMap.put(fileData.getSizeBytes(), fileData.getPath() + fileData.getName());
        }

        Set<Map.Entry<Integer, String>> set = treeMap.entrySet();

        return treeMap;

    }


}
