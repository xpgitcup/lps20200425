/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.cup.lps20200425;

import cn.edu.cup.hydraulic.Pipeline;

/**
 *
 * @author LiXiaoping
 */
public class LpsMain {

    public static void main(String[] args) {
        System.out.println("液体管道模拟，2020 04 25.");
        
        String dataPath = "e:/temp/test20200419B";
        String name = "秦京线aa";

        // 创建
        Pipeline pipeline = new Pipeline(name);
        pipeline.setDataPath(dataPath);
        pipeline.importFromFile();
        pipeline.autoCreatePipe();
        pipeline.fillSampleData(11);

        System.out.println("获取：\"" + pipeline.getModel() + "\"数据.");

        System.out.println("计算完成.");
        
        pipeline.setModel("格拉线副本");
        pipeline.exportToFile();

        System.out.println("复制：\"" + pipeline.getModel() + "\"数据 ok.");
        
    }
}
