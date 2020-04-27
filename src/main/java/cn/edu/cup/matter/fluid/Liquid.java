package cn.edu.cup.matter.fluid;

import cn.edu.cup.matter.CustomMatter;
import cn.edu.cup.matter.MatterType;

public class Liquid extends CustomMatter {

    private double pressure;
    private double temperature;
    private double[] density;
    private double[] viscosity;
    private double[] compressionCoefficient;
    private double[] saturatedVaporPressure;
    private double[] heatCapacity;

    public Liquid(String s) {
        super(s);
        setMatterType(MatterType.Liquid);
    }

    @Override
    protected void setupRawData() {
        super.setupRawData();
        getRawData().newVector("密度", "kg/m3", 1000.0);
        getRawData().newVector("粘度", "Pa.s", 1e-3);
        getRawData().newVector("压缩系数", "MPa", 1e-3);
        getRawData().newVector("饱和蒸汽压", "MPa", 0.004);
        getRawData().newVector("热容", "j/(kg.k)", 1852);
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double[] getDensity() {
        return density;
    }

    public void setDensity(double[] density) {
        this.density = density;
    }

    public double[] getViscosity() {
        return viscosity;
    }

    public void setViscosity(double[] viscosity) {
        this.viscosity = viscosity;
    }

    public double[] getCompressionCoefficient() {
        return compressionCoefficient;
    }

    public void setCompressionCoefficient(double[] compressionCoefficient) {
        this.compressionCoefficient = compressionCoefficient;
    }

    public double[] getSaturatedVaporPressure() {
        return saturatedVaporPressure;
    }

    public void setSaturatedVaporPressure(double[] saturatedVaporPressure) {
        this.saturatedVaporPressure = saturatedVaporPressure;
    }

    public double[] getHeatCapacity() {
        return heatCapacity;
    }

    public void setHeatCapacity(double[] heatCapacity) {
        this.heatCapacity = heatCapacity;
    }
}
