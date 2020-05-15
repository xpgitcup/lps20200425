package cn.edu.cup.matter.fluid;

import cn.edu.cup.matter.CustomMatter;
import cn.edu.cup.matter.MatterType;
import cn.edu.cup.physics.CommonConst;

public class Gas extends CustomMatter {

    private double pressure;
    private double temperature;
    private double[] density;
    private double[] viscosity;
    private double[] heatCapacity;
    
    public Gas(String s) {
        super(s);
        setMatterType(MatterType.Gas);
        pressure = CommonConst.STANDARD_PRESSURE;
        temperature = CommonConst.STANDARD_TEMPERATURE;
    }
    
    @Override
    protected void setupRawData() {
        super.setupRawData();
        getRawData().newVector("密度", "kg/m3", new double[]{1000.0});
        getRawData().newVector("粘度", "Pa.s", new double[]{1e-3});
        getRawData().newVector("热容", "j/(kg.k)", new double[]{1852});
    }

    /*
     * 状态参数
     * */
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
    /*
     * 物性参数的计算
     * */
    public double getDensity() {
        return getPropertyPolies().get("density").value(temperature);
    }

    public void setDensity(double[] density) {
        this.density = density;
    }

    public double getViscosity() {
        return getPropertyPolies().get("viscosity").value(temperature);
    }

    public void setViscosity(double[] viscosity) {
        this.viscosity = viscosity;
    }

    public double getHeatCapacity() {
        return getPropertyPolies().get("heatCapacity").value(temperature);
    }

    public void setHeatCapacity(double[] heatCapacity) {
        this.heatCapacity = heatCapacity;
    }

}
