/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.cup.lps20200425;

import cn.edu.cup.hydraulic.Pipeline;
import cn.edu.cup.matter.fluid.Gas;
import cn.edu.cup.matter.fluid.Liquid;

/**
 *
 * @author LiXiaoping
 */
public class LpsMain {

    public static void main(String[] args) {
        System.out.println("液体管道模拟，2020 04 25.");
        
        String dataPath = "e:/temp/test20200419B";
        String name = "秦京线20200427";

        // 创建
        Pipeline pipeline = new Pipeline(name);
        pipeline.setDataPath(dataPath);
        pipeline.importFromFile();
//        pipeline.autoCreatePipe();
//        pipeline.fillSampleData(11);

        System.out.println("获取：\"" + pipeline.getModel() + "\"数据.");

        pipeline.display();

        System.out.println("计算完成.");

        Liquid liquid = new Liquid("一种油");
        liquid.setDataPath(dataPath);
        liquid.importFromFile();

        System.out.println("下面是液体计算：");
        liquid.setTemperature(122.0);
        System.out.printf("密度 %.4f\n", liquid.getDensity());
        System.out.printf("粘度 %.4f\n", liquid.getViscosity());
        System.out.printf("压缩系数 %.4f\n", liquid.getCompressionCoefficient());
        System.out.printf("饱和蒸汽压 %.4f\n", liquid.getSaturatedVaporPressure());
        System.out.printf("热容 %.4f\n", liquid.getHeatCapacity());

        Gas gas = new Gas("一种气体");
        gas.setDataPath(dataPath);
        gas.importFromFile();

        System.out.println("下面是气体计算：");
        System.out.printf("密度 %.4f\n", gas.getDensity());
        System.out.printf("粘度 %.4f\n", gas.getViscosity());
        System.out.printf("热容 %.4f\n", gas.getHeatCapacity());

//        pipeline.setModel("格拉线副本");
//        pipeline.exportToFile();
//
//        System.out.println("复制：\"" + pipeline.getModel() + "\"数据 ok.");
        
    }
}
