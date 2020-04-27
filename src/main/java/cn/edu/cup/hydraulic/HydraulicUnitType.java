/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.cup.hydraulic;

/**
 *
 * @author LiXiaoping
 */
public enum HydraulicUnitType {
    Undefined,
    Pipeline,  // 枝状管网
    Pipe,
    Station,
    Source,
    Sink,
    Pump,
    IdealPump,
    CentrifugalPump,
    ReciprocatingPump,
    CustomValve,
    RegulatingValve,
    CutOffValve,
    PressureReliefValve,
    SafetyValve,
    ReliefValve,
    Heater,
    Flowmeter,
    Tank    
}
